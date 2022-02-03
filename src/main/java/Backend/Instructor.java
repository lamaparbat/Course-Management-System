package Backend;

import java.sql.SQLException;
import java.util.ArrayList;

public final class Instructor extends User {

    //tutor name list
    ArrayList<Instructor> tutor_list = new ArrayList<>();
    ArrayList<String> tutor_name_list = new ArrayList<>();

    //default constructor
    public Instructor() throws SQLException, ClassNotFoundException {
    }

    //parameterized constructor
    public Instructor(int id, String name, String email, String phone, String date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phn = phone;
        this.cur_date = date;
    }

    //reutrn tutor id
    public int getInstructorId(Instructor obj) {
        id = obj.id;
        return obj.id;
    }

    //reutrn email
    public String getEmail(Instructor obj) {
        return obj.email;
    }

    //return tutor name
    public String getInstructorName(Instructor obj) {
        return obj.name;
    }

    //return phone no
    public String getPhone(Instructor obj) {
        return obj.phn;
    }

    //return date
    public String getDate(Instructor obj) {
        return obj.cur_date;
    }

    //view modules that you are on
    protected ArrayList viewModules() {
        ArrayList<Module> details = new ArrayList();

        //database query
        return details;
    }

    //return total tutors count
    public int getTotalTutorsCount() throws SQLException, ClassNotFoundException {
        setTutorNameList();
        return tutor_name_list.size();
    }

    //set the setTutorNameList
    protected void setTutorNameList() throws SQLException, ClassNotFoundException {
        //select query
        query = "SELECT * FROM Instructor";

        //execute the query and store return objects into rs
        rs = st.executeQuery(query);

        //iterate the each object value
        while (rs.next()) {
            tutor_list.add(new Instructor(rs.getInt("iid"), rs.getString("username"), rs.getString("email"), rs.getString("phone"), rs.getString("date")));
            tutor_name_list.add(rs.getString("username"));
        }

    }

    //is tutor exist ?
    public boolean isTutorExist(String tutor) throws SQLException, ClassNotFoundException {
        setTutorNameList();
        return tutor_name_list.contains(tutor);
    }

    //get all tutor name in list
    private ArrayList<String> getTutorNameList() throws SQLException, ClassNotFoundException {
        setTutorNameList();
        return tutor_name_list;
    }

    //get all tutors list object
    public ArrayList<Instructor> getTutorsList() throws ClassNotFoundException, SQLException {
        setTutorNameList();
        return tutor_list;
    }

    //edit tutors
    public boolean editTutor(int id, String name, String email, String phone) throws SQLException, ClassNotFoundException {
        query = "UPDATE Instructor SET username='" + name + "', email='" + email + "', phone='" + phone + "' WHERE iid='" + id + "'";
        if (st.executeUpdate(query) > 0) {
            //update activity table
            String history = "Tutor: " + name + " recently Updated.   Time:" + new Admin().cal.getTime();
            new Admin().addNewActivity(history);
            System.out.println("Tutor updated successfully!!");
            return true;
        } else {
            System.out.println("Tutor failed to update!!");
            return false;
        }
    }

    //search tutors
    public ArrayList<Instructor> searchTutors(String keyword) throws SQLException {
        ArrayList<Instructor> result = new ArrayList<>();
        query = "SELECT * FROM Instructor WHERE username LIKE '" + keyword + "%'";
        rs = st.executeQuery(query);
        while (rs.next()) {
            result.add(new Instructor(rs.getInt("iid"), rs.getString("username"), rs.getString("email"), rs.getString("date"), rs.getString("date")));
        }

        return result;
    }
    
        //upload progress report
    public boolean setProgressReport(int sid, String sname, String mname, float percentage, String grade) throws SQLException{
        System.out.println(sid+" "+  sname+" "+  mname+" "+  percentage+" "+ grade );
        //db query
        query = "INSERT INTO Result(name, module_name, percentage, grade, sid) VALUES('"+sname+"', '"+mname+"', '"+percentage+"', '"+grade+"', '"+sid+"')";
        return st.executeUpdate(query) > 0;
    }
}
