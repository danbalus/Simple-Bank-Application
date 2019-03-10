package bl;

import bl.validators.*;
import dl.dao.EmployeeDAO;
import model.Employee;
import model.People;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class EmployeeBLL  {
    private List<Validator<People>> validators;

    public EmployeeBLL() {
        validators = new ArrayList<Validator<People>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        validators.add(new NrTelValidator());
        validators.add(new IdValidators());
    }

    public Employee findEmployeeById(String id) {
        IdValidators idValidators = new IdValidators();
        idValidators.validateId(id);

        Employee clientCheck = EmployeeDAO.findById(id);

        if (clientCheck == null) {
            throw new NoSuchElementException("Angajatul cu id-ul =" + id + " nu a fost gasit!");
        }
        return clientCheck;
    }


    public int insert(Employee employee) {
        for (Validator<People> v : validators) {
            v.validate(employee);
        }
        return EmployeeDAO.insert(employee);
    }

    public void update(Employee employee)
    {
        for(Validator<People> v:validators)
            v.validate(employee);
        EmployeeDAO.update(employee);
    }

    public void delete(String idEmployee)
    {
       // validators.get(3).validateId(idEmployee);
        IdValidators idValidators = new IdValidators();
        idValidators.validateId(idEmployee);

          EmployeeDAO.delete(idEmployee);
    }

    public void updateGUI()
    {
        EmployeeDAO.updateGUI();
    }

    public  String [][] getMatrice() {
        String [][] updateMatrice;
        updateMatrice = EmployeeDAO.getMatrice();
        return updateMatrice;
    }

    public int getNrLinii(){
        int nrLinii;
        nrLinii = EmployeeDAO.getNrLinii();
        return nrLinii;
    }

}
