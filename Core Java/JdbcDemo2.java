import java.io.*;
import java.sql.*;

public class JdbcDemo2 {
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
            //Load the Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Establish connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
            PreparedStatement pstmt = con.prepareStatement("Insert into EMP values(?,?)");

            System.out.println("Enter Name: ");
            String name = br.readLine();
            System.out.println("Enter Age: ");
            int age = Integer.parseInt(br.readLine());

            pstmt.setString(1,name);
            pstmt.setInt(2,age);
            pstmt.execute();

            pstmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
