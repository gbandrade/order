package com.smartqueue.order.domain.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Document(collection = "order")
public class Order {

    @Id
    private String orderId;

    private Long totalAmountInCents;

    private List<OrderItems> orderItems;

    @Builder(setterPrefix = "with")
    public record OrderItems(Long units, String itemId, Long amountInCents) { }

}
