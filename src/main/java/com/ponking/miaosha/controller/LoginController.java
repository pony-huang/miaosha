package com.ponking.miaosha.controller;

import com.ponking.miaosha.model.vo.LoginVO;
import com.ponking.miaosha.result.Result;
import com.ponking.miaosha.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private UserService userService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public Result doLogin(HttpServletResponse response, @Valid LoginVO loginVO) {
        log.info("loginVO:{}" ,loginVO);
        // 登录
        userService.login(response,loginVO);
        return Result.success(true);
    }
}
