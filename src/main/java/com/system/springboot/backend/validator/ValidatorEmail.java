package com.system.springboot.backend.validator;


//import javax.validation.Constraint;
//import javax.validation.Payload;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Validator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface ValidatorEmail {

    String message() default "{validatorEmail.msjByDefault}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
