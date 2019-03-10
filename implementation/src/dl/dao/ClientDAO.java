package dl.dao;

import model.Client;

import dl.connection.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */

public class ClientDAO {
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private static final  String findStatementString   = "SELECT * FROM client where id=?";
    private static final String insertStatementString  = "insert into client(id,name,adress,email,age, nr_tel)"+" VALUES (?,?,?,?,?,?)";
    private static final String updateStatementString  = "update client"+" set name=?,adress=?,email=?,age=?, nr_tel=? where id=?";
    private static final String deleteStatementString  = "delete from client"+" where id=?";
    private static final String showAllStatementString = "select * from client";

    private static  String [][] updateMatrice = new String[900][900];
    private static int nrLinii;

    public static Client findById(String clientId){
        Client toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
            findStatement.setString(1,clientId);
            rs=findStatement.executeQuery();
            rs.next();
            String name=rs.getString("name");
            String adress=rs.getString("adress");
            String email=rs.getString("email");
            int age=rs.getInt("age");
            String nrTel = rs.getString("nr_tel");
            toReturn=new Client(clientId,name,adress,email,age,nrTel);


        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:findById " + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int insert(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setString(2,client.getName());
            insertStatement.setString(3,client.getAdress());
            insertStatement.setString(4,client.getEmail());
            insertStatement.setInt(5,client.getAge());
            insertStatement.setString(1,client.getId());
            insertStatement.setString(6,client.getNrTel());

            
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }

        } catch (SQLException e) {
			//LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
            throw new IllegalStateException();
        }finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;
    }

    public static void update(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updateStatement=null;
       // int insertedId=-1;


        try {
            updateStatement=dbConnection.prepareStatement(updateStatementString);

            updateStatement.setString(1,client.getName());
            updateStatement.setString(2,client.getAdress());
            updateStatement.setString(3,client.getEmail());
            updateStatement.setInt(4,client.getAge());
            updateStatement.setString(5,client.getNrTel());
            updateStatement.setString(6,client.getId());

            updateStatement.executeUpdate();



        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:update " + e.getMessage());
        }finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void delete(Client client){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement deleteStatement=null;
        // int insertedId=-1;


        try {
            deleteStatement=dbConnection.prepareStatement(deleteStatementString);

            deleteStatement.setString(1,client.getId());

            deleteStatement.executeUpdate();


        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
        }finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }


    }
    public static void updateGUI(){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement actualizareStatement=null;
        // int insertedId=-1;
        ResultSet rs=null;
        int i = 0;
       
        try {
        	actualizareStatement=dbConnection.prepareStatement(showAllStatementString);
        	rs=actualizareStatement.executeQuery();
            System.out.println("Client===================================================================================================================================================================================================");
        	 while (rs.next() ) {

                 String id =rs.getString("id");
        		 updateMatrice[i][0] = id;
        		 
        		 String name=rs.getString("name");
        		 updateMatrice[i][1] = name;
        		 
                 String adress=rs.getString("adress");
        		 updateMatrice[i][2] = adress;

                 String email=rs.getString("email");
        		 updateMatrice[i][3] = email;

                 int age=rs.getInt("age");
        		 updateMatrice[i][4] = Integer.toString(age);

                 String nrTel = rs.getString("nr_tel");
        		 updateMatrice[i][5] = nrTel;

                 System.out.println("|name|: " + name +
                         "    |adress|: "  + "\t" + adress +
                         "    |email|: " + "\t" + email +
                         "    |age|: " + "\t" + age +
                         "    |id|: " +  "\t"+  id +
                         "    |nrTel|: " + "\t" + nrTel);
                i++;
             }
        	 nrLinii = i;
        	 /*System.out.println();
        	 for (int x = 0; x < i; x++) {
         	    for (int j = 0; j < 6; j++) {
         	        System.out.print(updateMatrice[x][j] + " ");
         	    }
         	    System.out.println();
         	}
        	 System.out.println();*/
            System.out.println("===================================================================================================================================================================================================\n\n");


        } catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:actualizare " + e.getMessage());
        }finally {
            ConnectionFactory.close(actualizareStatement);
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
