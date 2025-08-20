package com.liteBank.dtos.response;

public class ErrorResponse(T) {
    private T response;

    public ErrorResponse(T response) {
        this.response = response;
    }
}
