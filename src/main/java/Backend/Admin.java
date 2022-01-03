package Backend;


import Backend.Course;
import Backend.User;
import java.awt.List;
import java.util.ArrayList;


class Admin extends User{
    //add course
    protected boolean addCourse(String cname, String[] instructor, String[] modules, int seats, String batch){
        return true;
    }
    
    //delete course
    protected boolean deleteCourse(int courseId){
        return true;
    }
    
    //view course
    protected ArrayList viewCourse(ArrayList <Course> courses){
        return courses;
    }
    
    //update course
    protected boolean updateCourse(int course_id, String cname, String[] instructor, String[] modules, int seats, int batch){
        
        return false;
    }
    
}
