package com.coffee.app.spring.practice.response;


import com.coffee.app.spring.practice.exception.ExceptionCode;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private List<FieldErrorInfo> fieldErrors;
    private List<ConstraintViolationErrorInfo> violationErrors;

    private ErrorResponse(List<FieldErrorInfo> fieldErrors, List<ConstraintViolationErrorInfo> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    private ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldErrorInfo.of(bindingResult), null);
    }

    public static ErrorResponse of(Set<ConstraintViolation<?>> constraintViolations) {
        return new ErrorResponse(null, ConstraintViolationErrorInfo.of(constraintViolations));
    }

    public static ErrorResponse of(ExceptionCode exceptionCode) {
        return new ErrorResponse(exceptionCode.getStatus(), exceptionCode.getMessage());
    }

    @Getter
    public static class FieldErrorInfo {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldErrorInfo(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldErrorInfo> of(BindingResult bindingResult) {
            final List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(error -> new FieldErrorInfo(
                            error.getField(),
                            error.getRejectedValue() == null?"" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()
                    ))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class ConstraintViolationErrorInfo {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationErrorInfo(String propertyPath, Object rejectedValue, String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationErrorInfo> of(Set<ConstraintViolation<?>> constraintViolations){
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationErrorInfo(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }
}
