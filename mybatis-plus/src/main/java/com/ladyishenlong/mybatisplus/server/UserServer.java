package com.ladyishenlong.mybatisplus.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ladyishenlong.mybatisplus.mapper.UserMapper;
import com.ladyishenlong.mybatisplus.model.UserEntity;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 10:38 上午
 */
public interface UserServer extends IService<UserEntity> {


     UserEntity getUserById(String id);

}
