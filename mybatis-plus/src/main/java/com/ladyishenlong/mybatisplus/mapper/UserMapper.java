package com.ladyishenlong.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ladyishenlong.mybatisplus.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 9:15 上午
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity getUserById(@Param("id") String id);

    @Select("")
    UserEntity getUserByName(@Param("name")String name);
}
