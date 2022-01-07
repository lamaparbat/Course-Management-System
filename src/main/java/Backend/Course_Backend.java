package Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Course_Backend{
    int cid, seats;
    protected String cname,batch, modules;
    //DB config
    Connection con;
    String query;
    Statement st;
    ResultSet rs;
    
    Course_Backend(int cid, String cname, int seats, String batch, String modules){
        this.cid = cid;
        this.cname = cname;
        this.seats = seats;
        this.batch = batch;
        this.modules = modules;
    }
    
    public Course_Backend(){
        
    }
    
    //reutrn course id
    public int getCourseId(Course_Backend obj){
        this.cid = obj.cid;
        return cid;
    }
    
     //reutrn no of ceats
    public int getSeats(Course_Backend obj){
        this.seats = obj.seats;
        return seats;
    }
    
    //return course name
    public String getCourseName(Course_Backend obj){
        this.cname = obj.cname;
        return cname;
    }
    
    //return batch
    public String getBatch(Course_Backend obj){
        this.batch = obj.batch;
        return batch;
    }
    
    //return modules list
    public String getModules(Course_Backend obj){
        this.modules = obj.modules;
        return modules;
    }
    
    //get all courses
    public ArrayList getAllCourseDetails() throws SQLException, ClassNotFoundException{
        ArrayList<Course_Backend> course_name = new ArrayList();
        
        //connection
        con =  new DB_Connection().connect();
        
        //select query
        query = "SELECT * FROM Course";
        
        //create CreateStatement instance
        st = con.createStatement();
        
        //execute query and store it into rs var
        rs = st.executeQuery(query);
        
        //iterate the object
        while(rs.next()){
            course_name.add(new Course_Backend(rs.getInt("cid"), rs.getString("cname"),rs.getInt("seats"),rs.getString("batch"),rs.getString("modules")));
        }

        return course_name;
    }
    
    //rename the coursename
    protected boolean setCoursename(int course_id, String cname){
        //database query
        
        return true;
    }
}
