package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.feedstock.FeedStockRequest;
import com.api.controlfood.entity.FeedStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFeedStock {
    String create(FeedStockRequest request);

    String update(String id, FeedStockRequest request);

    void delete(String id);

    Page<FeedStock> findAll(Pageable page);
}
