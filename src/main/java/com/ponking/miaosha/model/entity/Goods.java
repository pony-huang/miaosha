package com.ponking.miaosha.model.entity;

import lombok.Data;

/**
 * @author Ponking
 * @ClassName Goods
 * @date 2020/3/30--10:41
 **/
@Data
public class Goods {
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;
}
