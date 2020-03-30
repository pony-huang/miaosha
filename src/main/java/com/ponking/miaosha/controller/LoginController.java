package com.ponking.miaosha.controller;

import com.ponking.miaosha.model.vo.LoginVo;
import com.ponking.miaosha.result.Result;
import com.ponking.miaosha.service.MiaoshaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * @author Ponking
 * @ClassName LoginController
 * @date 2020/3/29--14:57
 **/
@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public Result doLogin(HttpServletResponse response, @Valid LoginVo loginVO) {
        log.info("loginVO:{}" ,loginVO);
        // 登录
        miaoshaUserService.login(response,loginVO);
        return Result.success(true);
    }
}
