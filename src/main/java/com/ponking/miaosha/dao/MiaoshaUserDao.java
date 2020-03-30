package com.ponking.miaosha.dao;

import com.ponking.miaosha.model.entity.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ponking
 * @ClassName MiaoshaUserDao
 * @date 2020/3/28--12:46
 **/
@Mapper
public interface MiaoshaUserDao {
    /**
     * 获取登录用户信息
     * @param id
     * @return
     */
    @Select("select * from miaosha_user where id = #{id}")
    MiaoshaUser getById(@Param("id")long id);
}
