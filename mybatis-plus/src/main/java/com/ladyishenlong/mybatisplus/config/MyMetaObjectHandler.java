package com.ladyishenlong.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 3:18 下午
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时赋值字段
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
    }

    /**
     * 更新时赋值字段
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

}
