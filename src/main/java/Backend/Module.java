package Backend;

public class Module extends User{
    protected String tutors;
    
   //parameterized constructor
    public Module(String name, String tutors, String date, int course_years){
        this.name = name;
        this.tutors = tutors;
        this.cur_date = date;
        this.years = course_years;
    }
}
