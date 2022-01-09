package Backend;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Admin extends User {

    //constructor
    public Admin() throws ClassNotFoundException, SQLException {
        //connection
        con = new DB_Connection().connect();

        //statement config
        st = con.createStatement();

        //get the current date
        today = LocalDate.now(ZoneId.of("Asia/Kathmandu"));
        cur_date = today.toString();

    }

    //add course
    public boolean addCourse(String cname, int seats, String batch, ArrayList<Module> year1, ArrayList<Module> year2, ArrayList<Module> year3) throws SQLException, ClassNotFoundException {
        //insertion into course table
        query = "INSERT INTO Course(cname, seats, batch, total_years) VALUES('" + cname + "', '" + seats + "','" + batch + "', '" + years + "')";
        if (st.executeUpdate(query) > 0) {
            //fetching recently created course id
            query = "SELECT * FROM Course WHERE cname= '" + cname + "'";
            rs = st.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt("cid");
            }

            //insertion into module table in yearly wise module
            try {
                //checking if the input tutors are valid or not
                for (Module i : year1) {
                    String arr[] = i.tutors.split(",");
                    for (String j : arr) {
                        if (new Instructor().isTutorExist(j) == false) {
                            JOptionPane.showMessageDialog(null, j + " tutor not found!!", "Please enter registered teacher", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                    //clearing arr
                    Arrays.fill(arr, null);
                }

                for (Module i : year2) {
                    String arr[] = i.tutors.split(",");
                    for (String j : arr) {
                        if (new Instructor().isTutorExist(j) == false) {
                            JOptionPane.showMessageDialog(null, j + " tutor not found!!", "Please enter registered teacher", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                    //clearing arr
                    Arrays.fill(arr, null);
                }

                for (Module i : year3) {
                    String arr[] = i.tutors.split(",");
                    for (String j : arr) {
                        if (new Instructor().isTutorExist(j) == false) {
                            JOptionPane.showMessageDialog(null, j + " tutor not found!!", "Please enter registered teacher", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    }
                    //clearing arr
                    Arrays.fill(arr, null);
                }

                // then insert the modules data
                for (Module i : year1) {
                    query = "INSERT INTO module(name, instructor, date, course_year, cid) VALUES('" + i.name + "','" + i.tutors + "', '" + cur_date + "','" + i.years + "', '" + id + "')";
                    st.executeUpdate(query);
                }

                for (Module j : year2) {
                    System.out.println(j.name);
                    query = "INSERT INTO module(name, instructor, date, course_year, cid) VALUES('" + j.name + "','" + j.tutors + "', '" + cur_date + "','" + j.years + "', '" + id + "')";
                    st.executeUpdate(query);
                }

                for (Module k : year3) {
                    System.out.println(k.name);
                    query = "INSERT INTO module(name, instructor, date, course_year, cid) VALUES('" + k.name + "','" + k.tutors + "', '" + cur_date + "','" + k.years + "', '" + id + "')";
                    st.executeUpdate(query);
                }

            } catch (SQLException err) {
                System.out.println("module insertion failed !!" + err);
                return false;
            }
        }
        return true;
    }

    //delete course
    protected boolean deleteCourse(int courseId) {
        return true;
    }

    //view course
    public ArrayList viewCourse(ArrayList<Course_Backend> courses) {
        return courses;
    }

    //update course
    public boolean updateCourse(int course_id, String cname, String batch, int seats) throws SQLException {
        query = "UPDATE Course SET cname='" + cname + "', batch='" + batch + "' , seats='" + seats + "' WHERE cid='" + course_id + "'";
        if (st.executeUpdate(query) > 0) {
            System.out.println("COurse Updated succesfully !!");
            return true;
        } else {
            System.out.println("Failed to update !!");
            return false;
        }
    }

}
