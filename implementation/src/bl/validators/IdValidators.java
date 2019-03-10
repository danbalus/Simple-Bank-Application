package bl.validators;

import model.People;

import java.util.regex.Pattern;

public class IdValidators implements Validator<People> {
    private static final String ID_PATTERN ="[1-2]{1}+[0-9]{2}+[0-3]{1}+[0-9]{1}+[0-1]{1}+[0-9]{1}+[0-9]{6}+";

    public void validate(People t) {
        Pattern pattern = Pattern.compile(ID_PATTERN);
        if (!pattern.matcher(t.getId()).matches())
        {
            throw new IllegalArgumentException("Acesta  NU este un numar de CNP valid!");
           // throw new idException("f");
        }
    }

    @Override
    public void validate(float sumFrom, float sum) {
        //useless
    }
    public void validateId(String id) {
        Pattern pattern = Pattern.compile(ID_PATTERN);
        if (!pattern.matcher(id).matches())
        {
            throw new IllegalArgumentException("Acesta  NU este un numar de CNP valid!");
        }
    }
}