package com.ponking.miaosha.redis;

/**
 * @author Ponking
 * @ClassName MiaoshaUserKey
 * @date 2020/3/29--17:10
 **/
public class MiaoshaUserKey extends BasePrefix {
    public static final int TOKEN_EXPIRE = 3600*24 * 2;
    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE, "tk");
}
