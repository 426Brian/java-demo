package com.zookeeper.provider;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Brian in 21:06 2018/5/17
 */
public class ServiceProvider {
    // 用于等待SyncConnected 事件触发后继续执行当前线程
    private CountDownLatch latch = new CountDownLatch(1);

    // 发布 RMI 服务并注册 RMI 地址到 Zookeeper 中
    public void publish(Remote remote, String host, int port) {
        String url = publishService(remote, host, port);
        if (url != null) {
            ZooKeeper zk = connectServer();
            if(zk != null){
                createNode(zk, url);
            }
        }
    }

    // 发布 RMI 服务
    private String publishService(Remote remote, String host, int port) {
        String url = null;
        url = String.format("rmi://%s:%d/%s", host, port, remote.getClass().getName());
        try {
            LocateRegistry.createRegistry(port);
            Naming.rebind(url, remote);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    // 连接Zookeeper 服务器
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

            latch.await();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return zk;
    }

    // 创建 ZNode
    private void createNode(ZooKeeper zk, String url){
        byte[] data = url.getBytes();
        try {
            String path = zk.create(Constant.ZK_PROVIDER_PATH, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
