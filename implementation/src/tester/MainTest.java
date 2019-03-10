package tester;

import bl.AccountBLL;
import bl.ClientBLL;
import bl.EmployeeBLL;
import bl.RaportBLL;
import model.Account;
import model.Client;
import model.Employee;
import bl.validators.AgeValidator;
import bl.validators.EmailValidator;
import bl.validators.IbanValidator;

import java.util.Date;
import java.util.Random;

public class MainTest {

	public void mainT(){

		int z = 10;
		if (z == 10)
			System.out.println("10");
		else
			System.out.println("5");
		Date date = new Date();
		System.out.println(date.toString());
//-------------------------------------------------------------CLIENt-----------------------------------------------------------------------------------------------------------------------------------------------------
		Random ran = new Random();
		int x = ran.nextInt(600) + 100;
		Random generate = new Random();
		String[] name = {"Johnnnn", "Marcuss", "Susannn", "Henryyy", "Leonardo", "Messiii", "Bachhhh"};
		String[] name2 = {"Vasileee", "Ionnnnnn", "Vladdddd", "Nicuuuuu", "Mihaiiii", "Raulllll", "Eustache"};
		String zz  = name[generate.nextInt(7)];
		String zz2 = name2[generate.nextInt(7)];
		String zz3 = name[generate.nextInt((7) + generate.nextInt(7))%7];
		String zz4 = name2[generate.nextInt((7) + generate.nextInt(7))%7];



		String test = "1962505555" + x;
		Client client2 = new Client(test, zz + " " + zz2,
				"Str.  Client nr. 10", zz  + zz2 + "@yahoo.com", 22,"0754453445" );
		Client client3 = new Client(test, zz + " " + zz2,
				"Str. Client nr. 10", zz  + zz2 + "@yahoo.com", 7,"0754444535" );
		//ClientDAO clientDAO  = new ClientDAO();
		ClientBLL clientBLL  = new ClientBLL();
//		clientBLL.insert(client2);
		String [][] updateMatrice = new String[900][900];
		//clientDAO.updateGUI();
		clientBLL.updateGUI();


		//updateMatrice = clientDAO.getMatrice();
		//int nr = clientDAO.getNrLinii();
		updateMatrice = clientBLL.getMatrice();
		int nr = clientBLL.getNrLinii();

		System.out.println("Matrice test Client =============================================================================================================================================================================================================");

		System.out.println();
		for (int i = 0; i < nr ; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(updateMatrice[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("End Matrice test Client =============================================================================================================================================================================================================\n\n");



//---------------------------------------------------------------aCCoUNt--------------------------------------------------------------------------------------------------------------------------------------------------

		String test2 = "RO74IBGF4565456987548" + x;
		Account account = new Account(test2, 2,4545.5f,
				new Date().toString(), test  );

		//Account account2 = new Account("RO74IBGF4565456987548564", 1,44545.5f, new Date().toString(),test  );

		//AccountDAO accountDAO = new AccountDAO();
		AccountBLL accountBLL = new AccountBLL();
		accountBLL.insert(account);
		String [][] updateMatrice2;
		//accountDAO.updateGUI();
		accountBLL.updateGUI();


		//updateMatrice2 = accountDAO.getMatrice();
		//int nr2 = accountDAO.getNrLinii();
		updateMatrice2 = accountBLL.getMatrice();
		int nr2 = accountBLL.getNrLinii();
		System.out.println("Matrice test Account =============================================================================================================================================================================================================");
		for (int i = 0; i < nr2 ; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(updateMatrice2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("EndMatrice test Account =============================================================================================================================================================================================================\n\n");

		//accountDAO.transfer("RO74IBGF4565456987548258","RO74IBGF4565456987548635", 500 );
		accountBLL.transfer("RO74IBGF4565456987548258","RO74IBGF4565456987548635", 500 );
		accountBLL.processUtilitiesBills("sdvf2545","RO74IBGF4565456987548393", 45 );

		String [][] updateMatrice5;
		accountBLL.updateGUI();
		//updateMatrice5 = accountDAO.getMatrice();
		updateMatrice5 = accountBLL.getMatrice();

		System.out.println("Matrice test Account after transfer=============================================================================================================================================================================================================");
		for (int i = 0; i < nr2 ; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(updateMatrice5[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("EndMatrice test Account =============================================================================================================================================================================================================\n\n");

//---------------------------------------------------------------EMPLoyEE---------------------------------------------------------------------------------------------------------------------------------------------------------------
		String test3 = "1962505555" + x;
		Employee employee = new Employee(test, zz3 + " " + zz4,
				"Str.  Employee nr. 10", zz3  + zz4 + "@yahoo.com", 22,"0754453445",77777 ,"arhitect software");
		Employee employee2 = new Employee(test, zz3 + " " + zz4,
				"Str. Employee nr. 10", zz3  + zz4 + "@yahoo.com", 7,"0754444535" ,99999, "arhitect software");
		//EmployeeDAO employeeDAO  = new EmployeeDAO();
		EmployeeBLL employeeBLL  = new EmployeeBLL();
//		employeeBLL.insert(employee);
		String [][] updateMatrice3;
		employeeBLL.updateGUI();


		//updateMatrice3 = employeeDAO.getMatrice();
		//int nr3 = employeeDAO.getNrLinii();
		updateMatrice3 = employeeBLL.getMatrice();
		int nr3 = employeeBLL.getNrLinii();

		System.out.println("Matrice test Employee =============================================================================================================================================================================================================");
		for (int i = 0; i < nr3 ; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(updateMatrice3[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("End Matrice test Employee =============================================================================================================================================================================================================\n\n");

//-----------------------------------------VaLIDatoRS-------------------------------------------------------------------------------------------------------------------------------------------------------------------

		AgeValidator ageValidator = new AgeValidator();
		ageValidator.validate(client2);
		//ageValidator.validate(client3);
		EmailValidator emailValidator = new EmailValidator();
		emailValidator.validate(client2);
		//emailValidator.validate(client3);
		IbanValidator ibanValidator = new IbanValidator();
		//ibanValidator.validate(account2);

		//----------------------------------------------account in client test ------------------------------------------------------------------------------------------------
		/*System.out.println(client2.toString());
		client2.addAccount(account.getIban());
		System.out.println(client2.toString());
		client2.addAccount(account2.getIban());
		System.out.println(client2.toString());
		client2.deleteAccount(account2.getIban());
		System.out.println(client2.toString());
		client2.deleteAccount(account.getIban());
		System.out.println(client2.toString());
		client2.deleteAccount(account.getIban());
		System.out.println(client2.toString());*/

		//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		//LogInController logInController = new LogInController();
		//logInController.showLogWindow();

		//AdminGUI adminGUI = new AdminGUI();

		//EmployeeGUI employeeGUI = new EmployeeGUI();

		//adminGUI.createAdmin();
		//employeeGUI.createEmployee();
		//EmployeeDAO.delete("1962505555127");

		String [][] updateMatrice4 ;
		RaportBLL raportBLL = new RaportBLL();
		raportBLL.updateGUI("1962505555101","2018-03-27","2018-03-29");
		raportBLL.getNrLinii();
		updateMatrice4=raportBLL.getMatrice();
		System.out.println("Matrice test RaportBLL =============================================================================================================================================================================================================");
		for (int i = 0; i < nr3 ; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(updateMatrice4[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("End Matrice test RaportBLL =============================================================================================================================================================================================================\n\n");




		//RaportBLL raportBLL = new RaportBLL();
		//System.out.println("cnp");
		//raportBLL.insert("090909090909" ,"added client in BD", "2018-04-04");



	}


}
