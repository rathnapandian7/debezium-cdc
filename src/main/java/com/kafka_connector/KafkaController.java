package com.kafka_connector;


import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableKafka
public class KafkaController {


    private final KafkaTemplate<String, String> kafkaTemplate;


    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
        System.out.println("Sent message: " + message);
    }
    @GetMapping("/test")
    public String sendMsg() {
        kafkaTemplate.send("kafka_test", "welcomeRats");
        System.out.println("Sent message: ");
        return "success";
    }


}
