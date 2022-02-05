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
    //major attr
    private int sid;
    private String name, email, date,phn, course_name;
    private ArrayList<Student> Student_Details;
    private ArrayList<String> student_name;
    
    //major report attr
    private float percentage;
    private String grade_type, module_name;
    private float total_percentage = 0;
    
    
    //default constructor
    public Student() throws ClassNotFoundException, SQLException{
        
    } 
    
    //parameterized constructor for student instance
    public Student(int id, String name, String email, String phone, String date, String course_name){
        this.sid = id;
        this.name = name;
        this.email = email;
        this.date = date;
        this.phn = phone;
        this.course_name = course_name;
    }
    
    //parameterized constructor for report instance
    public Student(int id, String student_name,float percentage, String grade_type, String module_name){
        this.name = student_name;
        this.percentage  = percentage;
        this.grade_type = grade_type;
        this.module_name = module_name;
    }
    
     //reutrn tutor id
    public int getStudentId(Student obj) {
        id = obj.sid;
        return obj.sid;
    }

    //reutrn email
    public String getEmail(Student obj) {
        return obj.email;
    }

    //return tutor name
    public String getStudentName(Student obj) {
        return obj.name;
    }

    //return phone no
    public String getPhone(Student obj) {
        return obj.phn;
    }

    //return date
    public String getDate(Student obj) {
        return obj.date;
    }
    
    public String getCourseName(Student obj){
        return obj.course_name;
    }
    
    public String getModuleName(Student obj){
        return obj.module_name;
    }
    
    public float getPercentage(Student obj){
        return obj.percentage;
    }
    
    public String getGrade(Student obj){
        return obj.grade_type;
    }
    
    //search course
    public ArrayList searchStudent(String keyword) throws SQLException{
        ArrayList<Student> student = new ArrayList();
        //database query
        query = "SELECT * FROM Student WHERE username LIKE '"+keyword+"%'";
        rs = st.executeQuery(query);
        
        while(rs.next()){
            student.add(new Student(rs.getInt("sid"),rs.getString("username"),rs.getString("email"),rs.getString("phone"),rs.getString("date"),rs.getString("course")));
        }
        return student;
    }
    
        //search course by id
    public ArrayList searchStudent(int id) throws SQLException{
        ArrayList<Student> student = new ArrayList();
        //database query
        query = "SELECT * FROM Student WHERE sid  ='"+id+"'";
        rs = st.executeQuery(query);
        
        while(rs.next()){
            student.add(new Student(rs.getInt("sid"),rs.getString("username"),rs.getString("email"),rs.getString("phone"),rs.getString("date"),rs.getString("course")));
        }
        return student;
    }
    
    //enroll course
    protected boolean enrollCourse(int course_id){
        return true;
    }
    
    //return total courses
    public int getTotalStudentsCount() throws SQLException{
        getStudentDetails();
        return Student_Details.size();
    }
    
    //return all student name in a list
    public ArrayList<String> getStudentNameList() throws SQLException{
        return student_name;
    }
    
    //return everything about student in a list
    public ArrayList<Student> getStudentDetails() throws SQLException{
        Student_Details = new ArrayList<>();
        student_name = new ArrayList<>();
        
        //DB query
        query = "SELECT * FROM Student";
        rs = st.executeQuery(query);
        //iterating the rows from table
        while(rs.next()){
           Student_Details.add(new Student(rs.getInt("sid"),rs.getString("username"),rs.getString("email"),rs.getString("phone"),rs.getString("date"),rs.getString("course")));
           student_name.add(rs.getString("username"));
        }
        
        return Student_Details;
    }
    
    //return progress report of a student
    public ArrayList<Student> getProgressReport(int sid) throws SQLException{
         ArrayList<Student> report = new  ArrayList<>();
         
         //db query
         query = "SELECT * FROM Result WHERE sid='"+sid+"'";
         rs = st.executeQuery(query);
         while(rs.next()){
             report.add(new Student(rs.getInt("rid"),rs.getString("name"),rs.getFloat("percentage"),rs.getString("grade"),rs.getString("module_name")));
             total_percentage += rs.getFloat("percentage");
         }
         
         System.out.println("Total Percentage = "+total_percentage);
         
         return report;
    }
    
}
