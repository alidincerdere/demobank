package com.demobank.account.account_api.infra.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demobank.account.account_api.domain.exception.NoSuchCustomerExistsException;
import com.demobank.account.account_api.infra.rest.AccountController;
import com.demobank.account.account_api.infra.rest.CustomerController;


@RestControllerAdvice(basePackageClasses = {AccountController.class, CustomerController.class})
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handleException(NoSuchCustomerExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}
