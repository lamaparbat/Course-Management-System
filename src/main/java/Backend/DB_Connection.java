package Backend;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {
    //required attr
    Connection con;
    
    public DB_Connection() throws ClassNotFoundException, SQLException{
        connect();
    }
    
    Connection connect() throws ClassNotFoundException, SQLException {
        //mysql connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cms", "root", "");
        
        if(con != null){
            return con;
        }else{
            return con;
        }
    }
    
    public void close() throws SQLException{
      con.close();
    }
}
