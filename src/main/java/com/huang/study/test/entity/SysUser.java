package com.huang.study.test.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: (SysUser)实体类
 * @Author : pc.huang
 * @Date : 2019-03-09 22:28:18
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = -38216135510639301L;
    
    
    @ApiModelProperty(value = "")
    private Long id;
    
    
    @ApiModelProperty(value = "")
    private String password;
    
    
    @ApiModelProperty(value = "")
    private String userName;

}