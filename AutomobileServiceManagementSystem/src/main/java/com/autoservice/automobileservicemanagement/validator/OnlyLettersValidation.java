package com.autoservice.automobileservicemanagement.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OnlyLettersValidation implements ConstraintValidator<OnlyLetters, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null)
            return false;
        return value.matches("^[a-zA-Z ]*$");
    }
}
