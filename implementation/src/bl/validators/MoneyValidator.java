package bl.validators;

import model.Account;


public class MoneyValidator implements Validator<Account> {
    private static final int MIN_SUM = 0;
    private static final int MAX_SUM = 99999999;


    public void validate(Account t) {

        if (t.getAmountOfMoney() < MIN_SUM || t.getAmountOfMoney() > MAX_SUM) {
            throw new IllegalArgumentException("Suma introdusa  nu se incadreaza in limitele admise!");
        }

    }

    @Override
    public void validate(float sumFrom, float sum) {
        //useless
    }

}