package com.ladyishenlong.elasticsearch.server;

import com.ladyishenlong.elasticsearch.model.UserModel;
import com.ladyishenlong.elasticsearch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
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


    /**
     * 创建索引
     */
    public void createIndex() {
        restTemplate.createIndex(UserModel.class);
    }


    /**
     * 删除索引
     */
    public void removeIndex() {
        restTemplate.deleteIndex(UserModel.class);
    }


    /**
     * 单个保存
     */
    public void saveUser() {
        userRepository.save(new UserModel(4L, "4号", "123", "2"));
    }


    /**
     * 批量保存
     */
    public void saveUsers() {
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel(1L, "3号", "123", "1"));
        userModels.add(new UserModel(2L, "3号", "123", "1"));
        userModels.add(new UserModel(3L, "3号", "123", "2"));
        userRepository.saveAll(userModels);
    }

    /**
     * @return 获取全部
     */
    public Iterable<UserModel> findAll() {
        return userRepository.findAll();
    }


    public void removeAll() {
        userRepository.deleteAll();
    }


    public Object search() {

        //查询条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("password", "123"))
                .mustNot(QueryBuilders.termQuery("id", 1L));


        //分页查询
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(0, 2, sort);

        return userRepository.search(boolQueryBuilder, pageable);

    }


    //todo query还有问题
    public Object query() {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("password", "123"));


        //添加聚合（相当于group by）
        AggregationBuilder aggregationBuilder = AggregationBuilders
                .terms("group")//自定义值
                .field("group")//需要分组的key,type必须为keyword
                .size(2);

        FilterAggregationBuilder filterAggregation = AggregationBuilders
                .filter("user", boolQueryBuilder)
                .subAggregation(aggregationBuilder);

        //排序和分页
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 2, sort);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .addAggregation(filterAggregation)
                .build();

        restTemplate.query(searchQuery, SearchResponse::getAggregations);

        return "";
    }


}
