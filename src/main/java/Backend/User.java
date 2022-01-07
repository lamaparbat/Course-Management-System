package Backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class User {
    //require attr
    protected int id;
    protected String name, address, email, query, cur_date,phn;
    
    //db config
    protected Connection con;
    protected Statement st;
    protected ResultSet rs;
    protected LocalDate today;


    //default Constructor
    public User() throws ClassNotFoundException, SQLException {
       //db config init
       con = new DB_Connection().connect();
       st = con.createStatement();
       //get current date
       today = LocalDate.now( ZoneId.of( "Asia/Katmandu")) ;
       cur_date = today.toString();
    }
    
    //parameterized constructor
    public User(int id, String name, String email, String phone, String date){
        this.id = id;
        this.name =  name;
        this.email =  email;
        this.phn = phone;
        this.cur_date = date;
    }

    //admin login
    public boolean login(String login_mode,String email_val, String password_val) throws ClassNotFoundException, SQLException {
        System.out.println("Database Connected successfully !!");
        
        //database query
        query = "SELECT * FROM "+login_mode+" WHERE email='" + email_val + "' AND password='" + password_val+"'";
        rs = st.executeQuery(query);

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
    
    //check if the user already exist or not
    private boolean isUserExist(String email, String mode) throws SQLException{
        query = "SELECT * FROM "+mode+" WHERE email='"+email+"'";
        rs = st.executeQuery(query);
        if(rs.next()){
            return true;
        }else{
            return false;
        }
    }
    
    //create new user
    public boolean createAccount(int mid, String username, String email, String password, String phone, String mode) throws SQLException{
        if(isUserExist(email, mode)){
            //popup error message
            JOptionPane.showMessageDialog(null, "User already exists !!",null,JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            //insert new user data to database
            if(mode == "Instructor"){
                query = "INSERT INTO "+mode+"(username, email, password, phone, date, module_id) VALUES('"+username+"','"+email+"','"+password+"','"+phone+"','"+cur_date+"','"+mid+"')";
            }else{
                query = "INSERT INTO "+mode+"(username, email, password, phone, date) VALUES('"+username+"','"+email+"','"+password+"','"+phone+"','"+cur_date+"')";
            }
            if(st.executeUpdate(query) > 0){
                //pop success message
                JOptionPane.showMessageDialog(null, "User created successfully !!",null,JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Failed to create a user !!","404 SERVER ERROR!!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
   
    
    //logout
    public boolean logout(){
        return true;
    }
}