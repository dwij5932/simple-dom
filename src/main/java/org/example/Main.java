package org.example;

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

        Order order = Order.newBuilder()
                .setMessageId("17")
                .setSellerId("USBL")
                .setCustomerNumber("CUST004")
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

        Thread.sleep(2000);

        Order order2 = Order.newBuilder()
                .setMessageId("18")
                .setSellerId("USBL")
                .setCustomerNumber("CUST004")
                .setOrderNumber("3456")
                .setOrderType(Order_Type.ADHOC)
                .setRouteNumber("3")
                .setDeliveryDate("2021-11-16")
                .setDeliveryMethod("GROUND")
                .setOrderStatus(Order_Status.CANCEL)
                .setTotalPrice(BigDecimal.valueOf(234.12))
                .setOrderDate("2023-01-25")
                .setCreatedTimestamp(new Date().toString())
                .build();

        kafkaMessageProducer.produce(order2);
        kafkaMessageProducer.produce(order);

        kafkaMessageProducer.close();

    }
}