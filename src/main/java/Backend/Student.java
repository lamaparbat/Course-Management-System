package Backend;

import Backend.Course_Backend;
import Backend.DB_Connection;
import Backend.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


class Student extends User{
    //local variable
    String modules[];
    
    //default constructor
    Student() throws ClassNotFoundException, SQLException{
        con = new DB_Connection().connect();
        st = con.createStatement();
        
    } 
    
    //search course
    ArrayList searchCourse(int course_id) throws SQLException{
        ArrayList<Course_Backend> course = new ArrayList();
        //database query
        query = "SELECT * FROM Course WHERE id='"+course_id+"'";
        rs = st.executeQuery(query);
        
        if(rs.next()){
            modules = rs.getString("modules").split(",");
            course.add(new Course_Backend(rs.getInt("cid"),rs.getString("cname"),rs.getInt("seats"),rs.getString("batch"),rs.getString("modules")));
            return course;
        }else{
            return null;
        }
    }
    
    //enroll course
    protected boolean enrollCourse(int course_id){
        
        return true;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new Student().searchCourse(1);
    }
   
}
