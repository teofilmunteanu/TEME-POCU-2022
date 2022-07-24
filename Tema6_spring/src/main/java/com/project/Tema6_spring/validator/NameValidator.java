package com.project.Tema6_spring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, String> {
    @Override
    public void initialize(NameConstraint constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nameField, ConstraintValidatorContext ctx){
        return nameField != null &&  nameField.length() > 1 && nameField.length() < 50;
    }
}
