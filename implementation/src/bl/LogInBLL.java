package bl;

//import AccountDAO;
import dl.dao.LogInDAO;
//import model.Account;


public class LogInBLL {
   // private List<Validator<LogIn>> validators;

    public LogInBLL() {
       // validators = new ArrayList<Validator<LogIn>>();
       // validators.add(new IbanValidator());
       // validators.add(new TypeAccountValidator());
       // validators.add(new MoneyValidator());
       // validators.add(new SumToTransfer());

    }

    public void updateGUI()
    {
        LogInDAO.updateGUI();
    }

    public  String [][] getMatrice() {
        String [][] updateMatrice;
        updateMatrice = LogInDAO.getMatrice();
        return updateMatrice;
    }

    public int getNrLinii(){
        int nrLinii;
        nrLinii = LogInDAO.getNrLinii();
        return nrLinii;
    }

}
