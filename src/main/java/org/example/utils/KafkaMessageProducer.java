package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.config.KafkaProcucerConfiguration;
import org.order.status.Order;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class KafkaMessageProducer {

    private final KafkaProducer<String, Order> producer;
    ObjectMapper objectMapper;

    public KafkaMessageProducer() throws InterruptedException, IOException {
        this.producer = KafkaProcucerConfiguration.getConfiguredKafkaProcucer();
        this.objectMapper = new ObjectMapper();
    }

    public void produce(Order order) throws ExecutionException, InterruptedException, TimeoutException, JsonProcessingException {
        final ProducerRecord<String, Order> producerRecord = new ProducerRecord<>("dom.order.status.0", order);
        producer.send(producerRecord).get(30, TimeUnit.SECONDS);
        System.out.println("Message Sent");
        producer.flush();
    }

    public void close(){
        producer.close();
    }

}
