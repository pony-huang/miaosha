package com.ponking.miaosha.service.impl;

import com.ponking.miaosha.dao.GoodsDao;
import com.ponking.miaosha.model.entity.MiaoshaGoods;
import com.ponking.miaosha.model.vo.GoodsVo;
import com.ponking.miaosha.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ponking
 * @ClassName GoodsServiceImpl
 * @date 2020/3/30--15:20
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo> listGoodsVo() {
        return goodsDao.lisGoodsVo();
    }

    @Override
    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    @Override
    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsDao.reduceStock(g);
    }
}
