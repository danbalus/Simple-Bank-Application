package model;

public interface People {

    //-----------------------------------------------------GETTERS--------------------------
    public int getAge();
    public String getEmail();
    public String getId();
    public String getAdress();
    public String getName() ;
    public String getNrTel();
    public float getSalary();
    public String getTitle();

    //-----------------------------------------------------SETTERS--------------------------
    public void setId(String id);
    public void setName(String name);
    public void setAdress(String adress);
    public void setEmail(String email);
    public void setNrTel(String nrTel);
    public void setAge(int age);
    public void setTitle(String title);
    public void setSalary(float salary);

}