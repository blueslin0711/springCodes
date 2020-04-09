package com.codes.blues.service.kafka.impl;

import com.codes.blues.service.kafka.ConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/19 14:23
 * @description：
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    //@KafkaListener(topics = "mykafka")
    public String get(ConsumerRecord<?, ?> record) {
        return record.value().toString();
    }
}
