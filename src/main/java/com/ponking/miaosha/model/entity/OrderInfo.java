package com.ponking.miaosha.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Ponking
 * @ClassName OrderInfo
 * @date 2020/3/30--10:43
 **/
@Data
public class OrderInfo {
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long  deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;
}
