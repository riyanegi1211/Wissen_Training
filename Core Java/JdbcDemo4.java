import java.sql.*;
import java.util.*;

public class JdbcDemo4 {
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
            
            Statement stmt = con.createStatement();

            stmt.addBatch("Insert into Emp values('Mohak',21)");
            stmt.addBatch("Insert into Emp values('Kunal',21)");
            stmt.addBatch("Insert into Emp values('Diksha',22)");
            stmt.addBatch("Insert into Emp values('Mohan',24)");
            stmt.addBatch("Insert into Emp values('Manas',5)");
            
            System.out.println("Do you want to add all the records in DB? (true/false)");
            boolean confirm = new Scanner(System.in).nextBoolean();
            
            if(confirm)
                stmt.executeBatch();
            else
                System.out.println("None of the query is executed");

            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
