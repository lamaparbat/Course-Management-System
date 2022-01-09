package Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course_Backend {

    //store the entire course details
    private ArrayList<Course_Backend> course_details;
    private ArrayList<String> course_name;

    int cid, seats;
    protected String cname, batch, modules;
    //DB config
    Connection con;
    String query;
    Statement st;
    ResultSet rs;

    //default constructor
    public Course_Backend() throws ClassNotFoundException, SQLException {
        getAllCourseDetails();
    }

    //parameterized constructor
    public Course_Backend(int cid, String cname, int seats, String batch, String modules) {
        this.cid = cid;
        this.cname = cname;
        this.seats = seats;
        this.batch = batch;
        this.modules = modules;
    }

    //reutrn course id
    public int getCourseId(Course_Backend obj) {
        this.cid = obj.cid;
        return cid;
    }
    
    //return total courses
    public int getTotalCoursesCount(){
        return course_details.size();
    }

    // return course name list
    public ArrayList<String> courseNameList() throws SQLException {
        course_name = new ArrayList();
        for (Course_Backend obj : course_details) {
            course_name.add(obj.cname);
        }
        return course_name;
    }

    //reutrn no of ceats
    public int getSeats(Course_Backend obj) {
        this.seats = obj.seats;
        return seats;
    }

    //return course name
    public String getCourseName(Course_Backend obj) {
        this.cname = obj.cname;
        return cname;
    }

    //return batch
    public String getBatch(Course_Backend obj) {
        this.batch = obj.batch;
        return batch;
    }

    //return modules list
    public String getModules(Course_Backend obj) {
        this.modules = obj.modules;
        return modules;
    }

    //get all courses
    public ArrayList getAllCourseDetails() throws SQLException, ClassNotFoundException {
        course_details = new ArrayList();
        //connection
        con = new DB_Connection().connect();

        //create CreateStatement instance
        st = con.createStatement();
        //select query
        query = "SELECT * FROM Course";

        //execute query and store it into rs var
        rs = st.executeQuery(query);

        //iterate the object
        while (rs.next()) {
            course_details.add(new Course_Backend(rs.getInt("cid"), rs.getString("cname"), rs.getInt("seats"), rs.getString("batch"), rs.getString("total_years")));
        }

        return course_details;
    }

    //rename the coursename
    protected boolean setCoursename(int course_id, String cname) {
        //database query

        return true;
    }
}
