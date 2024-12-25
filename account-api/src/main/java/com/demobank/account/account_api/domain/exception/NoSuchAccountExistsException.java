package com.demobank.account.account_api.domain.exception;

public class NoSuchAccountExistsException extends RuntimeException {

    public static final String ACCOUNT_NOT_FOUND = "Account not found with Id ";
    private String message;

    public NoSuchAccountExistsException() {}

    public NoSuchAccountExistsException(String msg) {
        super(ACCOUNT_NOT_FOUND +  msg);
        this.message = ACCOUNT_NOT_FOUND +  msg;
    }
}