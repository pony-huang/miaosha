package com.ponking.miaosha.model.entity;

import lombok.Data;

/**
 * @author Ponking
 * @ClassName MiaoshaOrder
 * @date 2020/3/30--10:42
 **/
@Data
public class MiaoshaOrder {
    private Long id;
    private Long userId;
    private Long  orderId;
    private Long goodsId;
}
