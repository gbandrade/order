package com.smartqueue.order.api.item.controller;

import com.smartqueue.order.api.item.representation.ItemResponse;
import com.smartqueue.order.domain.item.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@AllArgsConstructor
@RequestMapping(value = "item", produces = {"application/json;charset=UTF-8"})
public class ItemControllerImpl implements ItemController {

    private ItemService service;

    @Override
    @GetMapping
    public ResponseEntity<Page<ItemResponse>> list(@PageableDefault(
            page = 0,
            size = 20,
            sort = "createdAt",
            direction = Sort.Direction.DESC) final Pageable pageable) {

        Page<ItemResponse> itemResponsePage = service.list(pageable)
                .map(item -> ItemResponse.builder()
                        .withId(item.getId())
                        .withName(item.getName())
                        .withDescription(item.getDescription())
                        .withAmountInCents(item.getAmountInCents())
                        .build());

        return ResponseEntity.ok(itemResponsePage);
    }
}
