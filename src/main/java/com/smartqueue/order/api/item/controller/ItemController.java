package com.smartqueue.order.api.item.controller;

import com.smartqueue.order.api.item.representation.ItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

public interface ItemController {

    ResponseEntity<Page<ItemResponse>> list(@PageableDefault(
            page = 0,
            size = 20,
            sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable);
}
