package com.ponking.miaosha.redis;

import lombok.Data;

/**
 * @author Ponking
 * @ClassName BasePrefix
 * @date 2020/3/28--15:03
 **/
public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;
    private String prefix;

    public BasePrefix(String prefix) {
        this.expireSeconds = 0;
        this.prefix = prefix;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }
    /**
     * 默认0代表永不过期
     * @return
     */
    @Override
    public int expireSeconds() {
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":"+this.prefix;
    }


}
