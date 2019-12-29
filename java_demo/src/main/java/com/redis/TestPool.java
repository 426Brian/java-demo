package com.redis;

import com.redis.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestPool {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getRedisPool();
        JedisPool jedisPool2 = JedisPoolUtil.getRedisPool();

        System.out.println("singleton == " + (jedisPool == jedisPool2));

        Jedis jedis = null;

        jedis = jedisPool.getResource();

        jedis.set("aa", "bb");

        JedisPoolUtil.release(jedisPool, jedis);
    }
}
