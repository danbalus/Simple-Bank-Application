package dl.dao;

import dl.connection.ConnectionFactory;
import model.Employee;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO  {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private static final  String findStatementString   = "SELECT * FROM employee where id=?";
    private static final String insertStatementString  = "insert into employee(id,name,adress,email,age, nr_tel, salary, title)"+" VALUES (?,?,?,?,?,?,?,?)";
    private static final String updateStatementString  = "update employee"+" set name=?,adress=?,email=?,age=?, nr_tel=?, salary=?, title=? where id=?";
    private static final String deleteStatementString  = "delete from employee"+" where id=?";
    private static final String showAllStatementString = "select * from employee";

    private static  String [][] updateMatrice = new String[900][900];
    private static int nrLinii;
    //idException idExceptionn = new idException();

    public static Employee findById(String employeeId){
        Employee toReturn=null;
        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement findStatement=null;
        ResultSet rs=null;


        try {
            findStatement=dbConnection.prepareStatement(findStatementString);
            findStatement.setString(1,employeeId);
            rs=findStatement.executeQuery();
            rs.next();
            String name=rs.getString("name");
            String adress=rs.getString("adress");
            String email=rs.getString("email");
            int age=rs.getInt("age");
            String nrTel = rs.getString("nr_tel");
            Float salary = rs.getFloat("salary");
            String title = rs.getString("title");
            if(!name.equals("")){
                toReturn = new Employee(employeeId,name,adress,email,age,nrTel,salary,title);

            }

        }
        catch (SQLException e) {
            LOGGER.log(Level.WARNING, "EmployeeDAO:findById " + e.getMessage());

        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;

    }

    public static int insert(Employee employee){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        int insertedId=-1;


        try {
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setString(2,employee.getName());
            insertStatement.setString(3,employee.getAdress());
            insertStatement.setString(4,employee.getEmail());
            insertStatement.setInt(5,employee.getAge());
            insertStatement.setString(1,employee.getId());
            insertStatement.setString(6,employee.getNrTel());
            insertStatement.setFloat(7,employee.getSalary());
            insertStatement.setString(8,employee.getTitle());



            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }


        } catch (SQLException e) {
            throw new IllegalStateException();
          //  LOGGER.log(Level.WARNING, "EmployeeDAO:insert " + e.getMessage());



        }finally {

            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);

        }

        return insertedId;
    }

    public static void update(Employee employee){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement updateStatement=null;
        // int insertedId=-1;


        try {
            updateStatement=dbConnection.prepareStatement(updateStatementString);

            updateStatement.setString(1,employee.getName());
            updateStatement.setString(2,employee.getAdress());
            updateStatement.setString(3,employee.getEmail());
            updateStatement.setInt(4,employee.getAge());
            updateStatement.setString(5,employee.getNrTel());
            updateStatement.setFloat(6,employee.getSalary());
            updateStatement.setString(7,employee.getTitle());
            updateStatement.setString(8,employee.getId());

            updateStatement.executeUpdate();



        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "EmployeeDAO:update " + e.getMessage());
        }finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }


    }

    public static void delete(String id){

        Connection dbConnection= ConnectionFactory.getConnection();
        PreparedStatement deleteStatement=null;
        // int insertedId=-1;


        try {
            Employee employee = new Employee();
            employee = findById(id);//pt excepie
            deleteStatement=dbConnection.prepareStatement(deleteStatementString);

            deleteStatement.setString(1,id);

            deleteStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "EmployeeDAO:delete " + e.getMessage());
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
            System.out.println("Employee===================================================================================================================================================================================================");
            while (rs.next() ) {

                String id =rs.getString("id");
                updateMatrice[i][0] = id;

                String name=rs.getString("name");
                updateMatrice[i][1] =  name;

                String adress=rs.getString("adress");
                updateMatrice[i][2] = adress;

                String email=rs.getString("email");
                updateMatrice[i][3] = email;

                int age=rs.getInt("age");
                updateMatrice[i][4] =  Integer.toString(age);

                String nrTel = rs.getString("nr_tel");
                updateMatrice[i][5] =  nrTel;

                Float salary = rs.getFloat("salary");
                updateMatrice[i][6] = "   salary: " + Float.toString(salary);

                String title = rs.getString("title");
                updateMatrice[i][7] =  title;

                System.out.println("|name|: " + name +
                        "    |adress|: "  + "\t" + adress +
                        "    |email|: " + "\t" + email +
                        "    |age|: " + "\t" + age +
                        "    |id|: " +  "\t"+  id +
                        "    |nrTel|: " + "\t" + nrTel +
                        "    |salary|: " + "\t" + salary +
                        "    |title|: " + "\t" + title

                );
                i++;
            }
            nrLinii = i;
            /*System.out.println();
            for (int x = 0; x < i; x++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(updateMatrice[x][j] + " ");
                }
                System.out.println();
            }
            System.out.println();*/
            System.out.println("===================================================================================================================================================================================================\n\n");


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "EmployeeDAO:actualizare " + e.getMessage());
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
