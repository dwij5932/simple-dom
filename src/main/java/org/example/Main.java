package org.example;

//import org.example.entity.Order;
import org.example.utils.KafkaMessageProducer;
import org.order.status.Order;
import org.order.status.Order_Status;
import org.order.status.Order_Type;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        KafkaMessageProducer kafkaMessageProducer = new KafkaMessageProducer();

//        Order order = new Order();
//        order.setSeller_id("USBL");
//        order.setCustomer_number("1235");
//        order.setOrder_number("3467");
//        order.setOrder_type("ADHOC");
//        order.setRoute_number("234");
//        order.setDelivery_date("2021-11-16");
//        order.setDelivery_method("GROUND");
//        order.setOrder_status("SUBMIT");
//        order.setTotal_price("2873");
//        order.setOrder_date("2023-01-25");

        Order order = Order.newBuilder()
                .setMessageId("1")
                .setSellerId("USBL")
                .setCustomerNumber("123456")
                .setOrderNumber("3456")
                .setOrderType(Order_Type.ADHOC)
                .setRouteNumber("3")
                .setDeliveryDate("2021-11-16")
                .setDeliveryMethod("GROUND")
                .setOrderStatus(Order_Status.SUBMIT)
                .setTotalPrice(BigDecimal.valueOf(234.12))
                .setOrderDate("2023-01-25")
                .setCreatedTimestamp(new Date().toString())
                .build();

        kafkaMessageProducer.produce(order);

        kafkaMessageProducer.close();

    }
}