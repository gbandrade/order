package com.smartqueue.order.api.item.controller;

import com.smartqueue.order.api.item.representation.ItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

@Tag(name = "Item", description = "Resource for items management")
public interface ItemController {


    @Operation(description = "Returns list of items")
    ResponseEntity<Page<ItemResponse>> list(@ParameterObject @PageableDefault(
            page = 0,
            size = 20,
            sort = "id",
            direction = Sort.Direction.DESC) Pageable pageable);
}
