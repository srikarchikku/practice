package com.project.springboot.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateConstraintValidator implements ConstraintValidator<DatePattern, Date> {

    private static final String Date_Pattern = "(\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-2]|3[0-1])$)";
    private Pattern pattern;
    private Matcher matcher;

    public DateConstraintValidator() {
        pattern = Pattern.compile(Date_Pattern);
    }

    @Override
    public void initialize(DatePattern datePattern) {
        datePattern.message();
    }

    @Override
    public boolean isValid(Date doj, ConstraintValidatorContext cxt) {
        if(doj == null) {
            return false;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(doj);
        matcher = pattern.matcher(strDate);
        return matcher.matches();
    }


}
