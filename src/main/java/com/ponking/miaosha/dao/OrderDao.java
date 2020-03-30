package com.ponking.miaosha.dao;

import com.ponking.miaosha.model.entity.MiaoshaOrder;
import com.ponking.miaosha.model.entity.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @author Ponking
 * @ClassName OrderDao
 * @date 2020/3/30--15:45
 **/
@Mapper
public interface OrderDao {

    /**
     * 获取用户秒杀订单
     * @param userId
     * @param goodsId
     * @return
     */
    @Select("select * from miaosha_order where user_id=#{userId} and goods_id=#{goodsId}")
    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(Long userId, long goodsId);

    /**
     * 插入订单
     * @param orderInfo
     * @return
     */
    @Insert("insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    long insert(OrderInfo orderInfo);

    /**
     * 插入秒杀订单
     * @param miaoshaOrder
     */
    @Insert("insert into miaosha_order (user_id, goods_id, order_id)values(#{userId}, #{goodsId}, #{orderId})")
    void insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
