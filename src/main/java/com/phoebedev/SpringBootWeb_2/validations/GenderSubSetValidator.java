package com.phoebedev.SpringBootWeb_2.validations;

import com.phoebedev.SpringBootWeb_2.enums.Gender;
import com.phoebedev.SpringBootWeb_2.interfaces.GenderSubSet;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class GenderSubSetValidator implements ConstraintValidator<GenderSubSet, Gender>
{
    private Gender[] genders;


    @Override
    public void initialize(GenderSubSet constraint) {
        this.genders = constraint.anyOf();
    }

    @Override
    public boolean isValid(Gender gender, ConstraintValidatorContext context) {
        return gender == null || Arrays.asList(genders).contains(gender);
    }
}
