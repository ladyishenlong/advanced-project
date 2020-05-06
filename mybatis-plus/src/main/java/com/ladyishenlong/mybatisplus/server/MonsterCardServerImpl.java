package com.ladyishenlong.mybatisplus.server;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ladyishenlong.mybatisplus.mapper.MonsterCardMapper;
import com.ladyishenlong.mybatisplus.model.MonsterCardTable;
import com.ladyishenlong.mybatisplus.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2020/5/6 2:49 下午
 */
@Slf4j
@Service
public class MonsterCardServerImpl extends ServiceImpl<MonsterCardMapper, MonsterCardTable> implements MonsterCardServer {


    /**
     * 分页条件查询
     *
     * @param name
     * @param curr
     * @param size
     * @return
     */
    public IPage<MonsterCardTable> getLikeName(String name, int curr, int size) {
        IPage<MonsterCardTable> iPage = new Page<>();
        iPage.setCurrent(curr); //当前页
        iPage.setSize(size);    //每页条数
        IPage<MonsterCardTable> result = page(iPage,
                new QueryWrapper<MonsterCardTable>().lambda()
                .like(MonsterCardTable::getName, name));
        log.info("查看分页结果：{}",result);
        return result;
    }


    /**
     * 单条记录保存
     *
     * @param monsterCard
     */
    public void saveMonster(MonsterCardTable monsterCard) {
        save(monsterCard);
    }


    /**
     * 多条记录保存
     * 该方法本质上还是逐条执行插入语句
     *
     * @param monsterCards
     */
    public void saveMonsters(List<MonsterCardTable> monsterCards) {
        saveBatch(monsterCards);
    }


}
