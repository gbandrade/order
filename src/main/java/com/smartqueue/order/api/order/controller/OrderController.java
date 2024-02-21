package com.smartqueue.order.api.order.controller;

import com.smartqueue.order.api.order.representation.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderController {

    ResponseEntity<?> create(@RequestBody OrderRequest orderRequest);
}
