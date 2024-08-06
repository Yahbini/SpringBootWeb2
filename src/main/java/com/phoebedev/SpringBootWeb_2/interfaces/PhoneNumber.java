package com.phoebedev.SpringBootWeb_2.interfaces;

import com.phoebedev.SpringBootWeb_2.validations.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class) // rằng buộc phải gọi sang PhoneValidtor
@Target({ElementType.METHOD, ElementType.FIELD}) // Áp dụng với Method và field
@Retention(RetentionPolicy.RUNTIME) // chạy môi trường runtime
public @interface PhoneNumber {
    String message() default "Invalid phone number";
    Class<?>[]groups() default {};
    Class<? extends Payload>[] payload() default {};
}
