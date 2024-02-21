package com.smartqueue.order.domain.order.service;

import com.smartqueue.order.api.order.representation.OrderRequest;

public interface OrderService {

    void crete(OrderRequest orderRequest);
}
