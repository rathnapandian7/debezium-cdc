//package com.kafka_connector;
//
//import jakarta.websocket.Extension;
//import org.apache.tomcat.websocket.MessagePart;
//import org.apache.tomcat.websocket.Transformation;
//import org.apache.tomcat.websocket.TransformationResult;
//
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.util.List;
//
//public class CustomDebeziumTransformer <R extends ConnectRecord<R>> implements Transformation<R> {
//
//    @Override
//    public void setNext(Transformation transformation) {
//
//    }
//
//    @Override
//    public boolean validateRsvBits(int i) {
//        return false;
//    }
//
//    @Override
//    public Extension getExtensionResponse() {
//        return null;
//    }
//
//    @Override
//    public TransformationResult getMoreData(byte b, boolean b1, int i, ByteBuffer byteBuffer) throws IOException {
//        return null;
//    }
//
//    @Override
//    public boolean validateRsv(int i, byte b) {
//        return false;
//    }
//
//    @Override
//    public List<MessagePart> sendMessagePart(List<MessagePart> list) throws IOException {
//        return null;
//    }
//
//
//
//    @Override
//    public void close() {
//
//    }
//}
