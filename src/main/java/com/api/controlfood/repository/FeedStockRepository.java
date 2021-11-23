package com.api.controlfood.repository;

import com.api.controlfood.entity.FeedStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedStockRepository extends JpaRepository<FeedStock, String> {
}
