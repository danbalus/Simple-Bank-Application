package pl;

import bl.EmployeeBLL;
import bl.RaportBLL;
import model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
public class AdminGUI extends JFrame{

    private JPanel panel1;
    private JTabbedPane tabbedPane;

    private JTable tableManagement;

    private JPanel addPanel;
    private JLabel adressLabel;
    private JLabel addEmployeeLabel;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel emailLabel;
    private JTextField textFieldIdAdd;
    private JTextField textFieldNameAdd;
    private JTextField textFieldAdressAdd;
    private JTextField textFieldeEmailAdd;
    private JPanel readPanel;
    private JTextField textFieldAgeAdd;
    private JTextField textFieldNrTelAdd;
    private JTextField textFieldSalaryAdd;
    private JTextField textFieldTilleAdd;
    private JLabel idLabelDelete;
    private JTextField textFieldIdDelete;
    private JButton okButton;
    private JButton okButtonDelete;
    private JButton okButtonUpdate;
    private JLabel emailLabelUpdate;
    private JLabel ageLabel;
    private JLabel nrTelLabel;
    private JLabel salaryLabel;
    private JLabel titleLabel;
    private JLabel updateEmployeeLabel;
    private JLabel idLabelUpdate;
    private JLabel nameLabelUpdate;
    private JLabel adressLabelUpdate;
    private JLabel ageLabelUpdate;
    private JLabel nrTelLabelUpdate;
    private JLabel salaryLabelUpdate;
    private JLabel titleLabelUpdate;
    private JTextField textFieldiIdUpdate;
    private JTextField textFieldNameUpdate;
    private JTextField textFieldAdressUpdate;
    private JTextField textFieldAgeUpdateve;
    private JTextField textFieldEmailUpdate;
    private JTextField textFieldNrTelUpdate;
    private JTextField textFieldSalaryUpdate;
    private JTextField textFieldTitleUpdate;
    private JLabel idLabelRead;
    private JTextField textFieldIdRead;
    private JButton okButtonRead;
    private JTextField textFieldIdRaport;
    private JTextField textFieldDateFromRaport;
    private JTextField textFieldDateToRaport;
    private JButton okButtonRaportEmployee;
    private JLabel dateToLabelEmployee;
    private JLabel dateFromLabelEmployee;
    private JLabel idLabelEmployee;
    private JLabel generateRaportsEmployeeLabel;
    private JPanel managementPanel;
    private JPanel deletePanel;
    private JPanel updatePanel;
    private JPanel raportPanel;
    private JPanel generatePanel;
    private JLabel deleteEmployeeLabel;
    private JLabel readEmployeeLabel;
    private JScrollPane jScrollPanelManagement;
    private JTable tableRaport;
    private JScrollPane jScrollPanelRaport;
    private JButton seeAllButton;
    private DefaultTableModel dtm;
    private DefaultTableModel dtm2;
    private final  String[] columnNames = {"id", "name", "adress", "email", "age", "nrTel", "salary"," title" };
    private final  String[] columnNames2 = {"id", "message", "date"};


