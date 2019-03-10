package dl.dao;

import dl.connection.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInDAO {

    protected static final Logger LOGGER = Logger.getLogger(AccountDAO.class.getName());

    private static final String showAllStatementString = "select * from login";

    private static  String [][] updateMatrice = new String[900][900];
    private static int nrLinii;

    public static void updateGUI( ){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement actualizareStatement=null;
        // int insertedId=-1;
        ResultSet rs=null;
        int i=0;
        try {
            actualizareStatement=dbConnection.prepareStatement(showAllStatementString);
            rs=actualizareStatement.executeQuery();
            System.out.println("Login===================================================================================================================================================================================================");
            while (rs.next() ) {
                String idlogin = rs.getString("idlogin");
                updateMatrice[i][0] = idlogin;

                String password=rs.getString("password");
                updateMatrice[i][1] = password;

                String statute=rs.getString("statute");
                updateMatrice[i][2] = statute;

                String cnp=rs.getString("id");
                updateMatrice[i][3] = cnp;

                System.out.println("|idlogin|: " + idlogin +
                        "    |password|: "  + "\t" + password +
                        "    |statute|: " + "\t" + statute +
                        "    |cnp|: " + "\t" + cnp
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
            LOGGER.log(Level.WARNING, "LogInDAO:actualizare" + e.getMessage());
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
