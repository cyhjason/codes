package com.cyh.sy.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 
 * @描述: 静态注入中间类
 * @版权: Copyright (c) 2016 
 * @作者: xiad
 * @版本: 1.0 
 * @创建日期: 2016年3月2日 
 * @创建时间: 下午8:02:57
 */
public class RedisCacheTransfer 
{

    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }

}