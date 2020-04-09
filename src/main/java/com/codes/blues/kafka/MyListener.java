package com.codes.blues.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;

import java.util.List;

public class MyListener {
    @KafkaListener(id = "myContainer1",//id是消费者监听容器
            topicPartitions =//配置topic和分区：监听两个topic，分别为topic1、topic2，topic1只接收分区0，3的消息，
                    //topic2接收分区0和分区1的消息，但是分区1的消费者初始位置为5
            { @TopicPartition(topic = "topic1", partitions = { "0", "1", "3" }),
                    @TopicPartition(topic = "topic2", partitions = "0",
                            partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "4"))
            })
    public void listen(List<ConsumerRecord<?, ?>> list) {
        System.out.println("++++++++++++++++++++++++++++kafka消费++++++++++++++++++++++++++++++++++");
        System.out.println(list.size());
        System.out.println("++++++++++++++++++++++++++++kafka消费++++++++++++++++++++++++++++++++++");
        for (ConsumerRecord<?, ?> record: list) {
            System.out.println("topic:" + record.topic());
            System.out.println("key:" + record.key());
            System.out.println("value:"+record.value());
        }
    }


    @KafkaListener(id = "myContainer2",topics = {"foo","bar"})
    public void listen2(ConsumerRecord<?, ?> record){
        System.out.println("topic：" + record.topic());
        System.out.println("key:" + record.key());
        System.out.println("value:"+record.value());
    }
/*
    @KafkaListener(id = "myContainer3",//id是消费者监听容器
            topicPartitions =//配置topic和分区：监听两个topic，分别为topic1、topic2，topic1只接收分区0，3的消息，
                    //topic2接收分区0和分区1的消息，但是分区1的消费者初始位置为5
                    { @TopicPartition(topic = "mykafka", partitions = { "0", "1", "3" })
                    })
    public void listen3(List<ConsumerRecord<?, ?>> list) {
        System.out.println("++++++++++++++++++++++++++++kafka消费++++++++++++++++++++++++++++++++++");
        System.out.println(list.size());
        System.out.println("++++++++++++++++++++++++++++kafka消费++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < list.size(); i++) {
            ConsumerRecord<?, ?> record = list.get(i);
            System.out.println("topic:" + record.topic());
            System.out.println("key:" + record.key());
            System.out.println("value:"+record.value());
        }

    }*/
}