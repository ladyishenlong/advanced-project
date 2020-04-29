package com.ladyishenlong.excel;

import com.alibaba.excel.EasyExcel;
import com.ladyishenlong.excel.listener.UserListener;
import com.ladyishenlong.excel.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExcelApplicationTests {

    @Test
    void contextLoads() {

        String filePath = "test.xlsx";
        EasyExcel.read(filePath, UserModel.class, new UserListener())
                .sheet().doRead();

    }

}
