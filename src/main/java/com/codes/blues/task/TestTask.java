package com.codes.blues.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.system.RuntimeInfo;
import cn.hutool.system.SystemUtil;

import java.util.Date;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/9 17:06
 * @description：测试定时任务
 */
public class TestTask {

    public void run() {
        System.out.print("触发定时任务: " + DateUtil.formatDateTime(new Date()));
        RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
        System.out.printf("最大可申请内存：%d Mb ,", runtimeInfo.getMaxMemory() / 1024 /1024);
        System.out.printf("已分配内存：%d Mb ,", runtimeInfo.getTotalMemory() / 1024 /1024);
        System.out.printf("已分配剩余内存：%d Mb", runtimeInfo.getFreeMemory() / 1024 /1024);
        System.out.println();
    }

    public static void main(String[] args) {
        new TestTask().run();
    }
}
