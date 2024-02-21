package com.smartqueue.order.api.order.controller;

import com.smartqueue.order.api.order.representation.OrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Order", description = "Resource for creating order")
public interface OrderController {

    @Operation(description = "Create a new order")
    ResponseEntity<?> create(@RequestBody OrderRequest orderRequest);
}
