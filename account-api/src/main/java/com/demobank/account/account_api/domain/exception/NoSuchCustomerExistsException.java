package com.demobank.account.account_api.domain.exception;


public class NoSuchCustomerExistsException extends RuntimeException {

    public static final String CUSTOMER_NOT_FOUND = "Customer not found with Id ";
    private String message;

    public NoSuchCustomerExistsException() {}

    public NoSuchCustomerExistsException(String msg) {
        super(CUSTOMER_NOT_FOUND +  msg);
        this.message = CUSTOMER_NOT_FOUND +  msg;
    }
}
