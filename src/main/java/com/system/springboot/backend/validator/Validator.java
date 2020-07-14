package com.system.springboot.backend.validator;

import com.system.springboot.backend.entity.User;
import com.system.springboot.backend.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class Validator {

    public void validator(User user) {
        if(!Objects.nonNull(user.getEmail())) {
            throw new BadRequestException("Invalid Format email", new Exception(""));
        }

    }

    private boolean validFormatEmail(String email) {
        return false;
    }

}
