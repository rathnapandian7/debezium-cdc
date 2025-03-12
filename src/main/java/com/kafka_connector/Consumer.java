package com.kafka_connector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @KafkaListener(topics = "kafka_test", groupId = "my-group")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("Received DB Change: " + record.value());

    }

    @KafkaListener(topics = "mysql-server.com_data.kafka_test", groupId = "my-group")
    public void consume1(ConsumerRecord<String, String> record) throws JsonProcessingException {
        System.out.println(record.value());

    }

    @KafkaListener(topics = "mysql-server.database-history", groupId = "my-group")
    public void consume11(ConsumerRecord<String, String> record) {
        System.out.println("Received DB Change: " + record.value());

    }

}
