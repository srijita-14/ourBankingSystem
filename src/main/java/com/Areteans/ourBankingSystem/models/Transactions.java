package com.Areteans.ourBankingSystem.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Transactions {
    private Long amount;
    private String date;

    public Transactions(Long amount, String date) {
            this.amount = amount;
            this.date = date;
    }
}
