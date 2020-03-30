package com.ponking.miaosha.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Ponking
 * @ClassName MiaoshaGoods
 * @date 2020/3/30--10:42
 **/
@Data
public class MiaoshaGoods {
    private Long id;
    private Long goodsId;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
