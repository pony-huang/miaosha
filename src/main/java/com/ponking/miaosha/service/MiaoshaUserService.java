package com.ponking.miaosha.service;

import com.ponking.miaosha.model.entity.MiaoshaUser;
import com.ponking.miaosha.model.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Ponking
 * @ClassName MiaoshaUserService
 * @date 2020/3/29--15:36
 **/
public interface MiaoshaUserService {
    MiaoshaUser getById(Long id);

    Object getByToken(HttpServletResponse response, String token);

    boolean login(HttpServletResponse response, LoginVo loginVo);
}
