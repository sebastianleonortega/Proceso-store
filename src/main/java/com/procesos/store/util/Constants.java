package com.procesos.store.util;

import lombok.Getter;

@Getter
public enum Constants {

    USER_NOT_FOUND("User not found"),
    ADDRESS_NOT_FOUND("Address not found");

    private String message;

    Constants(String s) {
        this.message = s;
    }
}
