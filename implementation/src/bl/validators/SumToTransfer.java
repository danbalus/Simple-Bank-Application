package bl.validators;

import model.Account;


    public class SumToTransfer implements Validator<Account> {
        //private static final int MIN_SUM = 0;
        private static final int MAX_SUM = 50000;


        @Override
        public void validate(Account account) {
            //useless
        }

        public void validate(float sumFrom, float sum) {

            if (sumFrom < sum || sum > MAX_SUM || sum < 0 ) {
                throw new IllegalArgumentException("Suma tansferata este mai mare decat soldul sau nu se incadreaza in limitele admise!");
            }

        }

    }

