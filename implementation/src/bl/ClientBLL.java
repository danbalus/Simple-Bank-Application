package bl;

import bl.validators.*;
import model.People;
import dl.dao.ClientDAO;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL  {
    private List<Validator<People>> validators;
    //EmailValidator emailValidator = new EmailValidator();
    //People people = new Client();

    public ClientBLL() {
        validators = new ArrayList<Validator<People>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        validators.add(new NrTelValidator());
        validators.add(new IdValidators());
    }

    public Client findClientById(String id) {
        Client clientCheck = ClientDAO.findById(id);
        if (clientCheck == null) {
            throw new NoSuchElementException("Clientul cu id-ul =" + id + " nu a fost gasit!");
        }
        return clientCheck;
    }

    public int insert(Client client) {
        for (Validator<People> v : validators) {
            v.validate(client);
        }

        return ClientDAO.insert(client);
    }

    public void update(Client client)
    {
        for(Validator<People> v:validators)
            v.validate(client);

        ClientDAO.update(client);
    }

    public void delete(Client client)
    {
       ClientDAO.delete(client);
    }
    
    public void updateGUI()
    {
        ClientDAO.updateGUI();
    }

    public  String [][] getMatrice() {
        String [][] updateMatrice;
        updateMatrice = ClientDAO.getMatrice();
        return updateMatrice;
    }

    public int getNrLinii(){
        int nrLinii;
        nrLinii = ClientDAO.getNrLinii();
        return nrLinii;
    }

}
