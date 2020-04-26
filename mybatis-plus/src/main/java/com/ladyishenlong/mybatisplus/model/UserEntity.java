package com.ladyishenlong.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 8:57 上午
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {

    @TableId
    private String username;

    private String id;

    private String name;

    private String phone;


    @Version
    private Integer version; //原本字段为null的时候不会加


    @TableField(fill = FieldFill.INSERT) // 创建记录的时候需要填充
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 创建和修改的时候都需要填充
    private Date updateTime;

}
