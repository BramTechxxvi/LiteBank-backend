package com.liteBank.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse<T> {
    private T response;

    public ErrorResponse(T response) {
        this.response = response;
    }
}
