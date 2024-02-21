package com.smartqueue.order.api.order.representation;

import com.smartqueue.order.domain.item.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Map<Long, String> items;

}
