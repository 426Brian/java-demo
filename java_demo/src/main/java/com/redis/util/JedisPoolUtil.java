package com.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;
    private static final String HOST = "192.168.1.101";
    private static final int PORT = 6379;
    private JedisPoolUtil() {
    }

    public static JedisPool getRedisPool(){
        if(jedisPool == null){
            synchronized (JedisPoolUtil.class){
                if(jedisPool == null){
                    JedisPoolConfig poolConfig = new JedisPoolConfig();

                    jedisPool = new JedisPool(poolConfig, HOST, PORT);
                }
            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis){
        if(jedis != null){
            jedisPool.returnResourceObject(jedis);
        }
    }
}
