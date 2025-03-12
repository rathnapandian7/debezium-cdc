//package com.kafka_connector;
//
//import org.apache.kafka.common.header.Headers;
//import org.apache.kafka.common.serialization.Deserializer;
//import org.json.JSONObject;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.nio.ByteBuffer;
//import java.util.Map;
//
//public class CustomKafkaDeserializer implements Deserializer<String> {
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        Deserializer.super.configure(configs, isKey);
//    }
//
//    @Override
//    public String deserialize(String s, byte[] bytes) {
//        try {
//            String originalPayload = new String(bytes);
//            System.out.println("Before Modification: " + originalPayload);
//            JSONObject json=new JSONObject(originalPayload);
//            JSONObject payload=json.getJSONObject("payload");
//            JSONObject after=payload.getJSONObject("after");
//            KafkaTestEntity entity=new KafkaTestEntity();
//
//            entity.setId(after.get("id").toString());
//            entity.setName(after.get("name").toString());
//            // Modify the payload before returning it
//            byte[] bytesResponse = convertToBytes(entity);
//            String modifiedPayload = originalPayload.replace(originalPayload, entity);
//
//            System.out.println("After Modification: " + modifiedPayload);
//            return modifiedPayload;
//        } catch (Exception e) {
//            throw new RuntimeException("Error deserializing Kafka message", e);
//        }
//    }
//
//    @Override
//    public String deserialize(String topic, Headers headers, byte[] data) {
//        return Deserializer.super.deserialize(topic, headers, data);
//    }
//
//    @Override
//    public String deserialize(String topic, Headers headers, ByteBuffer data) {
//        return Deserializer.super.deserialize(topic, headers, data);
//    }
//
//    @Override
//    public void close() {
//        Deserializer.super.close();
//    }
//    public static byte[] convertToBytes(Object obj) throws IOException {
//        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
//             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
//            oos.writeObject(obj);
//            return bos.toByteArray();
//        }
//    }
//}
