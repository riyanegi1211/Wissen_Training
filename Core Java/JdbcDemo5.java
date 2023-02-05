import java.sql.*;

public class JdbcDemo5 {
    public static void main(String args[])
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
            // Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select *from EMP");

            while(rs.next())
            {
                System.out.println("\nName: "+rs.getString(1));
                System.out.println("\nAge: "+rs.getString(2));
            }
            System.out.println("--------------------------");
            
            while(rs.previous())
            {
                System.out.println("\nName: "+rs.getString(1));
                System.out.println("\nAge: "+rs.getInt(2));
            }
            System.out.println("-----------------------------------");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }
}
