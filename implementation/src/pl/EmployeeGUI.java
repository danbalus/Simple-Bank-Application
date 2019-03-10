package pl;

import bl.AccountBLL;
import bl.ClientBLL;
import bl.RaportBLL;
import model.Account;
import model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.NoSuchElementException;

public class EmployeeGUI extends JPanel {
    private JPanel panel1;
    private JTabbedPane jtabbedPaneEmploee;
    private JPanel ClientPanel;
    private JPanel AccountPanel;
    private JPanel TranferPanel;
    private JPanel BillsPanel;

    private JTable tableClient;

    private JButton okButtonAddClient;
    private JTextField textFieldIdClient;
    private JTextField textFieldNameAddClient;
    private JTextField textFieldAdressAddClient;
    private JTextField textFieldEmailAddClient;
    private JTextField textFieldAgeAddClient;
    private JTextField textFieldNrTelAddClient;
    private JButton okButtonUpdateClient;
    private JTextField textFieldIdUpdateClient;
    private JTextField textFieldNameUpdateClient;
    private JTextField textFieldAdressUpdateClient;
    private JTextField textFieldEmailUpdateClient;
    private JTextField textFieldAddUpdateClient;
    private JTextField textFieldNrTelUpdateClient;
    private JButton okButtonViewClient;
    private JTextField textFieldIdViewClient;
    private JLabel addClientLabel;
    private JLabel idLabelAddClient;
    private JLabel nrTelLabelAddClient;
    private JLabel ageLabelAddClient;
    private JLabel nameLabelAddClient;
    private JLabel emailLabelAddClient;
    private JLabel adressLabelAddClient;
    private JLabel nrTelLabelUpdataClient;
    private JLabel idLabelViewClient;
    private JLabel viewClientLabel;
    private JLabel updateClientLabel;
    private JLabel ageLabelUpdateClient;
    private JLabel emailLabelUpdateClient;
    private JLabel adressLabelUpdateClient;
    private JLabel idLabelUpdateClient;
    private JLabel nameLabelUpdateClient;
    private JLabel ibanLabel;
    private JLabel addAccountLabel;
    private JLabel ibanLabelAddAccount;
    private JLabel clientIdOwnerLabelAddAccount;
    private JLabel typeAccountLabelAddAccount;
    private JLabel balanceLabelAddAccount;
    private JButton okButtonAddAccount;
    private JTextField textFieldIbanAddAccount;
    private JTextField textFieldTypeAccAddAccount;
    private JTextField textFieldBalanceAddAccount;
    private JTextField textFieldclientIdOwnerAddAccount;
    private JTextField textFieldViewAccount;
    private JButton okButtonViewAccount;
    private JLabel ibanLabelUpdateAccount;
    private JLabel typeAccountLabelUpdateAccount;
    private JLabel balanceLabelUpdateAccount;
    private JLabel clientIdOwnerLabelUpdateAccount;
    private JButton okButtonUpdateAccount;
    private JTextField textFieldIbanUpdateAccount;
    private JTextField textFieldTypeAccUpdateAccount;
    private JTextField textFieldBalanceUpdateAccount;
    private JTextField textFieldclientIdOwnerUpdateAccount;

    private JTextField textFieldIbanFromTransfer;
    private JTextField textFieldIbanToTransfer;
    private JLabel ibanFromLabelTransfer;
    private JLabel ibanToLabelTransfer;
    private JLabel sumLabelTransfer;
    private JTextField textFieldIbanSumTransfer;

    private JTextField textFieldIbanClientBills;
    private JTextField textFieldSumBills;
    private JButton okButtonBills;
    private JTextField textFieldNrBills;
    private JLabel billsLabelBills;
    private JLabel ibanClientLabelBills;
    private JLabel sumLabelBills;
    private JLabel nrBillLabel;
    private JButton okButtonTransfer;
    private JLabel deleteAccountLabel;
    private JLabel ibanLabelDeleteAccount;
    private JTextField textFieldIbanDeleteAccount;
    private JButton okButtonDeleteAccount;
    private JButton showAllButtonClient;
    private JButton showAllButtonAccount;
    private JScrollPane jScrollPanelClient;
    private JScrollPane jScrollPanelAccount;
    private JTable tableAccount;
    private JTable tableTransfer;
    private JScrollPane jScrollPanelTransfer;
    private JScrollPane jScroolPanelBills;
    private JTable tableBills;
    private JButton seeAccButton;
    private DefaultTableModel dtm;
    private DefaultTableModel dtm2;
    private final  String[] columnNames = {"id", "name", "adress", "email", "age", "nrTel" };
    private final  String[] columnNamesAcc = {"iban", "type account", "amount Of Money", "dateCreation", "id client"};
    private final  String[] columnNamesBill = {"bill" };
    private String cnp;

