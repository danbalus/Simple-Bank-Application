package model;

/**
 * Created by student on 3/24/2018.
 */
public class Employee implements People {

    private String id;//cnp
    private String name;
    private String adress;
    private String nrTel;
    private String email;
    private int age;
    private float salary;
    private  String title;


    public Employee(){}

    public Employee(String id, String name, String adress, String email, int age, String nrTel, float salary, String title){
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.nrTel = nrTel;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.title = title;
    }



    //-----------------------------------------------------GETTERS--------------------------
    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return email;
    }

    public String getId() { return id; }

    public String getAdress() { return adress; }

    public String getName() { return name; }

    public String getNrTel() {
        return nrTel;
    }

    public float getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }



    //-----------------------------------------------------SETTERS--------------------------

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