    public AdminGUI() {
        dtm = new DefaultTableModel();
        dtm2 = new DefaultTableModel();
       // createTableEmployee();
       // createTableActivities();


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //idException iddException= new idException();
                    String id = textFieldIdAdd.getText();
                    String name = textFieldNameAdd.getText();
                    String adress = textFieldAdressAdd.getText();
                    String email = textFieldeEmailAdd.getText();
                    int age = Integer.parseInt(textFieldAgeAdd.getText());
                    String nrTel = textFieldNrTelAdd.getText();
                    Float salary = Float.parseFloat(textFieldSalaryAdd.getText());
                    String title = textFieldTilleAdd.getText();

                    EmployeeBLL employeeBLL = new EmployeeBLL();
                     //if (employeeBLL.findEmployeeById(id) != null) {
                    //     JOptionPane.showMessageDialog(null, "angajatul exista in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //     return;
                    // }
                    Employee employee = new Employee(id, name, adress, email, age, nrTel, salary, title);
                    employeeBLL.insert(employee);

                }
                catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, "Amgajatul este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                 catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Datele introduse nu respecta parametrii sau Amgajatul  este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        okButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textFieldIdDelete.getText();
                EmployeeBLL employeeBLL = new EmployeeBLL();
                Employee employee = new Employee();
                try {

                    employee = employeeBLL.findEmployeeById(id);
                 //   if (employee == null )
                  //  {
                    //    JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                  //  }
                  //  else
                 //   {
                        employeeBLL.delete(id);

                 //   }
                    //throw new idException("I am Exception Alpha!");

                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "id-ul nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }

        });
        okButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textFieldiIdUpdate.getText();
                EmployeeBLL employeeBLL = new EmployeeBLL();
                Employee employee = new Employee();
                try {

                    employee = employeeBLL.findEmployeeById(id);
                   // if (employee == null )
                  //  {
                   //     JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                   // }
                  //  else
                  //  {
                        //String id = textFieldIdAdd.getText();
                        String name = textFieldNameUpdate.getText();
                        String adress = textFieldAdressUpdate.getText();
                        String email = textFieldEmailUpdate.getText();
                        int age = Integer.parseInt(textFieldAgeUpdateve.getText());
                        String nrTel = textFieldNrTelUpdate.getText();
                        Float salary = Float.parseFloat(textFieldSalaryUpdate.getText());
                        String title = textFieldTitleUpdate.getText();
                        employee = new Employee(id, name,adress,email,age,nrTel,salary,title);

                        employeeBLL.update(employee);

                    //}
                    //throw new idException("I am Exception Alpha!");
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}
            }
        });
        okButtonRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                String id = textFieldIdRead.getText();

                Employee employee = new Employee();
                EmployeeBLL employeeBLL = new EmployeeBLL();
                employee = employeeBLL.findEmployeeById(id);

                String[] rowsData = {employee.getId(), employee.getName(),employee.getAdress(),employee.getEmail(),
                        Integer.toString(employee.getAge()),employee.getNrTel(), Float.toString(employee.getSalary()),employee.getTitle()};

                dtm =new DefaultTableModel(null, columnNames);
                dtm.setRowCount(0);
                dtm.addRow(rowsData);

                tableManagement = new JTable(dtm);
                tableManagement.setBackground(Color.lightGray);
                tableManagement.repaint();

                jScrollPanelManagement.setViewportView(tableManagement);
                }
                    catch (NoSuchElementException ex) {
                        JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                        JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}
            }
        });
        okButtonRaportEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String id = textFieldIdRaport.getText();
                String dateFrom = textFieldDateFromRaport.getText();
                String dateTo= textFieldDateToRaport.getText();

                RaportBLL raportBLL = new RaportBLL();

                raportBLL.updateGUI(id, dateFrom, dateTo);
                String [][] rowsData = raportBLL.getMatrice();
                int nrLines = raportBLL.getNrLinii();
                dtm =new DefaultTableModel(rowsData, columnNames2);
                dtm.setRowCount(nrLines);
                tableRaport = new JTable(dtm);
                tableRaport.setBackground(Color.lightGray);
                tableRaport.repaint();
                jScrollPanelRaport.setViewportView(tableRaport);
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}


            }
        });


        seeAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EmployeeBLL employeeBLL = new EmployeeBLL();
                employeeBLL.updateGUI();
                int nrLines = employeeBLL.getNrLinii();
                String[][] rowsData;
                rowsData = employeeBLL.getMatrice();
                dtm =new DefaultTableModel(rowsData, columnNames);
                dtm.setRowCount(nrLines);
                tableManagement = new JTable(dtm);
                tableManagement.setBackground(Color.lightGray);
                tableManagement.repaint();
                jScrollPanelManagement.setViewportView(tableManagement);

            }
        });
    }
    public void createAdmin(){
        JFrame frame = new JFrame("Admin");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(555,555);
        frame.pack();
        frame.setVisible(true);
    }




}
