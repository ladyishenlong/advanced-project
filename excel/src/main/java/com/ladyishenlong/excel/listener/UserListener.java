package com.ladyishenlong.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ladyishenlong.excel.model.UserModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author ruanchenhao
 * @Date 2020/4/29 11:04 上午
 */
@Slf4j
public class UserListener extends AnalysisEventListener<UserModel> {


    @Override
    public void invoke(UserModel data, AnalysisContext context) {

        log.info("查看解析数据：{}",data);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析成功：{}",context);
    }

}
