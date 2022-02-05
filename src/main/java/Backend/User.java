package Backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class User {

    protected int id, years = 3;
    //require attr
    protected String name, address, email, query, cur_date, phn;
    ArrayList<Instructor> tutor_list;

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
        //get current date   con = new DB_Connection().connect();
        today = LocalDate.now(ZoneId.of("Asia/Katmandu"));
        cur_date = today.toString();
    }

    //parameterized constructor
    public User(String name, String email, String phone, String date) {
        this.name = name;
        this.email = email;
        this.phn = phone;
        this.cur_date = date;
    }

    //admin login
    public boolean login(String login_mode, String email_val, String password_val) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        System.out.println("Database Connected successfully !!");

        //check if user already log in or not
        if (new Credential().getEmail() == email_val && new Credential().getMode() == login_mode) {
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

            //update activity table
            String history = login_mode + ": " + email_val + " recently logged in.   Time:" + new Admin().cal.getTime();
            new Admin().addNewActivity(history);

            //return true on matching
            return true;
        } else {
            //database query
            query = "SELECT * FROM " + login_mode + " WHERE email='" + email_val + "' AND password='" + password_val + "'";
            rs = st.executeQuery(query);

            //check login status -> success || failed
            if (rs.next()) {
                // store userdata
                new Credential().storeData(email_val, login_mode);

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
              
                //update activity table
                String history = login_mode + ": " + email_val + " recently logged in.   Time:" + new Admin().cal.getTime();
                new Admin().addNewActivity(history);

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

    }

    //get current date
    public String getDate() {
        return this.cur_date;
    }

    //check if the user already exist or not
    private boolean isUserExist(String email, String mode) throws SQLException {
        query = "SELECT * FROM " + mode + " WHERE email='" + email + "'";
        rs = st.executeQuery(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //create new user
    public boolean createAccount(String username, String email, String password, String phone, String mode, String selected_course_name) throws SQLException, ClassNotFoundException, IOException {
        if (isUserExist(email, mode)) {
            //popup error message
            JOptionPane.showMessageDialog(null, "User already exists !!", null, JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            //insert new user data to database
            if (mode == "Student") {
                query = "INSERT INTO " + mode + "(username, email, password, phone, date, course) VALUES('" + username + "','" + email + "','" + password + "','" + phone + "','" + cur_date + "', '" + selected_course_name + "')";
            } else {
                query = "INSERT INTO " + mode + "(username, email, password, phone, date) VALUES('" + username + "','" + email + "','" + password + "','" + phone + "','" + cur_date + "')";
            }
            if (st.executeUpdate(query) > 0) {
                //update activity table
                String history = mode + ": " + username + " recently added.   Time:" + new Admin().cal.getTime();
                new Admin().addNewActivity(history);
                //pop success message
                JOptionPane.showMessageDialog(null, "User created successfully !!", null, JOptionPane.INFORMATION_MESSAGE);
                
                //save the data to user local file
                new Credential().storeData(email, mode);
                
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Failed to create a user !!", "404 SERVER ERROR!!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    //logout
    public boolean logout() {
        File file = new File("Credential.txt");
        if (file.delete()) {
            return true;
        } else {
            return false;
        }
    }

    //update profile
    public boolean updateProfile(String username, String email, String phone) throws FileNotFoundException, SQLException, IOException {
        //db query
        query = "UPDATE " + new Credential().getMode()+ " SET username='" + username + "', email='" + email + "', phone='" + phone + "' WHERE email='" + email + "'";
        if (st.executeUpdate(query) > 0) {
            new Credential().updateInfo(email);
            return true;
        }

        return false;
    }

    //get profile data
    public ArrayList<String> profileData(String user_type, String email) throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        //DB query
        query = "SELECT * FROM " + user_type + " WHERE email='" + email + "'";
        rs = st.executeQuery(query);
        while (rs.next()) {
            data.add(rs.getString("email"));
            data.add(rs.getString("username"));
            data.add(rs.getString("phone"));
            data.add(rs.getString("date"));
            data.add(rs.getString("password"));
        }

        return data;
    }

    //change password
    public boolean changePassword(String user_type, String email, String old_password, String new_password) throws SQLException {
        query = "UPDATE " + user_type + " SET password='" + new_password + "' WHERE email='" + email + "' AND password = '" + old_password + "'";
        if (st.executeUpdate(query) > 0) {
            System.out.println("Password successfully updated !!");
            return true;
        }
        return false;
    }
}
