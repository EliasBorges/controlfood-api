package com.api.controlfood.service.impl;

import com.api.controlfood.ControlFoodMessage;
import com.api.controlfood.controller.dto.request.feedstock.FeedStockRequest;
import com.api.controlfood.entity.FeedStock;
import com.api.controlfood.exceptions.FeedStockNotFoundException;
import com.api.controlfood.repository.FeedStockRepository;
import com.api.controlfood.service.IFeedStock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class FeedStockService implements IFeedStock {
    private final FeedStockRepository repository;

    public String create(FeedStockRequest request) {
        return FeedStock.create(request, repository);
    }

    public String update(String id, FeedStockRequest request) {
        FeedStock stock = repository.findById(id).orElseThrow(() -> {
            log.error("[FEEDSTOCK] - Not delete, id feed stock = {} not found", id);

            throw new FeedStockNotFoundException(ControlFoodMessage.FEED_STOCK_NOT_FOUND);
        });

        log.info("[FEEDSTOCK] - Update feed stock, id = {}, feedStockBefore = {}, feedStockAfter = {}",
                id,
                request,
                stock);

        return stock.update(request, repository);
    }

    public void delete(String id) {
        FeedStock stock = repository.findById(id).orElseThrow(() -> {
            log.error("[FEEDSTOCK] - Not delete, id feed stock = {} not found", id);

            throw new FeedStockNotFoundException(ControlFoodMessage.FEED_STOCK_NOT_FOUND);
        });

        log.info("[FEEDSTOCK] - Delete feed stock = {}", stock);

        stock.delete(repository);
    }

    public Page<FeedStock> findAll(Pageable page) {
        return repository.findAll(page);
    }
}
