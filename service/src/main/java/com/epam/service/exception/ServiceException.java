/**
 * Class of custom exception
 * @author Ryhor Pishchyk
 * */

package com.epam.service.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