    public EmployeeGUI() {
        okButtonAddClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = textFieldIdClient.getText();
                    String name = textFieldNameAddClient.getText();
                    String adress = textFieldAdressAddClient.getText();
                    String email = textFieldEmailAddClient.getText();
                    int age = Integer.parseInt(textFieldAgeAddClient.getText());
                    String nrTel = textFieldNrTelAddClient.getText();

                    ClientBLL clientBLL = new ClientBLL();
                   // if(clientBLL.findClientById(id) != null){
                     //   JOptionPane.showMessageDialog(null, "angajatul exista in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                   // }
                    Client client = new Client(id, name,adress,email,age,nrTel);

                    clientBLL.insert(client);

                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"added client"+ name+" in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, "Clientul este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Datele introduse nu respecta parametrii sau Amgajatul  este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        okButtonUpdateClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textFieldIdUpdateClient.getText();
                ClientBLL clientBLL = new ClientBLL();
                Client client = new Client();
                try {

                    client = clientBLL.findClientById(id);
                    // if (employee == null )
                    //  {
                    //     JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                    // }
                    //  else
                    //  {
                    //String id = textFieldIdAdd.getText();
                    String name = textFieldNameUpdateClient.getText();
                    String adress = textFieldAdressUpdateClient.getText();
                    String email = textFieldEmailUpdateClient.getText();
                    int age = Integer.parseInt(textFieldAddUpdateClient.getText());
                    String nrTel = textFieldNrTelUpdateClient.getText();
                    client = new Client(id, name,adress,email,age,nrTel);

                    clientBLL.update(client);

                    //}
                    //throw new idException("I am Exception Alpha!");
                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"edied client"+name +"("+id+")"+" in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Clientul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }
        });
        okButtonViewClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String id = textFieldIdViewClient.getText();

                    Client client = new Client();
                    ClientBLL clientBLL = new ClientBLL();
                    client = clientBLL.findClientById(id);

                    String[] rowsData = {client.getId(), client.getName(),client.getAdress(),client.getEmail(),
                            Integer.toString(client.getAge()),client.getNrTel()};

                    dtm =new DefaultTableModel(null, columnNames);
                    dtm.setRowCount(0);
                    dtm.addRow(rowsData);

                    tableClient = new JTable(dtm);
                    tableClient.setBackground(Color.lightGray);
                    tableClient.repaint();

