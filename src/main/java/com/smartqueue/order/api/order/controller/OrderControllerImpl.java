package com.smartqueue.order.api.order.controller;

import com.smartqueue.order.api.order.representation.OrderRequest;
import com.smartqueue.order.domain.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping(value = "order", produces = {"application/json;charset=UTF-8"})
public class OrderControllerImpl implements OrderController {

    private OrderService service;

    @Override
    @PostMapping
    public ResponseEntity<?> create(final OrderRequest orderRequest) {
        service.crete(orderRequest);
        return ResponseEntity.ok().build();
    }
}
