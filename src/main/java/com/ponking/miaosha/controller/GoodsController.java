package com.ponking.miaosha.controller;

import com.ponking.miaosha.model.entity.User;
import com.ponking.miaosha.redis.RedisService;
import com.ponking.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ponking
 * @ClassName GoodsController
 * @date 2020/3/29--17:15
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/to_list")
    public String list(Model model, User user) {
        model.addAttribute("user", user);
        return "goods_list";
    }
}
