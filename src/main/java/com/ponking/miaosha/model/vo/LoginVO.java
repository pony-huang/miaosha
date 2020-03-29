package com.ponking.miaosha.model.vo;

import com.ponking.miaosha.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Ponking
 * @ClassName LoginVO
 * @date 2020/3/29--15:07
 **/
@Data
public class LoginVO {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;
}
