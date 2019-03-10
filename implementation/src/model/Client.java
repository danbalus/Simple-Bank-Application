package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client implements People {


    private String id;//cnp
    private String name;
    private String adress;
    private String email;
    private String nrTel;
    private int age;
    // String [] accounts;

    public Client() { }


    public Client(String id, String name, String adress, String email, int age, String nrTel) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.nrTel = nrTel;
        this.email = email;
        this.age = age;
        //accounts = new ArrayList<String>();

    }

    //---------------------------------------MEtoDES--------------------------------------------------------------------------------------------------------------------------------------------------------------------

   /// public void addAccount(String ibanAccount){
  //      accounts.add(ibanAccount);
 //   }

//    public void deleteAccount(String ibanAccount){
 //       accounts.remove(ibanAccount);
  //  }
    public String toString(){
        return ("|name|: " + name +
                "    |adress|: "  + "\t" + adress +
                "    |email|: " + "\t" + email +
                "    |age|: " + "\t" + age +
                "    |id|: " +  "\t"+  id +
                "    |nrTel|: " + "\t" + nrTel
               // + "    |accounts|: " + "\t" + Arrays.toString(accounts.toArray())

        );
    }

    //--------------------------------------GEttERS----------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
          return email;
    }

    public String getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public String getName() {
        return name;
    }

    public String getNrTel() {
        return nrTel;
    }

    //public List<String> getAccounts() { return accounts; }


////----------------------------------------------SEttERS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

   // public void setAccounts(List<String> accounts) { this.accounts = accounts; }

    //------------------------------------------USELESS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override // not needed here
    public float getSalary() { return 0; }

    @Override // not needed here
    public void setTitle(String title) { }

    @Override // not needed here
    public void setSalary(float salary) { }

    @Override // not needed here
    public String getTitle() { return null;}
}
