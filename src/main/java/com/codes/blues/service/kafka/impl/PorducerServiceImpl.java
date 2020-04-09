package com.codes.blues.service.kafka.impl;

import com.codes.blues.service.kafka.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ：linzg_64
 * @date ：Created in 2020/3/19 14:04
 * @description：
 */
@Service
public class PorducerServiceImpl implements ProducerService {

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }

    @Override
    public void send(String topic, int partition, String key, String value) {
        kafkaTemplate.send(topic, partition, key, value);
    }
}
