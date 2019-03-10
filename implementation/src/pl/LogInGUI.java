package pl;



import bl.AccountBLL;
import bl.ClientBLL;
import bl.EmployeeBLL;
import bl.LogInBLL;
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogInGUI{

    private JButton okButton;
    private JPanel panelMain;
    private JTextField idTextField;
    private JPasswordField passwordField;
    private LogInBLL logInBLL;
    private EmployeeBLL employeeBLL;
    private ClientBLL clientBLL;
    private AccountBLL accountBLL;
    private AdminGUI adminGUI;
   // private LogInGUI logInGUI;
    private EmployeeGUI employeeGUI;


    //private String cnp;
    JFrame frame;

    public LogInGUI() {
        logInBLL = new LogInBLL();
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String id = idTextField.getText();
                String password =passwordField.getText();


                logInBLL.updateGUI();
                String [][] matrix = logInBLL.getMatrice();
                int nrLines = logInBLL.getNrLinii();

                boolean existAcc = false;
                for (int i = 0; i < nrLines; i++ ){
                    if(matrix[i][0].equals(id))
                    {
                        if( !matrix[i][1].equals(password)){
                            JOptionPane.showMessageDialog(null, "Password is wrong", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;

                        }
                        if(matrix[i][2].equals("admin"))
                        {
                            JOptionPane.showMessageDialog(null, "good luck");
                            adminGUI = new AdminGUI();
                            adminGUI.createAdmin();
                            existAcc = true;

                            frame.setVisible(false);
                            //panelMain.setVisible(false);
                            break;
                        }
                        else
                            if(matrix[i][2].equals("employee"))
                            {
                                 String cnp = matrix[i][3];
                                 System.out.println(cnp);
                                JOptionPane.showMessageDialog(null, "good luck");

                                employeeGUI = new EmployeeGUI();
                                employeeGUI.createEmployee(cnp);
                                existAcc = true;
                                frame.setVisible(false);
                                break;
                            }
                    }
                }
                    if(existAcc == false)
                    {
                        JOptionPane.showMessageDialog(null, "account does not exist", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }


            }

        });
    }
    public void createLogIn(){
        frame = new JFrame("Login");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(555,555);
        frame.pack();
        frame.setVisible(true);
    }

    //public String getCnp() {
    //    return cnp;
   // }


}



