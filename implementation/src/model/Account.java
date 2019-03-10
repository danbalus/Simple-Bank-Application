package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private String dateCreation;
    private float amountOfMoney;
    private String iban;
    private int typeAccount; //1 == SavingAccount, 2 == SpendingAccount
    private String idClient;//cnp client


    public Account(){}

    public Account(String iban, int typeAccount){
        this.iban = iban;
        this.typeAccount = typeAccount;
        amountOfMoney = 0;
        this.dateCreation = new Date().toString();
        this.idClient = "";
    }

    public Account(String iban, int typeAccount, float amountOfMoney, String date, String idClient ){
        this.iban = iban;
        this.typeAccount =  typeAccount;
        this.amountOfMoney = amountOfMoney;
        this.dateCreation = date;
        this.idClient = idClient;

    }

    public Account(String iBan, int typeAccount, Float amountOfMoney, String id) {
        this.iban = iBan;
        this.typeAccount =  typeAccount;
        this.amountOfMoney = amountOfMoney;
        this.idClient = id;
    }


    public int getTypeAccount() { return typeAccount; }

    public float getAmountOfMoney() {
        return amountOfMoney;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getIban() {
        return iban;
    }

    public String getIdClient() { return idClient; }


    public void setIdClient(String idClient) { this.idClient = idClient; }

    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }

    public void setAmountOfMoney(float amountOfMoney) { this.amountOfMoney = amountOfMoney; }

    public void setIban(String iban) { this.iban = iban; }

    public void setTypeAccount(int typeAccount) { this.typeAccount = typeAccount; }
}
