package com.smartqueue.order.domain.item.service;

import com.smartqueue.order.domain.item.model.Item;
import com.smartqueue.order.domain.item.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{

    private ItemRepository repository;

    @Override
    public Page<Item> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Item> get(final String id) {
        return repository.findById(id);
    }
}
