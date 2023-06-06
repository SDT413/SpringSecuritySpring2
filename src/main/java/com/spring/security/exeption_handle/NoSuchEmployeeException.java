package com.spring.security.exeption_handle;

public class NoSuchEmployeeException extends Throwable {
    public NoSuchEmployeeException(String info) {
        super(info);
    }
}
