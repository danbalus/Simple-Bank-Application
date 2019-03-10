import tester.MainTest;
import pl.LogInGUI;

public class Main {
    public static void main(String[] args) {

        MainTest mainTest = new MainTest();
        mainTest.mainT();
        newStyleNimbus();
        LogInGUI logInGUI = new LogInGUI();
        logInGUI.createLogIn();
    }

    private static void newStyleNimbus(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception ex) {
            System.out.println("getStyle exception: \n"+ex.toString());
        }
    }

}
