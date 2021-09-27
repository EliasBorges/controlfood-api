package com.api.controlfood.service;

import com.api.controlfood.controller.dto.request.cashier.ClosedCashierRequest;
import com.api.controlfood.controller.dto.request.cashier.OpenCashierRequest;
import com.api.controlfood.controller.dto.request.cashier.SearchCashierDateRequest;
import com.api.controlfood.entity.Cashier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICashierService {
    void openCashier(OpenCashierRequest request);

    void closedCashier(ClosedCashierRequest request);

    Cashier searchByDate(SearchCashierDateRequest request);

    Page<Cashier> searchByMoth(Pageable page);
}
