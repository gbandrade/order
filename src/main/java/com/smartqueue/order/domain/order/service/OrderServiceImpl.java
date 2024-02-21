package com.smartqueue.order.domain.order.service;

import com.smartqueue.order.api.order.representation.OrderRequest;
import com.smartqueue.order.domain.item.service.ItemService;
import com.smartqueue.order.domain.order.model.Order;
import com.smartqueue.order.domain.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    private ItemService itemService;

    @Override
    public void crete(@RequestBody final OrderRequest orderRequest) {
        log.info("Create new order by request [{}]", orderRequest);

        List<Order.OrderItems> orderItems = getOrderList(orderRequest.getItems());

        repository.save(Order.builder()
                .withOrderItems(orderItems)
                .withTotalAmountInCents(getOrderTotalAmount(orderItems))
                .build());
    }

    private List<Order.OrderItems> getOrderList(final List<OrderRequest.OrderItem> items) {
        List<Order.OrderItems> orderItems = new ArrayList<>();

        items.forEach(item -> {
            orderItems.add(Order.OrderItems.builder()
                    .withUnits(item.units())
                    .withItemId(item.itemId())
                    .withAmountInCents(itemService.get(item.itemId()).get().getAmountInCents())
                    .build());
        });

        return orderItems;
    }

    private List<Order.OrderItems> getOrderList(final Map<Long, String> items) {
        List<Order.OrderItems> orderItems = new ArrayList<>();

        items.forEach((key, value) -> {
            orderItems.add(Order.OrderItems.builder()
                    .withUnits(key)
                    .withItemId(value)
                    .withAmountInCents(itemService.get(value).get().getAmountInCents())
                    .build());
        });

        return orderItems;
    }

    private Long getOrderTotalAmount(final List<Order.OrderItems> orderItems) {
        AtomicLong amount = new AtomicLong();
        orderItems.forEach(item -> amount.addAndGet(item.amountInCents() * item.units()));
        return amount.get();
    }
}
