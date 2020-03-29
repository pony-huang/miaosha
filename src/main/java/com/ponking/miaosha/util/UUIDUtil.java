package com.ponking.miaosha.util;

import java.util.UUID;

/**
 * @author Ponking
 * @ClassName UUIDUtil
 * @date 2020/3/29--17:11
 **/
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
