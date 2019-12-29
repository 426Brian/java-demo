package com.zookeeper.consumer;

import com.rmi.advance.service.HelloService;

/**
 * Created by Brian in 22:08 2018/5/17
 */
public class Client {
    public static void main(String[] args) throws Exception{
        ServiceConsumer consumer = new ServiceConsumer();
        while(true){
            HelloService helloService = consumer.lookup();
            if(helloService != null){
                String result = helloService.sayHello("Jack");
                System.out.println("result == "+result);
            }else{
                System.out.println("consumer== 没有发现服务");
            }

            Thread.sleep(3000);
        }
    }
}
