import java.sql.*;

public class JdbcDemo {
    public static void main(String args[])
    {
        try
        {
            //Load the Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Establish connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
            Statement stmt = con.createStatement();

            //stmt.executeUpdate("insert into EMP values('Amit', 33)");
            //stmt.executeUpdate("delete from emp where AGE>30;");
            stmt.executeUpdate("update emp set AGE=AGE+1");
            /* 
            ResultSet rs = stmt.executeQuery("Select * from EMP");
            while(rs.next())
            {
                System.out.println("\nName: "+rs.getString("Name"));
                //System.out.println("\nName: "+rs.getString(1));
                System.out.println("Age: "+rs.getInt(2));
            }
            //Deallocating the resources and diconnecting
            rs.close();
            */
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
