package bl.validators;

import model.Account;


public class TypeAccountValidator implements Validator<Account> {
    private static final int ACC1 = 1;
    private static final int ACC2 = 2;


    public void validate(Account t) {

        if (t.getTypeAccount() != ACC1 && t.getTypeAccount() != ACC2) {
            throw new IllegalArgumentException("account tip gresit!");
        }

    }

    @Override
    public void validate(float sumFrom, float sum) {
        //useless
    }

}