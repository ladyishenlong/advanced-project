package com.ladyishenlong.excel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.ladyishenlong.excel.listener.UserListener;
import com.ladyishenlong.excel.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2020/4/29 10:30 上午
 */
@RestController
public class UserController {


    @GetMapping("/read")
    public void read() {
        //导入数据
        String filePath = "test.xlsx";

        //读取 默认第一个sheet ，文件流会自动关闭
        EasyExcel.read(filePath, UserModel.class, new UserListener())
                .sheet().doRead();
    }


    @GetMapping("/write")
    public void write(HttpServletResponse response) throws Exception {
        //导出数据
        List<UserModel> userModels = new ArrayList<UserModel>() {
            {
                this.add(new UserModel("1", "1", "1"));
                this.add(new UserModel("盖帽", "搞毛", "卡密"));
            }
        };

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition",
                "attachment;filename=" + fileName + ".xlsx");


        //导出
        EasyExcel.write(response.getOutputStream(), UserModel.class)
                .sheet("模板").doWrite(userModels);


    }


}
