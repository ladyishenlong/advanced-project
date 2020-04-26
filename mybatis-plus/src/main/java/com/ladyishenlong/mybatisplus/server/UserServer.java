package com.ladyishenlong.mybatisplus.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ladyishenlong.mybatisplus.mapper.UserMapper;
import com.ladyishenlong.mybatisplus.model.UserEntity;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 10:38 上午
 */
public interface UserServer extends IService<UserEntity> {


    UserEntity getUserById(String id);

    IPage<UserEntity> getUserPage(Page<UserEntity> page);

    void saveUser(UserEntity userEntity);

    /**
     * 批量保存或者更新，根据主键id判断
     * @param userEntities
     */
    void saveUsers(List<UserEntity> userEntities);

    /**
     * 乐观锁测试,version自动加一
     */
    void lockTest();

}
