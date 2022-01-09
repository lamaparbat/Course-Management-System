package Backend;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Admin extends User implements Activity {

    //required attr
    ArrayList<String> activityList;
    //date objects
    DateFormat dateFormat;
    public Calendar cal;

    //constructor
    public Admin() throws ClassNotFoundException, SQLException {
        //connection
        con = new DB_Connection().connect();

        //statement config
        st = con.createStatement();

        //get the current date
        today = LocalDate.now(ZoneId.of("Asia/Kathmandu"));
        cur_date = today.toString();

        //both date and time initialization
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        cal = Calendar.getInstance();
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
                //update activity table
                String history = "  Course: " + cname + " recently Added.   Time:" + cal.getTime();
                addNewActivity(history);

            } catch (SQLException err) {
                System.out.println("module insertion failed !!" + err);
                return false;
            }
        }
        return true;
    }

    //delete course
    public boolean deleteCourse(int courseId) throws SQLException {
        query = "DELETE FROM Course WHERE cid='" + courseId + "'";
        if (st.executeUpdate(query) > 0) {
            query = "DELETE FROM module WHERE cid='" + courseId + "'";
            if (st.executeUpdate(query) > 0) {
                //update activity table
                String history = "Course ID: " + courseId + " recently Deleted.   Time:" + cal.getTime();
                addNewActivity(history);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    //view course
    public ArrayList viewCourse(ArrayList<Course_Backend> courses) {
        return courses;
    }

    //update course
    public boolean updateCourse(int course_id, String cname, String batch, int seats) throws SQLException, ClassNotFoundException {

        query = "UPDATE Course SET cname='" + cname + "', batch='" + batch + "' , seats='" + seats + "' WHERE cid='" + course_id + "'";
        if (st.executeUpdate(query) > 0) {
            //update activity table
            String history = "ID: " + course_id + "  Course: " + cname + " recently updated.  Update on:" + cal.getTime();
            addNewActivity(history);
            System.out.println("COurse Updated succesfully !!");
            return true;
        } else {
            System.out.println("Failed to update !!");
            return false;
        }
    }

    //add tutors
    public boolean addTutor(int uid, String tutor1, String tutor2, String tutor3) throws SQLException, ClassNotFoundException {
        //update activity table
        String history = "  Course: " + tutor1 + ", " + tutor2 + ", " + tutor3 + " recently Added.   Time:" + cal.getTime();
        addNewActivity(history);

        //bind the three tutor string into on string format
        StringBuffer sb = new StringBuffer();
        sb.append(tutor1 + ",");
        sb.append(tutor2 + ",");
        sb.append(tutor3);
        String tutors = sb.toString();

        query = "UPDATE module SET instructor='" + tutors + "' WHERE mid='" + uid + "'";

        //check if insert success or not
        if (st.executeUpdate(query) > 0) {
            System.out.println("Course added successfully!");

            return true;
        } else {
            System.out.println("Course failed to add!");
            return false;
        }
    }

    //delete tutor
    public boolean deleteTutor(int iid) throws SQLException {
        //update activity table
        String history = "Tutor ID: " + iid + " recently Deleted.   Time:" + cal.getTime();
        addNewActivity(history);

        query = "DELETE FROM Instructor WHERE iid='" + iid + "'";
        if (st.executeUpdate(query) > 0) {
            return true;
        } else {
            return false;
        }
    }

    //insert recent activity
    @Override
    public void addNewActivity(String name) {
        //DB query
        query = "INSERT INTO Activity(name) VALUES('" + name + "')";
        try {
            if (st.executeUpdate(query) > 0) {
                System.out.println("Activity table updated !!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //get activity history
    @Override
    public ArrayList<String> getActivityList() {
        //initialize arraylist
        activityList = new ArrayList<>();

        //DB query
        query = "SELECT * FROM Activity";
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                activityList.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activityList;
    }

}
