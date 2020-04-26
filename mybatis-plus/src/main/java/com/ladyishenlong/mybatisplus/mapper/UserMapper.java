package com.ladyishenlong.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ladyishenlong.mybatisplus.model.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 9:15 上午
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    UserEntity getUserByUsername(@Param("username") String username);

    UserEntity getUserById(@Param("id") String id);

    IPage<UserEntity> getUserPage(Page<?> page);

}