                    jScrollPanelClient.setViewportView(tableClient);
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Clientul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }
        });
        okButtonAddAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String iBan = textFieldIbanAddAccount.getText();
                    int typeAccount = Integer.parseInt(textFieldTypeAccAddAccount.getText());
                    Float amountOfMoney = Float.parseFloat(textFieldBalanceAddAccount.getText());
                    //String dateCreation = textFieldDateCreationAddAccount.getText();
                    String id = textFieldclientIdOwnerAddAccount.getText();

                    AccountBLL accountBLL = new AccountBLL();
                    // if(clientBLL.findClientById(id) != null){
                    //   JOptionPane.showMessageDialog(null, "angajatul exista in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                    // }
                    String dateCreation = new Date().toString();
                    Account account = new Account(iBan, typeAccount,amountOfMoney,dateCreation,id);

                    accountBLL.insert(account);
                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"added edied account" + iBan +" in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, "Account este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Datele introduse nu respecta parametrii sau Account este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        okButtonUpdateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String iBan = textFieldIbanUpdateAccount.getText();
                AccountBLL accountBLL = new AccountBLL();
                Account account = new Account();
                try {

                    account = accountBLL.findAccountById(iBan);
                    // if (employee == null )
                    //  {
                    //     JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                    // }
                    //  else
                    //  {
                    //String id = textFieldIdAdd.getText();
                   // String iBan = textFieldIbanUpdateAccount.getText();
                    int typeAccount = Integer.parseInt(textFieldTypeAccUpdateAccount.getText());
                    Float amountOfMoney = Float.parseFloat(textFieldBalanceUpdateAccount.getText());
                   // String dateCreation = textFieldDateCreationUpdateAccount.getText();
                    String id = textFieldclientIdOwnerUpdateAccount.getText();
                    account = new Account(iBan, typeAccount,amountOfMoney,id);

                    accountBLL.update(account);

                    //}
                    //throw new idException("I am Exception Alpha!");
                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"updated account "+ iBan+" in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Account-ul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}


            }
        });
        okButtonDeleteAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String iBan = textFieldIbanDeleteAccount.getText();
                AccountBLL accountBLL = new AccountBLL();
                Account account = new Account();
                try {

                    account = accountBLL.findAccountById(iBan);
                    //   if (employee == null )
                    //  {
                    //    JOptionPane.showMessageDialog(null, "Amgajatul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //  }
                    //  else
                    //   {
                    accountBLL.delete(iBan);

                    //   }
                    //throw new idException("I am Exception Alpha!");
                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"deleted account" + iBan+ "in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Account-ul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "id-ul nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }
        });
        okButtonViewAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String iban = textFieldViewAccount.getText();

                    Account account = new Account();
                    AccountBLL accountBLL = new AccountBLL();
                    account = accountBLL.findAccountById(iban);

                    String[] rowsData = {account.getIban(), Integer.toString(account.getTypeAccount()), Float.toString(account.getAmountOfMoney()),account.getDateCreation(),account.getIdClient()};

                    dtm =new DefaultTableModel(null, columnNames);
                    dtm.setRowCount(0);
                    dtm.addRow(rowsData);

                    tableAccount = new JTable(dtm);
                    tableAccount.setBackground(Color.lightGray);
                    tableAccount.repaint();

                    jScrollPanelAccount.setViewportView(tableAccount);
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Account-ul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}
            }
        });
        okButtonTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ibanFrom = textFieldIbanFromTransfer.getText();
                    String ibanTo = textFieldIbanToTransfer.getText();
                    Float sum = Float.parseFloat(textFieldIbanSumTransfer.getText());
                    Account account = new Account();
                    AccountBLL accountBLL = new AccountBLL();
                    accountBLL.transfer(ibanFrom, ibanTo, sum);
                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"transfer sum " + sum+ "from " + ibanFrom+ "to "+ ibanTo+ " in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Account-ul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }
        });
        okButtonBills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nrBill = textFieldNrBills.getText();
                    String iban = textFieldIbanClientBills.getText();
                    Float sum = Float.parseFloat(textFieldSumBills.getText());
                    Account account = new Account();
                    AccountBLL accountBLL = new AccountBLL();
                    accountBLL.processUtilitiesBills(nrBill, iban, sum);
                    int nrLines = accountBLL.getNrLinii();
                    String[][] rowsData;
                    rowsData = accountBLL.getMatrice();

                    dtm =new DefaultTableModel(rowsData, columnNamesBill);
                    dtm.setRowCount(nrLines);
                    tableBills = new JTable(dtm);
                    tableBills.setBackground(Color.lightGray);
                    tableBills.repaint();
                    jScroolPanelBills.setViewportView(tableBills);
                    try{
                        RaportBLL raportBLL = new RaportBLL();
                        //System.out.println("cnp");

                        raportBLL.insert(cnp ,"paid bills sum " + sum+ "nrBill " + nrBill+ "from acc:  "+ iban+ " in BD",new Date());

                    } catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Eroare raport", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Account-ul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}

            }
        });

        showAllButtonClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.updateGUI();
                int nrLines = clientBLL.getNrLinii();
                String[][] rowsData;
                rowsData = clientBLL.getMatrice();
                dtm =new DefaultTableModel(rowsData, columnNames);
                dtm.setRowCount(nrLines);
                tableClient = new JTable(dtm);
                tableClient.setBackground(Color.lightGray);
                tableClient.repaint();
                jScrollPanelClient.setViewportView(tableClient);

            }
        });
        showAllButtonAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountBLL accountBLL = new AccountBLL();
                accountBLL.updateGUI();
                int nrLines = accountBLL.getNrLinii();
                String[][] rowsData;
                rowsData = accountBLL.getMatrice();
                dtm =new DefaultTableModel(rowsData, columnNamesAcc);
                dtm.setRowCount(nrLines);
                tableAccount = new JTable(dtm);
                tableAccount.setBackground(Color.lightGray);
                tableAccount.repaint();
                jScrollPanelAccount.setViewportView(tableAccount);

            }
        });
        seeAccButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //String iban = textFieldViewAccount.getText();
                    String ibanFrom = textFieldIbanFromTransfer.getText();
                    String ibanTo = textFieldIbanToTransfer.getText();
                    Float sum = Float.parseFloat(textFieldIbanSumTransfer.getText());
                    Account account = new Account();
                    Account account2 = new Account();
                    AccountBLL accountBLL = new AccountBLL();
                    account = accountBLL.findAccountById(ibanFrom);
                    account2 = accountBLL.findAccountById(ibanTo);

                    String[] rowsData = {account.getIban(), Integer.toString(account.getTypeAccount()), Float.toString(account.getAmountOfMoney()),account.getDateCreation(),account.getIdClient()};
                    String[] rowsData2 = {account2.getIban(), Integer.toString(account2.getTypeAccount()), Float.toString(account2.getAmountOfMoney()),account2.getDateCreation(),account2.getIdClient()};
                    dtm =new DefaultTableModel(null, columnNamesAcc);
                    dtm.setRowCount(0);
                    dtm.addRow(rowsData);
                    dtm.addRow(rowsData2);

                    tableTransfer = new JTable(dtm);
                    tableTransfer.setBackground(Color.lightGray);
                    tableTransfer.repaint();

                    jScrollPanelTransfer.setViewportView(tableTransfer);
                }
                catch (NoSuchElementException ex) {
                    JOptionPane.showMessageDialog(null, "Account-ul nu este in baza de date", "ERROR", JOptionPane.ERROR_MESSAGE);
                }catch (Exception ex) {//ilegal arg ex
                    JOptionPane.showMessageDialog(null, "Datele nu respecta formatul", "ERROR", JOptionPane.ERROR_MESSAGE);}
            }
        });
    }
    public void createEmployee(String cnp){
        JFrame frame = new JFrame("Employee");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(555,555);
        frame.pack();
        frame.setVisible(true);
        this.cnp = cnp;
    }

}


