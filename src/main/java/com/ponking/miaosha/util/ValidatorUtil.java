package com.ponking.miaosha.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ponking
 * @ClassName ValidatorUtil
 * @date 2020/3/29--15:46
 **/
public class ValidatorUtil {
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(str);
        return matcher.matches();
    }
}
