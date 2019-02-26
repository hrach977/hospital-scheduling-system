package commons.validator;

import commons.entities.Patient;
import commons.validator.anotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {


    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Patient patient = (Patient) o;
        return patient.getPassword().equals(patient.getPasswordConfirmation());
    }
}
