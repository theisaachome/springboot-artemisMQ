package com.amq.demo.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;


@Log4j2
public class CustomJMSException implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
    log.debug(t);
    }
}
