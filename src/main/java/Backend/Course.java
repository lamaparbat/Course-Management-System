package Backend;


import java.util.ArrayList;


public class Course {
    String cname,batch;
    String[] modules, instructor;
    int seats;
    
    Course(String cname, int seats, String batch, String[] modules){
        this.cname = cname;
        this.seats = seats;
        this.batch = batch;
        this.modules = modules;
    }
    
    //get all courses
    protected ArrayList getAllCourseName(){
        ArrayList<String> course_name = new ArrayList();
        
        //database query
        
        
        return course_name;
    }
    
    //rename the coursename
    protected boolean setCoursename(int course_id, String cname){
        //database query
        
        
        return true;
    }
}
