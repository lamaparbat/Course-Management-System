package Backend;

import Backend.Course_Backend;
import Backend.DB_Connection;
import Backend.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public final class Student extends User{
    //local variable
    String modules[];
    ArrayList<Student> Student_Details;
    ArrayList<String> student_name;
    
    //default constructor
    public Student() throws ClassNotFoundException, SQLException{
        con = new DB_Connection().connect();
        st = con.createStatement();
        getStudentDetails();
    } 
    
    //parameterized constructor
    Student(int id, String name, String email, String date, String course_name){
        
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
    
    //return total courses
    public int getTotalStudentsCount(){
        return Student_Details.size();
    }
    
    public ArrayList<Student> getStudentDetails() throws SQLException{
        Student_Details = new ArrayList<>();
        
        //DB query
        query = "SELECT * FROM Student";
        rs = st.executeQuery(query);
        //iterating the rows from table
        while(rs.next()){
            Student_Details.add(new Student(rs.getInt("sid"),rs.getString("username"),rs.getString("email"),rs.getString("date"),rs.getString("course")));
        }
        
        return Student_Details;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new Student().searchCourse(1);
    }
   
}
