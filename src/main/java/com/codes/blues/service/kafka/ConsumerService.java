package com.codes.blues.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/19 13:58
 * @description：消费者服务
 */
public interface ConsumerService {
    public String get(ConsumerRecord<?, ?> record);
}
