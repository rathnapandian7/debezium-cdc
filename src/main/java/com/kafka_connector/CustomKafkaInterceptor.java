package com.kafka_connector;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomKafkaInterceptor implements ConsumerInterceptor<String,String> {

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        Map<TopicPartition, List<ConsumerRecord<String, String>>> updatedRecords = new HashMap<>();
        KafkaTestEntity entity=new KafkaTestEntity();


        for (TopicPartition partition : records.partitions()) {
            List<ConsumerRecord<String, String>> modifiedList = records.records(partition).stream()
                    .map(record -> new ConsumerRecord<>(
                            record.topic(),
                            record.partition(),
                            record.offset(),
                            record.key(),
                            record.value().replace(record.value(), entity.toString())  // Modify payload correctly
                    ))
                    .collect(Collectors.toList());

            updatedRecords.put(partition, modifiedList);
        }

        return new ConsumerRecords<>(updatedRecords);
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
