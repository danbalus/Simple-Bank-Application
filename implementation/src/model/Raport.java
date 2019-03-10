package model;

import java.text.SimpleDateFormat;

public class Raport {

    private String date;
    private String id;
    private String action;

    public Raport(String id, String action, String date){
        this.id = id;
        this.action = action;
        this.date= date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
