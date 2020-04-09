package com.codes.blues.config;

import cn.hutool.cron.CronUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/16 9:46
 * @description：
 */
@Component
public class InitConfig implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //启动定时任务
        Log log = LogFactory.get();
        log.info("Start Task ...");
        CronUtil.start();
        log.info("Start Task Success...");
        //ArthasUtil.main(null);
    }
}
