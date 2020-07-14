package com.system.springboot.backend.validator;

import com.system.springboot.backend.entity.User;
import com.system.springboot.backend.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Validator {

    public void validator(User user) {
        if(!Objects.nonNull(user.getEmail()) || !validFormatEmail(user.getEmail())) {
            throw new BadRequestException("Invalid format email or it doesn't have to be null", new Exception(""));
        }
        if(!Objects.nonNull(user.getName()) || (user.getName().length()<0 || user.getName().length()>50)){
            throw new BadRequestException("\n" +
                    "Invalid character length between 0 and 50 and it doesn't have to be null", new Exception(""));
        }
    }

    private boolean validFormatEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}
