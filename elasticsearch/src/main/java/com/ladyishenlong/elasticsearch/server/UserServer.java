package com.ladyishenlong.elasticsearch.server;

import com.ladyishenlong.elasticsearch.model.UserModel;
import com.ladyishenlong.elasticsearch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2020/4/24 4:08 下午
 */
@Slf4j
@Service
public class UserServer {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;


    public void createIndex() {
        restTemplate.createIndex(UserModel.class);
    }

    public void saveUsers() {
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel(1L, "3号", "123"));
        userModels.add(new UserModel(2L, "3号", "123"));
        userModels.add(new UserModel(3L, "3号", "123"));
        userRepository.saveAll(userModels);
    }

    public Iterable<UserModel> findAll() {
        return userRepository.findAll();
    }


}
