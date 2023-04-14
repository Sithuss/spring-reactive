package com.example.mongodbreactive.validation;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import com.example.mongodbreactive.model.CustomerModel;
import reactor.core.publisher.Mono;

public class CustomerValidator implements BaseValidator<CustomerModel> {
    private final Validator<CustomerModel> validator;

    public CustomerValidator() {
        validator = ValidatorBuilder.of(CustomerModel.class)
                .constraint(CustomerModel::getCompanyEmail, "companyEmail", c -> c.notNull().email().notBlank())
                .constraint(CustomerModel::getCompanyName, "companyName", c-> c.notNull().notBlank())
                .build();
    }

    @Override
    public Mono<CustomerModel> validate(CustomerModel customerModel) {
        ConstraintViolations violations = validator.validate(customerModel);
        if (violations.isValid()) {
            return Mono.just(customerModel);
        }
        else {
            return Mono.error(new ValidationException(violations.violations()));
        }
    }
}
