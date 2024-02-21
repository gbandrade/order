package com.smartqueue.order.api.item.representation;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
@EqualsAndHashCode(callSuper = false)
public class ItemResponse extends RepresentationModel<ItemResponse> {

    private String id;

    private String name;

    private String description;

    private Long amountInCents;
}
