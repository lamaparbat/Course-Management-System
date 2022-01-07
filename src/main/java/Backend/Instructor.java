package Backend;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Instructor extends User {

    //default constructor
    public Instructor() {
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
    public int getInstructorId(User obj) {
        return obj.id;
    }

    //reutrn email
    public String getEmail(User obj) {
        return obj.email;
    }

    //return tutor name
    public String getInstructorName(User obj) {
        return obj.name;
    }

    //return phone no
    public String getPhone(User obj) {
        return obj.phn;
    }

    //return date
    public String getDate(User obj) {
        return obj.cur_date;
    }

    //view modules that you are on
    protected ArrayList viewModules() {
        ArrayList<Module> details = new ArrayList();

        //database query
        return details;
    }

    //get all tutors list object
    public ArrayList<Instructor> getTutorsList() throws ClassNotFoundException, SQLException {
        ArrayList<Instructor> tutor_list = new ArrayList<Instructor>();

        //db connection
        Connection con = new DB_Connection().connect();

        //select query
        query = "SELECT * FROM Instructor";

        //execute the query and store return objects into rs
        rs = st.executeQuery(query);

        //iterate the each object value
        while (rs.next()) {
            tutor_list.add(new Instructor(rs.getInt("iid"), rs.getString("username"), rs.getString("email"), rs.getString("phone"), rs.getString("date")));
        }

        return tutor_list;
    }

    //add tutors
    public boolean addTutor(int uid, String tutor1, String tutor2, String tutor3) throws SQLException, ClassNotFoundException {
        //bind the three tutor string into on string format
        StringBuffer sb = new StringBuffer();
        sb.append(tutor1 + ",");
        sb.append(tutor2 + ",");
        sb.append(tutor3);
        String tutors = sb.toString();

        query = "UPDATE module SET instructor='" + tutors + "' WHERE mid='" + uid + "'";

        //check if insert success or not
        if (st.executeUpdate(query) > 0) {
            System.out.println("Course added successfully!");
            
            return true;
        } else {
            System.out.println("Course failed to add!");
            return false;
        }
    }
}
