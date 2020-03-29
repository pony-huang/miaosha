package com.ponking.miaosha.redis;

/**
 * @author Ponking
 * @ClassName UserKey
 * @date 2020/3/28--15:06
 **/
public class UserKey extends BasePrefix {
    private UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
