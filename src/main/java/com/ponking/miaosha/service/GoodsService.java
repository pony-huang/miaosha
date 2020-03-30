package com.ponking.miaosha.service;

import com.ponking.miaosha.model.vo.GoodsVo;

import java.util.List;

/**
 * @author Ponking
 * @ClassName GoodsService
 * @date 2020/3/30--15:18
 **/
public interface GoodsService {
    List<GoodsVo> listGoodsVo();

    GoodsVo getGoodsVoByGoodsId(long goodsId);

    void reduceStock(GoodsVo goods);
}
