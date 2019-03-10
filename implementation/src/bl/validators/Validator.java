package bl.validators;


public interface Validator<T> {

        public void validate(T t);
        public void validate(float sumFrom, float sum);
       // public void validate(Client t);
       //public void validate(Employee t);
        //
       // public int getAge();
       //  public String getEmail();

}
