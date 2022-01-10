package Backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    Connection con = null;
    Connection connect() throws ClassNotFoundException, SQLException {
        //mysql connection
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/cms", "root", "");
        
        if(con != null){
            return con;
        }else{
            return con;
        }
    }

}
