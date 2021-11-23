package com.api.controlfood.service.impl;

import com.api.controlfood.ControlFoodMessage;
import com.api.controlfood.controller.dto.request.product.ProductRequest;
import com.api.controlfood.controller.dto.response.product.DiscountMarginByProductResponse;
import com.api.controlfood.entity.FeedStock;
import com.api.controlfood.entity.Product;
import com.api.controlfood.exceptions.FeedStockNotFoundException;
import com.api.controlfood.exceptions.ProductNotFoundException;
import com.api.controlfood.exceptions.SalueValueLessThanCostValueException;
import com.api.controlfood.repository.FeedStockRepository;
import com.api.controlfood.repository.ProductRepository;
import com.api.controlfood.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements IProductService {
    private final ProductRepository repository;
    private final FeedStockRepository feedStockRepository;

    public String create(ProductRequest request) {
        List<FeedStock> stocks = new ArrayList<>();

        request.getStocks().forEach(
                stock -> {
                    FeedStock feedStock = feedStockRepository
                            .findById(stock.getId())
                            .orElseThrow(() -> {
                                        log.error("[PRODUCT-FEEDSTOCK] - Not update, id feedStock = {} not found", stock.getId());

                                        throw new FeedStockNotFoundException(ControlFoodMessage.FEED_STOCK_NOT_FOUND);
                                    }

                            );

                    request.setCostValue(request.getCostValue() + feedStock.getValue());
                    stocks.add(feedStock);
                });

        validSalueValue(request);

        return Product.create(request, stocks, repository);
    }

    public String update(String id, ProductRequest request) {
        Product product = repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not update, id product = {} not found", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });

        List<FeedStock> stocks = new ArrayList<>();

        request.getStocks().forEach(
                stock -> {
                    FeedStock feedStock = feedStockRepository
                            .findById(stock.getId())
                            .orElseThrow(() -> {
                                        log.error("[PRODUCT-FEEDSTOCK] - Not update, id feedStock = {} not found", stock.getId());

                                        throw new FeedStockNotFoundException(ControlFoodMessage.FEED_STOCK_NOT_FOUND);
                                    }

                            );

                    request.setCostValue(request.getCostValue() + feedStock.getValue());
                    stocks.add(feedStock);
                });

        validSalueValue(request);

        log.info("[PRODUCT] - Update product, id = {}, productBefore = {}, productAfter = {}",
                id,
                request,
                product);

        return product.update(request, stocks, repository);
    }

    public void delete(String id) {
        Product product = repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not delete, id product = {} not found", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });

        log.info("[PRODUCT] - Delete product = {}", product);

        product.delete(repository);
    }

    public Product findById(String id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not found, id product = {}", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });
    }

    public Product findByName(String name) {
        return repository.findByNameContaining(name).orElseThrow(() -> {
            log.error("[PRODUCT] - Not found, name product = {}", name);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });
    }

    public Page<Product> findAll(Pageable page) {
        return repository.findAll(page);
    }

    public DiscountMarginByProductResponse findDiscountMarginByProduct(String id) {

        Product product = repository.findById(id).orElseThrow(() -> {
            log.error("[PRODUCT] - Not found, id product = {}", id);

            throw new ProductNotFoundException(ControlFoodMessage.PRODUCT_NOT_FOUND);
        });

        return calculateDiscount(product);

        //Double valorComPercentualMaximoRecomendado = product.getCostValue() + (0.28 * product.getCostValue());

/*        if (valorComPercentualMaximoRecomendado > product.getSaleValue() ||
                product.getSaleValue() > valorComPercentualMaximoRecomendado) {

            Double valorDesconto = product.getSaleValue() - valorComPercentualMaximoRecomendado;

            if (valorDesconto > 0) {
                return new DiscountMarginByProductResponse(
                        "Você pode dar um desconto de ate R$" + new DecimalFormat("##.##").format(valorDesconto) + " neste produto."
                );
            } else {
                return new DiscountMarginByProductResponse(
                        "Você esta tendo um prejuizo neste produto de R$" +
                                new DecimalFormat("##.##")
                                        .format(valorDesconto)
                                        .replace("-", "")
                );
            }

        }*/
    }

    private void validSalueValue(ProductRequest request) {
        if (request.getSaleValue() <= request.getCostValue()) {
            log.error("[PRODUCT] - Salue value {} less than cost value {}",
                    request.getSaleValue(), request.getCostValue());

            throw new SalueValueLessThanCostValueException(ControlFoodMessage.SALUE_VALUE_BOTTOM_COST_VALUE);
        }
    }

    private DiscountMarginByProductResponse calculateDiscount(Product product) {
        Double minimumValueSale = product.getCostValue() + (0.26 * product.getCostValue());
        Double discountValue = product.getSaleValue() - minimumValueSale;

        if (product.getSaleValue() >= minimumValueSale) {
            return new DiscountMarginByProductResponse(
                    "Você pode dar um desconto de ate R$" +
                            new DecimalFormat("##.##")
                                    .format(discountValue) + " neste produto."
            );
        } else {
            return new DiscountMarginByProductResponse(
                    "Você esta tendo um prejuizo neste produto de R$" +
                            new DecimalFormat("##.##")
                                    .format(discountValue)
                                    .replace("-", "")
            );
        }
    }
}
