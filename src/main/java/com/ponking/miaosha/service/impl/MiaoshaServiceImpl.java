package com.ponking.miaosha.service.impl;

import com.ponking.miaosha.model.entity.MiaoshaUser;
import com.ponking.miaosha.model.entity.OrderInfo;
import com.ponking.miaosha.model.vo.GoodsVo;
import com.ponking.miaosha.service.GoodsService;
import com.ponking.miaosha.service.MiaoshaService;
import com.ponking.miaosha.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ponking
 * @ClassName MiaoshaServiceImpl
 * @date 2020/3/30--15:48
 **/
@Service
public class MiaoshaServiceImpl implements MiaoshaService {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
        //减库存 下订单 写入秒杀订单
        goodsService.reduceStock(goods);
        //order_info maiosha_order
        return orderService.createOrder(user, goods);
    }
}
