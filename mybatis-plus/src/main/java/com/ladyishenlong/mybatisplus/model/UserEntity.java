package com.ladyishenlong.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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


    @TableField(fill = FieldFill.INSERT) // 创建记录的时候需要填充
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 创建和修改的时候都需要填充
    private Date updateTime;

}
