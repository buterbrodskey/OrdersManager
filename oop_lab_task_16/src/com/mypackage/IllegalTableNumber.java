package com.mypackage;

public class IllegalTableNumber extends RuntimeException {
    public IllegalTableNumber(String message) {
        super(message);
        System.out.println(message);
    }
}
