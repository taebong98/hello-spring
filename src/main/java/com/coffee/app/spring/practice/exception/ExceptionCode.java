package com.coffee.app.spring.practice.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    MEMBER_EXISTS(409, "Member exists"),

    COFFEE_NOT_FOUND(404, "Coffee Not Found"),
    COFFEE_EXISTS(409, "Coffee Already exist"),

    ORDER_NOT_FOUND(404, "Order Not Found"),
    ORDER_EXISTS(409, "Order Already exist"),
    CANNOT_CHANGE_ORDER(403, "Order can not change"),

    NOT_IMPLEMENTATION(501, "Not Implementation");

    @Getter private int status;
    @Getter private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
