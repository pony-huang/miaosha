package com.ponking.miaosha.dao;

import com.ponking.miaosha.model.entity.MiaoshaGoods;
import com.ponking.miaosha.model.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Ponking
 * @ClassName GoodsDao
 * @date 2020/3/30--15:21
 **/
@Mapper
public interface GoodsDao {

    /**
     * 商品列表
     * @return
     */
    @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price " +
            "from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVo> lisGoodsVo();

    /**
     * 商品信息
     * @param goodsId
     * @return
     */
    @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price " +
            "from miaosha_goods mg left join goods g on mg.goods_id = g.id " +
            "where g.id = #{goodsId}")
    GoodsVo getGoodsVoByGoodsId(long goodsId);

    /**
     * 减少库存
     * @param g
     */
    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
    void reduceStock(MiaoshaGoods g);
}
