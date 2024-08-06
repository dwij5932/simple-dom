package org.example;

import org.example.entity.Order;
import org.example.utils.KafkaMessageProducer;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        KafkaMessageProducer kafkaMessageProducer = new KafkaMessageProducer();

        Order order = new Order();
        order.setSeller_id("USBL");
        order.setCustomer_number("1234");
        order.setOrder_number("3467");
        order.setOrder_type("ADHOC");
        order.setRoute_number("234");
        order.setDelivery_date("2021-11-16");
        order.setDelivery_method("GROUND");
        order.setOrder_status("SUBMIT");
        order.setTotal_price("2873");
        order.setOrder_date("2023-01-25");

        kafkaMessageProducer.produce(order);

        kafkaMessageProducer.close();

    }
}