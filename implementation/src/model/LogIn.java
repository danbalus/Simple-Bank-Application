package model;

public class LogIn {

    private String idlogin;//nickname
    private String password;
    private String statute;

    private LogIn() { }


    public LogIn(String idlogin, String password, String statute) {
        this.idlogin = idlogin;
        this.password = password;
        this.statute = statute;
    }



    public String getIdlogin() {
        return idlogin;
    }

    public void setIdlogin(String idlogin) {
        this.idlogin = idlogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatute() {
        return statute;
    }

    public void setStatute(String statute) {
        this.statute = statute;
    }
}
