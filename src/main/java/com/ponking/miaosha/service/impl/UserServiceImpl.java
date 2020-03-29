package com.ponking.miaosha.service.impl;

import com.ponking.miaosha.dao.UserDao;
import com.ponking.miaosha.exception.GlobalException;
import com.ponking.miaosha.model.entity.User;
import com.ponking.miaosha.model.vo.LoginVO;
import com.ponking.miaosha.redis.MiaoshaUserKey;
import com.ponking.miaosha.redis.RedisService;
import com.ponking.miaosha.redis.UserKey;
import com.ponking.miaosha.result.ResultStatus;
import com.ponking.miaosha.service.UserService;
import com.ponking.miaosha.util.MD5Util;
import com.ponking.miaosha.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ponking
 * @ClassName UserServiceImpl
 * @date 2020/3/29--15:40
 **/
@Service
public class UserServiceImpl implements UserService {

    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisService.get(MiaoshaUserKey.token, token, User.class);
        //延长有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }


    @Override
    public boolean login(HttpServletResponse response, LoginVO loginVo) {
        if (loginVo == null) {
            throw new GlobalException(ResultStatus.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(ResultStatus.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(ResultStatus.PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);
        return true;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
