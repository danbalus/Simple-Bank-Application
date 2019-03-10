package bl.validators;

import model.Account;

import java.util.regex.Pattern;


public class IbanValidator implements Validator<Account> {
    private static final String NRTEL_PATTERN ="[A-Z]{2}+[0-9]{2}+[A-Z]{4}+[0-9]{16}+";

    public void validate(Account t) {
        Pattern pattern = Pattern.compile(NRTEL_PATTERN);
        if (!pattern.matcher(t.getIban()).matches())
        {
            throw new IllegalArgumentException("Acesta  NU este un numar de IBAN valid!");
        }
    }

    @Override
    public void validate(float sumFrom, float sum) {

        //useless
    }
}