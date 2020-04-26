package com.ladyishenlong.mybatisplus.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ladyishenlong.mybatisplus.mapper.UserMapper;
import com.ladyishenlong.mybatisplus.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.TreeMap;

/**
 * @Author ruanchenhao
 * @Date 2020/4/23 10:46 上午
 */
@Slf4j
@Service
public class UserServerImpl extends ServiceImpl<UserMapper, UserEntity> implements UserServer {


    @Override
    public UserEntity getUserById(String id) {
        return baseMapper.getUserById(id);
    }

    @Override
    public IPage<UserEntity> getUserPage(Page<UserEntity> page) {
        return baseMapper.getUserPage(page);
    }


    @Transactional
    @Override
    public void saveUser(UserEntity userEntity) {
        save(userEntity);
    }


    @Transactional
    @Override
    public void saveUsers(List<UserEntity> userEntities){
        saveOrUpdateBatch(userEntities);
    }

    @Transactional
    @Override
    public void lockTest() {

      UserEntity userEntity =  baseMapper.getUserByUsername("3000");
      userEntity.setName("渊眼白龙");

      baseMapper.updateById(userEntity);

    }

}
