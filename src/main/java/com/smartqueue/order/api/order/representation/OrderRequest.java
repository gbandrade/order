package com.smartqueue.order.api.order.representation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private List<OrderItem> items;

    public record OrderItem(@Schema(description = "Number of items", example = "4") Long units,
                            @Schema(description = "Item Id", example = "65d552bc3c175abc76126308") String itemId) {
    }
}
