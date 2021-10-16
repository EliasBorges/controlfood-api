package com.api.controlfood.controller;

import com.api.controlfood.controller.dto.request.feedstock.FeedStockRequest;
import com.api.controlfood.controller.dto.response.feedstock.FeedStockResponse;
import com.api.controlfood.controller.dto.response.base.IdResponse;
import com.api.controlfood.service.IFeedStock;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/stocks")
public class FeedStockController {
    private final IFeedStock service;

    @ResponseStatus(CREATED)
    @PostMapping
    public IdResponse create(@Valid @RequestBody FeedStockRequest request){
        return new IdResponse(service.create(request));
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{id}")
    public IdResponse update(
            @PathVariable String id,
            @Valid @RequestBody FeedStockRequest request
            ){
        return new IdResponse(service.update(id, request));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @ResponseStatus(OK)
    @GetMapping
    public Page<FeedStockResponse> findAll(
            @PageableDefault(
                    sort = "name",
                    direction = ASC,
                    size = 20
            )
                    Pageable page
    ) {
        return service.findAll(page).map(FeedStockResponse::fromStock);
    }
}
