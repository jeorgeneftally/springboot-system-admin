package com.system.springboot.backend.validator;

import com.system.springboot.backend.exception.BadRequestException;
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator implements ConstraintValidator<ValidatorEmail, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.nonNull(s) || validFormatEmail(s)){
            throw new BadRequestException("Invalid format email or it doesn't have to be null", new Exception(""));
        }
        return true;
    }

    private boolean validFormatEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
