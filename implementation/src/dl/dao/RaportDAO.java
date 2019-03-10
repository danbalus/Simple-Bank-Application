package dl.dao;

import dl.connection.ConnectionFactory;
import model.Raport;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RaportDAO {
    protected static final Logger LOGGER = Logger.getLogger(AccountDAO.class.getName());

    private static final String findStatementString    = "SELECT * FROM raport where id=?";
    private static final String insertStatementString  = "insert into raport(id,action, date_action)"+" VALUES (?,?,?)";
   // private static final String updateStatementString  = "update raport"+" set action=?,date_action=? where id=?";
   // private static final String deleteStatementString  = "delete from raport"+" where iban=?";
    private static final String showAllStatementString = "select * from raport";




    private static  String [][] updateMatrice = new String[900][900];
    private static int nrLinii;

    public static Raport findById(String id){


        Raport toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
            findStatement.setString(1,id);
            rs=findStatement.executeQuery();
            rs.next();

            String idEmployee=rs.getString("id");
            String action = rs.getString("action");
            String date_action = rs.getString("date_action");
            toReturn=new Raport(idEmployee,action,date_action);


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "RaportDAO:findById " + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int insert(String id, String action, String dateAction){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);


            insertStatement.setString(1, id);
            insertStatement.setString(2, action);
            insertStatement.setString(3, dateAction);

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

    public static void updateGUI(String id, String dateFrom, String dateTo ){

       String query = "select * from raport where date_action >= ? and date_action <= ? and id = ?";
       // String query = "SELECT * " +
      //          "FROM raport" +
       //         " WHERE (id=1962505555101 and date_action BETWEEN '2018-03-27' AND '2018-03-29')";
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement actualizareStatement=null;
        // int insertedId=-1;
        ResultSet rs=null;
        int i=0;
        try {

            actualizareStatement=dbConnection.prepareStatement(query);
            actualizareStatement.setString(3,id);
            actualizareStatement.setString(1,dateFrom);
            actualizareStatement.setString(2,dateTo);
            rs=actualizareStatement.executeQuery();
            System.out.println("Raport===================================================================================================================================================================================================");
            while (rs.next() ) {
                String idEmployee = rs.getString("id");
                updateMatrice[i][0] = idEmployee;

                String action=rs.getString("action");
                updateMatrice[i][1] =action;

                String dateAction=rs.getString("date_action");
                updateMatrice[i][2] =dateAction;

                System.out.println("|idEmployee|: " + idEmployee +
                        "    |action|: " + "\t" + action +
                        "    |date_action|: " + "\t" + dateAction
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
            LOGGER.log(Level.WARNING, "AccountDAO:actualizare " + e.getMessage());
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
