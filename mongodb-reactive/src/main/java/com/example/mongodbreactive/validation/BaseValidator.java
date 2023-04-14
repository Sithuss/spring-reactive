package com.example.mongodbreactive.validation;

import reactor.core.publisher.Mono;

public interface BaseValidator<T> {
    Mono<T> validate(T t);
}
