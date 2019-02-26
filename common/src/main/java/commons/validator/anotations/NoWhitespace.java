package commons.validator.anotations;


import commons.validator.ContainsWhitespaceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ContainsWhitespaceValidator.class)
@Documented
public @interface NoWhitespace {

    String message() default "Contains whitespace!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
