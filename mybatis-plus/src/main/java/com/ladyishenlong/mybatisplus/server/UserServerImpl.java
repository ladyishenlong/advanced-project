package com.ladyishenlong.mybatisplus.server;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ladyishenlong.mybatisplus.mapper.UserMapper;
import com.ladyishenlong.mybatisplus.model.UserEntity;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 10:46 上午
 */
@Service
public class UserServerImpl extends ServiceImpl<UserMapper, UserEntity> implements UserServer {


    @Override
    public UserEntity getUserById(String id) {
        return baseMapper.getUserById(id);
    }

}
