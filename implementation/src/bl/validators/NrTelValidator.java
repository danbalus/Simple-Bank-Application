package bl.validators;

import model.People;

import java.util.regex.Pattern;


public class NrTelValidator implements Validator<People> {
    private static final String NRTEL_PATTERN ="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public void validate(People t) {
        Pattern pattern = Pattern.compile(NRTEL_PATTERN);
        if (!pattern.matcher(t.getNrTel()).matches())
        {
            throw new IllegalArgumentException("Acesta  NU este un numar de telefon valid!");
        }
    }

    @Override
    public void validate(float sumFrom, float sum) {
        //useless
    }
}