
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

class User {

    //major attr
    private int id, phn;
    private String name, address, email;

    //default Constructor
    User() {

    }

    //admin login
    protected boolean adminLogin(String login_mode,String email_val, String password_val) throws ClassNotFoundException, SQLException {
        Connection con = new DB_Connection().connect();

        System.out.println("Database Connected successfully !!");
        
        //database query
        Statement st = con.createStatement();
        String squery = "SELECT * FROM "+login_mode+" WHERE email='" + email_val + "' AND password='" + password_val+"'";
        ResultSet rs = st.executeQuery(squery);

        //check login status -> success || failed
        if (rs.next()) {
            //show error popup modal for 4 seconds using Timer class
            JOptionPane successModal = new JOptionPane();
            Timer t = new Timer(4000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    successModal.getRootFrame().dispose();
                }
            });
            t.start();
            Icon icon = new javax.swing.ImageIcon("/Users/parbatlama/Pictures/icons/logo.png");
            successModal.showMessageDialog(null, "Welcome to Course Management System", "Login Successfull !!", JOptionPane.INFORMATION_MESSAGE, icon);
            t.stop();
            
            //open home page
            new Home().setVisible(true);

            //return true on matching
            return true;
        } else {
            //show error popup modal for 4 seconds using Timer 
            JOptionPane errorModal = new JOptionPane();
            Timer t = new Timer(4000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    errorModal.getRootFrame().dispose();
                }
            });
            t.start();
            errorModal.showMessageDialog(null, "Please enter correct email or password", "Failed to Login!!", JOptionPane.ERROR_MESSAGE);
            t.stop();
            
            //return if not matched
            return false;
        }

    }

    //driver method
    public static void main(String[] args) {

    }
}
