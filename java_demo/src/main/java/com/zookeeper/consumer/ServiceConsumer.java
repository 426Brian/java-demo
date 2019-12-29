package com.zookeeper.consumer;

import com.zookeeper.provider.Constant;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Brian in 21:49 2018/5/17
 */
public class ServiceConsumer {
    // 用于等待SyncConnected 事件触发后继续执行当前线程
    private CountDownLatch latch = new CountDownLatch(1);
    private volatile List<String> urlList = new ArrayList<>();

    // 构造器
    public ServiceConsumer() {
        ZooKeeper zk = connectServer();
        if (zk != null) {
            watchNode(zk);
        }
    }

    // 查找 RMI 服务
    public <T extends Remote> T lookup(){
        T service = null;
        int size = urlList.size();
        if(size > 0){
            String url = null;
            if(size == 1){
                url = urlList.get(0);
            }else {
                url = urlList.get(ThreadLocalRandom.current().nextInt());
            }

            service = lookupService(url);
        }

        return service;
    }

    // 连接ZooKeeper 服务器
    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return zk;
    }

    // 观察 /registry 节点下所有子节点是否发生变化
    private void watchNode(ZooKeeper zk) {
        try {
            List<String> nodeList = zk.getChildren(Constant.ZK_REGISTRY_PATH, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.NodeChildrenChanged) {
                        // 若子节点有变化，则重新调用该方法(为了获取最新子节点中数据)
                        watchNode(zk);
                    }
                }
            });

            // 用于存放 /registry 所有子节点数据
            List<String> dataList = new ArrayList<>();
            for (String node : nodeList) {
                // 获取 /registry 子节点中数据
                byte[] data = zk.getData(Constant.ZK_REGISTRY_PATH + "/" + node, false, null);
                dataList.add(new String(data));
            }

            // 更新最新的 RMI 地址
            urlList = dataList;
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public <T> T lookupService(String url) {
        T remote = null;
        try {
            remote = (T) Naming.lookup(url);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            if (e instanceof ConnectException) {
                if (urlList.size() != 0) {
                    url = urlList.get(0);
                    return lookupService(url);
                }
            }
        }
        return remote;
    }
}
