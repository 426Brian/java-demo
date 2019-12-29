package com.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class Test {
    public static String VM_HOST = "192.168.1.101";
    public static int MASTER_PORT = 6379;
    public static int SLAVE_PORT = 6380;

    public Test() {
    }

    public static void main(String[] args) throws InterruptedException {

        Jedis redis = new Jedis(VM_HOST, MASTER_PORT);

        System.out.println(redis.ping() + " " + MASTER_PORT);

        // 事务
        redisTransaction(redis);
        // 锁
        System.out.println(redisWatch(redis));
        // API
        redisAPI(redis);


        // 主
        Jedis redis_m = new Jedis(VM_HOST, MASTER_PORT);
        // 从
        Jedis redis_s = new Jedis(VM_HOST, SLAVE_PORT);
        // 设置主从关系
        redis_s.slaveof(VM_HOST, MASTER_PORT);

        master_slave(redis_m, redis_s);

        redis.close();


    }

    public static void master_slave(Jedis redis_m, Jedis redis_s) {
        redis_m.set("class", "11223");
        String result = redis_s.get("class");
        System.out.println(result);
    }


    public static void redisAPI(Jedis redis) {
        redis.set("k1", "v1");
        redis.set("k2", "v2");
        redis.set("k3", "v3");

        Set<String> keys = redis.keys("*");

        int size = keys.size();
        System.out.println(size);
    }

    public static void redisTransaction(Jedis redis) {

        Transaction transaction = redis.multi();
        transaction.set("k44", "v4");
        transaction.set("k55", "v5");

//        transaction.exec();
        transaction.discard();
    }

    public static boolean redisWatch(Jedis redis) throws InterruptedException {
        int amtSubtract = 10;

        // 锁 balance
        redis.watch("balance");

        Thread.sleep(7000);

        int balance = Integer.parseInt(redis.get("balance"));
        int debt = 0;

        if (balance < amtSubtract) {
            // 解锁 balance
            redis.unwatch();
            System.out.println("== modify ==");
            return false;
        } else {
            System.out.println(" ================= transaction");
            Transaction transaction = redis.multi();

            transaction.decrBy("balance", amtSubtract);
            transaction.incrBy("debt", amtSubtract);

            transaction.exec();

            balance = Integer.parseInt(redis.get("balance"));
            debt = Integer.parseInt(redis.get("debt"));


            System.out.println("== balance == " + balance);
            System.out.println("== debt == " + debt);
            return true;
        }
    }
}

































