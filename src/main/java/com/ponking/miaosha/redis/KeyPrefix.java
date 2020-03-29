package com.ponking.miaosha.redis;

/**
 * @author Ponking
 * @ClassName KeyPrefix
 * @date 2020/3/28--15:02
 **/
public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
