package com.api.controlfood.service.impl;

import com.api.controlfood.controller.dto.request.cashier.ClosedCashierRequest;
import com.api.controlfood.controller.dto.request.cashier.OpenCashierRequest;
import com.api.controlfood.controller.dto.request.cashier.SearchCashierDateRequest;
import com.api.controlfood.entity.Cashier;
import com.api.controlfood.repository.CashierRepository;
import com.api.controlfood.service.ICashierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CashierService implements ICashierService {

    private CashierRepository repository;

    public void openCashier(OpenCashierRequest request) {

    }

    public void closedCashier(ClosedCashierRequest request) {

    }

    public Cashier searchByDate(SearchCashierDateRequest request) {
        return null;
    }

    public Page<Cashier> searchByMoth (Pageable page) {
        return null;
    }
}
