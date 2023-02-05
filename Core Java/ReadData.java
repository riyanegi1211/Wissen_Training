import java.io.*;
public class ReadData {
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your Name");
            String name = br.readLine();

            System.out.print("Enter your Age");
            int age = Integer.parseInt(br.readLine());

            System.out.println("--------------------");

            System.out.println("Your Name:"+name);
            System.out.println("Your age:"+age);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
