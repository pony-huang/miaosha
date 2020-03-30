package com.ponking.miaosha.controller;

import com.ponking.miaosha.model.entity.MiaoshaOrder;
import com.ponking.miaosha.model.entity.MiaoshaUser;
import com.ponking.miaosha.model.entity.OrderInfo;
import com.ponking.miaosha.model.vo.GoodsVo;
import com.ponking.miaosha.redis.RedisService;
import com.ponking.miaosha.result.ResultStatus;
import com.ponking.miaosha.service.GoodsService;
import com.ponking.miaosha.service.MiaoshaService;
import com.ponking.miaosha.service.MiaoshaUserService;
import com.ponking.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ponking
 * @ClassName MiaoshaController
 * @date 2020/3/30--15:36
 **/
@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {
    @Autowired
    MiaoshaUserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    MiaoshaService miaoshaService;

    @RequestMapping("/do_miaosha")
    public String list(Model model, MiaoshaUser user,
                       @RequestParam("goodsId")long goodsId){
        model.addAttribute("user",user);
        if(user == null){
            return "login";
        }
        // 判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if(stock <= 0){
            model.addAttribute("errmsg", ResultStatus.MIAO_SHA_OVER.getMessage());
            return "miaosha_fail";
        }
        // 判断是否已经秒杀到了
        MiaoshaOrder order = orderService.getMiaoshaByUserIdGoodsId(user.getId(),goodsId);
        if(order != null){
            model.addAttribute("errmsg",ResultStatus.REPEATE_MIAOSHA.getMessage());
            return "miaosha_fail";
        }
        // 减库存 下订单 写入秒杀订单
        OrderInfo info = miaoshaService.miaosha(user,goods);
        model.addAttribute("orderInfo",info);
        model.addAttribute("goods",goods);
        return "order_detail";
    }
}
