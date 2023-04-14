package com.example.mongodbreactive.validation;

import am.ik.yavi.core.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class ValidationException extends RuntimeException{
    @Getter
    final List<ConstraintViolation> errors;
}
