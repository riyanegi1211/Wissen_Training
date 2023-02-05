import java.sql.*;
import java.io.*;

public class TransactionDemo {
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","tiger");
            con.setAutoCommit(false);

            PreparedStatement pstmt = con.prepareStatement("insert into EMP values(?,?)");
            for(int i=1;i<=10;i++)
            {
                System.out.println("Enter Name: ");
                String name = br.readLine();
                System.out.println("Enter Age: ");
                int age = Integer.parseInt(br.readLine());

                pstmt.setString(1,name);
                pstmt.setInt(2,age);
                pstmt.execute();

                if(i==5)
                {
                    con.rollback();
                }
                else
                {
                    con.commit();
                }
            }
            pstmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
