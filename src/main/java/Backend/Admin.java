package Backend;

import Backend.Course_Backend;
import Backend.User;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

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
    public boolean addCourse(String cname, String[] modules, int seats, String batch) throws SQLException, ClassNotFoundException {
        int cid;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                sb.append(modules[i]);
            } else {
                sb.append(modules[i] + ",");
            }
        }
        //convert string buffer into string
        String module_list = sb.toString();

        //insert data into
        query = "INSERT INTO Course(cname, seats, batch, modules) VALUES('" + cname + "', '" + seats + "', '" + batch + "', '" + module_list + "')";

        if (st.executeUpdate(query) > 0) {
            // get the course id and insert the modules in modules table
            query = "SELECT * FROM Course WHERE cname='" + cname + "'";
            rs = st.executeQuery(query);

            while (rs.next()) {
                cid = rs.getInt("cid");

                //insert 
                for (String i : modules) {
                    query = "INSERT INTO module(name,instructor,date,cid) VALUES('" + i + "','NULL', '" + cur_date + "', '" + cid + "')";
                    if (st.executeUpdate(query) > 0) {
                        System.out.println("Each module is separately stored in database successfully !!");
                    } else {
                        System.out.println("failed to insert the modules separatley!!");
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //delete course
    protected boolean deleteCourse(int courseId) {
        return true;
    }

    //view course
    protected ArrayList viewCourse(ArrayList<Course_Backend> courses) {
        return courses;
    }

    //update course
    protected boolean updateCourse(int course_id, String cname, String[] instructor, String[] modules, int seats, int batch) {

        return false;
    }


}
