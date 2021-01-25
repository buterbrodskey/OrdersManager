package com.mypackage;

public class OrderAlreadyException extends Exception {
    OrderAlreadyException(String message) {
        super(message);
        System.out.println(message);
    }
}
