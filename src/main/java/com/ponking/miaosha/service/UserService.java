package com.ponking.miaosha.service;

import com.ponking.miaosha.model.entity.User;
import com.ponking.miaosha.model.vo.LoginVO;
import com.ponking.miaosha.util.MD5Util;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Ponking
 * @ClassName UserService
 * @date 2020/3/29--15:36
 **/
public interface UserService {
    User getById(Long id);

    Object getByToken(HttpServletResponse response, String token);

    boolean login(HttpServletResponse response, LoginVO loginVo);
}
