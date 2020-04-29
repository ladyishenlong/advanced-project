package com.ladyishenlong.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2020/4/29 10:40 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {

    //注解可以用标题名也可以用行数
    @ExcelProperty("用户名")
    private String username;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("角色")
    private String role;

}
