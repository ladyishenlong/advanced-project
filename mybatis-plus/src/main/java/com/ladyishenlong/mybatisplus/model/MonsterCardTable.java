package com.ladyishenlong.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 2:57 下午
 */
@Builder
@Data
@TableName("monster_card")
public class MonsterCardTable implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer grade;

    private Integer attack;

    private Integer defensive;

    private String effect;

    private String field;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

}
