import java.sql.*;

public class JdbcDemo3 {
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
            
            CallableStatement cstmt = con.prepareCall("CALL my_proc()");
            cstmt.execute();

            System.out.println("Called stored procedure successfully");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
