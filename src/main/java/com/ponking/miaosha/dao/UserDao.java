package com.ponking.miaosha.dao;

import com.ponking.miaosha.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ponking
 * @ClassName UserDao
 * @date 2020/3/28--12:46
 **/
@Mapper
public interface UserDao {
    /**
     * 获取登录用户信息
     * @param id
     * @return
     */
    @Select("select * from miaosha_user where id = #{id}")
    User getById(@Param("id")long id);
}
