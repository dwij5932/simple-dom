package org.example;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.DatumReader;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class KafkaAvroConsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("topic_59"));

        try {
            Schema schema = new Schema.Parser().parse(new File("C:\\Users\\Dasun Theekshana\\Desktop\\KT\\demo-dom\\src\\main\\resources\\dom.order.status.0-value.avsc"));

            while (true) {
                ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofMillis(100));

                for (ConsumerRecord<String, byte[]> record : records) {
                    byte[] data = record.value();
                    System.out.println("Raw data: " + Arrays.toString(data));
//                    DatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);
//                    Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
//                    GenericRecord genericRecord = reader.read(null, decoder);
//
//                    System.out.println("Consumed record:");
//                    System.out.println("OrderId: " + genericRecord.get("orderId"));
//                    System.out.println("Status: " + genericRecord.get("status"));
//                    System.out.println("Timestamp: " + genericRecord.get("timestamp"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
