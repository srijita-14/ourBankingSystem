package com.Areteans.ourBankingSystem.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name = "user")
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long user_id;
        private Long balance;
        private String account_no;
        private String name;
        private String address;
        private Long contact;
    }

