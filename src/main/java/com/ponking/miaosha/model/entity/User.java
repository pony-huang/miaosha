package com.ponking.miaosha.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Ponking
 * @ClassName User
 * @date 2020/3/28--12:45
 **/
@Data
public class User {
    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;
}
