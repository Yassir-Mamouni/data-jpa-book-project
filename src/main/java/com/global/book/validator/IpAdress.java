package com.global.book.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {IpAdressImpl.class}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IpAdress {
    String message() default "{validation.constraints.ip-address.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
