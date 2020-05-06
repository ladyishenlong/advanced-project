package com.ladyishenlong.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ladyishenlong.mybatisplus.model.MonsterCardTable;
import com.ladyishenlong.mybatisplus.server.MonsterCardServerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private MonsterCardServerImpl monsterCardServer;

    @Test
    void contextLoads() {

//        monsterCardServer.saveMonster(
//                MonsterCardTable.builder()
//                        .name("青眼白龙")
//                        .attack(3000)
//                        .defensive(2500)
//                        .grade(8)
//                        .field("青眼").build());

//        List<MonsterCardTable> monsterCards = new ArrayList<>();
//        monsterCards.add(MonsterCardTable.builder()
//                .name("白灵龙")
//                .attack(2500)
//                .defensive(2000)
//                .grade(8)
//                .field("青眼").build());
//        monsterCards.add(MonsterCardTable.builder()
//                .name("水晶龙")
//                .attack(2500)
//                .defensive(2000)
//                .grade(6)
//                .build());
//        monsterCards.add(MonsterCardTable.builder()
//                .name("青眼白龙")
//                .attack(3000)
//                .defensive(2500)
//                .grade(8)
//                .field("青眼").build());
//        monsterCards.add(MonsterCardTable.builder()
//                .name("青眼白龙")
//                .attack(3000)
//                .defensive(2500)
//                .grade(8)
//                .field("青眼").build());
//        monsterCardServer.saveMonsters(monsterCards);

        monsterCardServer.getLikeName("青眼", 0, 2);


    }

}
