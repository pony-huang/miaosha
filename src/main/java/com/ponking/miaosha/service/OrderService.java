package com.ponking.miaosha.service;

import com.ponking.miaosha.model.entity.MiaoshaOrder;
import com.ponking.miaosha.model.entity.MiaoshaUser;
import com.ponking.miaosha.model.entity.OrderInfo;
import com.ponking.miaosha.model.vo.GoodsVo;

/**
 * @author Ponking
 * @ClassName OrderService
 * @date 2020/3/30--15:43
 **/
public interface OrderService {
    /**
     * 获取用户秒杀订单
     * @param userId
     * @param goodsId
     * @return
     */
    MiaoshaOrder getMiaoshaByUserIdGoodsId(Long userId, long goodsId);

    OrderInfo createOrder(MiaoshaUser user, GoodsVo goods);
}
