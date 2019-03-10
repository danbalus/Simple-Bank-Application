package bl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bl.validators.*;
import dl.dao.AccountDAO;
import model.Account;

;import static dl.dao.AccountDAO.findById;

//BUINESS L0GIC LayER



public class AccountBLL {
	private List<Validator<Account>> validators;

	public AccountBLL() {
		validators = new ArrayList<Validator<Account>>();
		validators.add(new IbanValidator());
		validators.add(new TypeAccountValidator());
		validators.add(new MoneyValidator());
		validators.add(new SumToTransfer());

	}

	public Account findAccountById(String iban) {
		Account accountCheck = findById(iban);
		if (accountCheck == null) {
			throw new NoSuchElementException("Account-ul cu iban-ul =" + iban + " nu a fost gasit!");
		}
		return accountCheck;
	}

	public int insert(Account account) {
		for (Validator<Account> v : validators) {
			v.validate(account);
		}
		return AccountDAO.insert(account);
	}

	public void update(Account account)
	{
		for(Validator<Account> v:validators)
			v.validate(account);
		AccountDAO.update(account);
	}

	public void delete(String iban)
	{
		AccountDAO.delete(iban);
	}

	public void updateGUI()
	{
		AccountDAO.updateGUI();
	}

	public  String [][] getMatrice() {
		String [][] updateMatrice;
		updateMatrice = AccountDAO.getMatrice();
		return updateMatrice;
	}

	public int getNrLinii(){
		int nrLinii;
		nrLinii = AccountDAO.getNrLinii();
		return nrLinii;
	}

	public void transfer( String ibanFrom, String ibanTo, float sumToTransfer )
	{
		Account accountFrom = new Account();
		Account accountTo = new Account();

		accountFrom = findById(ibanFrom);
		accountTo = findById(ibanTo);

		float sumFrom = accountFrom.getAmountOfMoney();
		float newBalanceFrom = sumFrom - sumToTransfer;

		float sumTo= accountTo.getAmountOfMoney();
		float newBalanceTo = sumTo + sumToTransfer;

		for(Validator<Account> v:validators)
			v.validate(sumFrom, sumToTransfer);

		AccountDAO.transfer(ibanFrom, ibanTo, newBalanceFrom, newBalanceTo);
	}

	public void processUtilitiesBills(String nrBill, String ibanFrom, float sumToPay){
		Account accountFrom = new Account();
		accountFrom = findById(ibanFrom);

		float sumFrom = accountFrom.getAmountOfMoney();
		float newBalance = sumFrom - sumToPay;

		for(Validator<Account> v:validators)
			v.validate(sumFrom, sumToPay);

		AccountDAO.processUtilitiesBills(nrBill, ibanFrom, newBalance);

	}

}
