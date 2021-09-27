package com.api.controlfood.controller.dto.response.cashier;

import com.api.controlfood.entity.Cashier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CashierResponse {
    private LocalDate date;
    private boolean open;
    private Double openingBalance;
    private Double totalExpenseAmount;
    private Double totalSale;

    public static CashierResponse fromCashier(Cashier cashier){
        return new CashierResponse(
                cashier.getDate(),
                cashier.getOpen(),
                cashier.getOpeningBalance(),
                cashier.getTotalExpenseAmount(),
                cashier.getTotalSale()
        );
    }
}
