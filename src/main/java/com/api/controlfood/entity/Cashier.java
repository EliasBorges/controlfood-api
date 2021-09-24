package com.api.controlfood.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cashier {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "opening_balance", nullable = false)
    private Double openingBalance;

    @Column(name = "total_expense_amount", nullable = false)
    private Double totalExpenseAmount;
}
