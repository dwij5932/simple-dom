package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;

@Data
@AllArgsConstructor
public class Order {

    @JsonProperty("seller_id")
    private String seller_id;

    @JsonProperty("customer_number")
    private String customer_number;

    @JsonProperty("order_number")
    private String order_number;

    @JsonProperty("order_type")
    private String order_type;

    @JsonProperty("route_number")
    private String route_number;

    @JsonProperty("delivery_date")
    private String delivery_date;

    @JsonProperty("delivery_method")
    private String delivery_method;

    @JsonProperty("order_status")
    private String order_status;

    @JsonProperty("total_price")
    private String total_price;

    @JsonProperty("order_date")
    private String order_date;

    @JsonProperty("created_timestamp")
    private String created_timestamp;

    @JsonProperty("updated_timestamp")
    private String updated_timestamp;

    public Order() {
        this.created_timestamp= Instant.now().toString();
        this.updated_timestamp = this.created_timestamp;
    }
}

