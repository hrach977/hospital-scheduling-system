package commons.validator;

import commons.validator.anotations.NoWhitespace;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsWhitespaceValidator implements ConstraintValidator<NoWhitespace, String> {

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public void initialize(NoWhitespace constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return validate(s);
    }

    public boolean validate(String s) {
        pattern = Pattern.compile("\\s");
        matcher = pattern.matcher(s);
        return !matcher.find();
    }
}
