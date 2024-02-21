package com.smartqueue.order.domain.item.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Document(collection = "item")
public class Item {

    private String id;

    private String name;

    private String description;

    private Long amountInCents;
}
