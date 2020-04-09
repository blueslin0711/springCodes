package com.codes.blues.service.kafka;

public interface ProducerService {

    public void send(String topic, String msg);

    public void send(String topic, int partition, String key, String value);
}
