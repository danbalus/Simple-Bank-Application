package bl.validators;
import model.People;

public class AgeValidator implements Validator<People> {
    private static final int MAX_AGE = 121;
    private static final int MIN_AGE = 18;


    public void validate(People t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("Varsta introdusa  nu se incadreaza in limitele admise!");
        }

    }

    @Override
    public void validate(float sumFrom, float sum) {
        //useless
    }

}
