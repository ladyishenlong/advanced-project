package com.ladyishenlong.elasticsearch.repository;

import com.ladyishenlong.elasticsearch.model.UserModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author ruanchenhao
 * @Date 2020/4/24 4:58 下午
 */
public interface UserRepository extends ElasticsearchRepository<UserModel,Long> {



}
