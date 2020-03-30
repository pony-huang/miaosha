package com.ponking.miaosha.service;

import com.ponking.miaosha.model.entity.MiaoshaUser;
import com.ponking.miaosha.model.entity.OrderInfo;
import com.ponking.miaosha.model.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ponking
 * @ClassName MiaoshaService
 * @date 2020/3/30--15:43
 **/
public interface MiaoshaService {
    OrderInfo miaosha(MiaoshaUser user, GoodsVo goods);
}
