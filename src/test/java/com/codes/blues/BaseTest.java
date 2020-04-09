package com.codes.blues;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 测试类基类
 * @author linzg
 * @date 2020/03/02 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
public class BaseTest {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 打印测试结果
     * @author linzg
     * @date 2020/03/02 15:25
     */
    protected void print(Object obj) {
        log.info(JSONObject.fromObject(obj).toString());
    }

    @Test
    public void initTest() {
        DateTime dateTime = RandomUtil.randomDate(new Date(), DateField.MINUTE, -60, 60);
        /*2019-12-3105: 07: 40*/
        System.out.println(dateTime.toString("yyyy-MM-ddHH: mm: ss"));
        System.out.println(new Date().getTime());
    }

    public static void main(String[] args) {
//        new BaseTest().initTest();
        long n1 = 100000000000L;
        System.out.println(n1);
        System.out.println(n1*10);
    }
}