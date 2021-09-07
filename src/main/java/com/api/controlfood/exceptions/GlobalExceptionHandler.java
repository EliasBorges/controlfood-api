package com.api.controlfood.exceptions;

import com.api.controlfood.controller.dto.request.commons.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
@Slf4j
@PropertySource("classpath:messages.properties")
public class GlobalExceptionHandler {

    public static final int STR_FIELD_NAME = 0;

    @Autowired
    private Environment env;

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    List<ExceptionResponse> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        List<ExceptionResponse> validationErrors = new ArrayList<>();

        for (ObjectError error : exception.getBindingResult().getAllErrors()) {

            if (nonNull(error.getCodes()) && nonNull(error.getCodes()[STR_FIELD_NAME])) {
                validationErrors.add(new ExceptionResponse(
                        error.getDefaultMessage()
                ));
            }
        }

        return validationErrors;
    }

    @ResponseStatus(UNPROCESSABLE_ENTITY)
    @ExceptionHandler({UserExistException.class})
    public @ResponseBody
    ExceptionResponse handlerBusinessRules(UserExistException exception) {
        log.info(exception.getMessage());
        return new ExceptionResponse(env.getProperty(exception.getMessage()));
    }
}
