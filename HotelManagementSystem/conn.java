
package hotel.management.system;

import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    
    public conn()
    {
    try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql://localhost:3307/hms","root","pass123");
           s=c.createStatement();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    }
}
