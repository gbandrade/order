package com.smartqueue.order.domain.item.service;

import com.smartqueue.order.domain.item.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ItemService {

    Page<Item> list(Pageable pageable);

    Optional<Item> get(String id);
}
