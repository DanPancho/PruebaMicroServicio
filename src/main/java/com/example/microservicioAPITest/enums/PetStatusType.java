package com.example.microservicioAPITest.enums;

import lombok.Getter;

@Getter
public enum PetStatusType {
    available("available"),
    sold("sold");

    private String status;

    PetStatusType(String status) {
        this.status = status;
    }
}
