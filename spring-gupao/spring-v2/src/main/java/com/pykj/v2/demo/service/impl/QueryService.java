package com.pykj.v2.demo.service.impl;

import com.pykj.v2.demo.service.IQueryService;
import com.pykj.v2.spring.framework.annotation.PYService;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查询业务
 *
 * @author Tom
 */
@PYService
@Slf4j
public class QueryService implements IQueryService {

    /**
     * 查询
     */
    @Override
    public String query(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
        log.info("这是在业务方法中打印的：" + json);
        return json;
    }

}
