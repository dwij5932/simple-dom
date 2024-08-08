//package org.example;
//
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Properties;
//
//public class KafkaAvroProducer {
////    public static void main(String[] args) {
////        Properties props = new Properties();
////        props.put("bootstrap.servers", "localhost:9092");
////        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
////        props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
////
////        Producer<String, byte[]> producer = new KafkaProducer<>(props);
////
////        try {
////            Schema schema = new Schema.Parser().parse(new File("C:\\Users\\Dasun Theekshana\\Desktop\\KT\\demo-dom\\src\\main\\resources\\dom.order.status.0-value.avsc"));
////            GenericRecord record = AvroRecordGenerator.generateRecord();
////            byte[] serializedData = AvroSerializer.serializeRecord(record, schema);
////
////            producer.send(new ProducerRecord<>("topic_59", "key", serializedData));
////            System.out.println("sent message");
////        } catch (IOException e) {
////            e.printStackTrace();
////        } finally {
////            producer.close();
////        }
////    }
//}
//
