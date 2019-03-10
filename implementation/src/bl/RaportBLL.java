package bl;

import dl.dao.RaportDAO;
import model.Raport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import static dl.dao.RaportDAO.findById;


public class RaportBLL {

   public RaportBLL() {
      // validators = new ArrayList<Validator<Account>>();
      // validators.add(new IbanValidator());
       //validators.add(new TypeAccountValidator());
     //  validators.add(new MoneyValidator());
     //  validators.add(new SumToTransfer());

   }

    public Raport findRaportById(String iban) {
        Raport raportCheck = findById(iban);
        if (raportCheck == null) {
            throw new NoSuchElementException("Account-ul cu iban-ul =" + iban + " nu a fost gasit!");
        }
        return raportCheck;
    }

    public int insert( String id, String action, Date dateAction) {
       // for (Validator<Account> v : validators) {
       //     v.validate(account);
       // }
        SimpleDateFormat format = new SimpleDateFormat();

        format = new SimpleDateFormat("yyyy-MM-dd");
        //Date curDate = new Date();
        String DateToStr = format.format(dateAction);


        return RaportDAO.insert( id,  action,  DateToStr);
    }


    public void updateGUI(String id, String dateFrom, String dateTo)
    {
           /* Date curDate = new Date();

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    String DateToStr = format.format(curDate);
  System.out.println(DateToStr);*/
       RaportDAO.updateGUI( id, dateFrom, dateTo);
    }

    public  String [][] getMatrice() {
        String [][] updateMatrice;
        updateMatrice = RaportDAO.getMatrice();
        return updateMatrice;
    }

    public int getNrLinii(){
        int nrLinii;
        nrLinii = RaportDAO.getNrLinii();
        return nrLinii;
    }

}
