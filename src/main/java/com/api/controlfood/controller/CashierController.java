package com.api.controlfood.controller;

import com.api.controlfood.controller.dto.request.cashier.ClosedCashierRequest;
import com.api.controlfood.controller.dto.request.cashier.OpenCashierRequest;
import com.api.controlfood.controller.dto.request.cashier.SearchCashierDateRequest;
import com.api.controlfood.controller.dto.response.cashier.CashierResponse;
import com.api.controlfood.service.ICashierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping("/cashiers")
public class CashierController {

    private final ICashierService service;

    @ResponseStatus(OK)
    @PostMapping("/open")
    public void openCashier(@RequestBody OpenCashierRequest request){
        service.openCashier(request);
    }

    @ResponseStatus(OK)
    @PostMapping("/closed")
    public void closedCashier(@RequestBody ClosedCashierRequest request){
        service.closedCashier(request);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/day")
    public CashierResponse searchByDate(@RequestBody SearchCashierDateRequest request){
        return CashierResponse.fromCashier(service.searchByDate(request));
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/moth")
    public Page<CashierResponse> searchByMoth(
            @PageableDefault(
                    sort = "date",
                    direction = ASC,
                    size = 20
            )
                    Pageable page
    ){
        return service.searchByMoth(page).map(CashierResponse::fromCashier);
    }
}
