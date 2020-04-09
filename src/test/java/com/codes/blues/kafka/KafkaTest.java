package com.codes.blues.kafka;

import cn.hutool.core.util.RandomUtil;
import com.codes.blues.BaseTest;
import com.codes.blues.service.kafka.ProducerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/19 14:34
 * @description：
 */
public class KafkaTest extends BaseTest {

    @Autowired
    ProducerService producerService;

    @Test
    public void testProducer() {
        producerService.send("topic1", "好！");
    }

    @Test
    public void testBatchProducer() {
        for (int i = 0; i < 1000; i++) {
            int partition = i % 8;
            producerService.send("topic1", partition, i + "", RandomUtil.randomString(partition));
        }
    }
}
