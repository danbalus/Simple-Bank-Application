package dl.dao;

import dl.connection.ConnectionFactory;
import model.Account;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//Data access object

public class AccountDAO {

	protected static final Logger LOGGER = Logger.getLogger(AccountDAO.class.getName());

    private static final String findStatementString    = "SELECT * FROM account where iban=?";
    private static final String insertStatementString  = "insert into account(iban,typeAccount, amountOfMoney,dateCreation,id)"+" VALUES (?,?,?,?,?)";
    private static final String updateStatementString  = "update account"+" set typeAccount=?,amountOfMoney=?, id=? where iban=?";
    private static final String deleteStatementString  = "delete from account"+" where iban=?";
    private static final String showAllStatementString = "select * from account";

    private static  String [][] updateMatrice = new String[900][900];
    private static int nrLinii;
    
    public static Account findById(String accountId){
        Account toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
            findStatement.setString(1,accountId);
            rs=findStatement.executeQuery();
            rs.next();
            int typeAccount=rs.getInt("typeAccount");
            float amountOfMoney=rs.getFloat("amountOfMoney");
            String dateCreation=rs.getString("dateCreation");
            String id = rs.getString("id");
            toReturn=new Account(accountId,typeAccount,amountOfMoney,dateCreation,id);


        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO:findById " + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int insert(Account account){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setInt(2,account.getTypeAccount());
            insertStatement.setFloat(3,account.getAmountOfMoney());
            insertStatement.setString(4,account.getDateCreation());
            insertStatement.setString(1,account.getIban());
            insertStatement.setString(5,account.getIdClient());

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

        } catch (SQLException e) {
			//LOGGER.log(Level.WARNING, "AccountDAO:insert " + e.getMessage());
            throw new IllegalStateException();
        }finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public static void update(Account account){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updateStatement=null;
         int insertedId=-1;


        try {
            updateStatement=dbConnection.prepareStatement(updateStatementString);

            updateStatement.setInt(1,account.getTypeAccount());
            updateStatement.setFloat(2,account.getAmountOfMoney());
           // updateStatement.setString(3,account.getDateCreation());
            updateStatement.setString(3,account.getIdClient());
            updateStatement.setString(4,account.getIban());

            updateStatement.executeUpdate();



        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO:update " + e.getMessage());
        }finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void delete(String iban){
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement deleteStatement=null;
        // int insertedId=-1;


        try {
            Account account = new Account();
            account = findById(iban);//pt excepie
            deleteStatement=dbConnection.prepareStatement(deleteStatementString);

            deleteStatement.setString(1,iban);

            deleteStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "EmployeeDAO:delete " + e.getMessage());
        }finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }



    }
    public static void updateGUI( ){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement actualizareStatement=null;
        // int insertedId=-1;
        ResultSet rs=null;
        int i=0;
        try {
        	actualizareStatement=dbConnection.prepareStatement(showAllStatementString);
        	rs=actualizareStatement.executeQuery();
            System.out.println("Account===================================================================================================================================================================================================");
            while (rs.next() ) {
        		 String iban = rs.getString("iban");
        		 updateMatrice[i][0] = iban;
        		 
        		  int typeAccount=rs.getInt("typeAccount");
        		  updateMatrice[i][1] = Integer.toString(typeAccount);

                  float amountOfMoney=rs.getFloat("amountOfMoney");
                  updateMatrice[i][2] =Float.toString(amountOfMoney);
                  
                  String dateCreation=rs.getString("dateCreation");
                  updateMatrice[i][3] =dateCreation;

                  String id=rs.getString("id");
                  updateMatrice[i][4] =id;

                 System.out.println("|iban|: " + iban +
                         "    |typeAccount|: "  + "\t" + typeAccount +
                         "    |amountOfMoney|: " + "\t" + amountOfMoney +
                         "    |dateCreation|: " + "\t" + dateCreation +
                         "    |id|: " + "\t" + id
                        );
            
               
                i++;
             }
        	 nrLinii = i;
        	 /*System.out.println();
        	 for (int x = 0; x < i; x++) {
         	    for (int j = 0; j < 4; j++) {
         	        System.out.print(updateMatrice[x][j] + " ");
         	    }
         	    System.out.println();
         	}
        	 System.out.println();*/
            System.out.println("===================================================================================================================================================================================================\n\n");

        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AccountDAO:actualizare" + e.getMessage());
        }finally {
            ConnectionFactory.close(actualizareStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static void transfer(String ibanFrom, String ibanTo, float sumFromResult,float sumToResult ){

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement transferStatement = null;

        try{
            String transferString  = "update account" + " set amountOfMoney=? WHERE iban=?";
            transferStatement = dbConnection.prepareStatement(transferString);
            transferStatement.setFloat(1, sumFromResult);
            transferStatement.setString(2, ibanFrom);
            transferStatement.executeUpdate();

            transferStatement = dbConnection.prepareStatement(transferString);
            transferStatement.setFloat(1, sumToResult);
            transferStatement.setString(2, ibanTo);
            transferStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "AccountDAO:transfer" + e.getMessage());
        }finally {
        ConnectionFactory.close(transferStatement);
        ConnectionFactory.close(dbConnection);
        }
    }

    public static void processUtilitiesBills(String nrBill, String ibanFrom, float newBalance ){

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement transferStatement = null;

        try{
            String transferString  = "update account" + " set amountOfMoney=? WHERE iban=?";
            transferStatement = dbConnection.prepareStatement(transferString);
            transferStatement.setFloat(1, newBalance);
            transferStatement.setString(2, ibanFrom);
            transferStatement.executeUpdate();
            updateMatrice[0][0]="   |    Nr, Bill:       " + nrBill;
            updateMatrice[1][0]="   |    Iban :          " + ibanFrom;
            updateMatrice[2][0]="   |    New Balance:    " + newBalance;
            nrLinii = 3;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "AccountDAO:processUtilitiesBills" + e.getMessage());
        }finally {
            ConnectionFactory.close(transferStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public static String [][] getMatrice()
    {
        return updateMatrice;
    }
    public static int getNrLinii()
    {
        return nrLinii;
    }
}
