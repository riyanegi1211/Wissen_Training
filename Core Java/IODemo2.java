import java.io.FileOutputStream;
import java.io.*;
public class IODemo2 {
    public static void main(String args[])
    {
        try
        {
            //PrintWriter pw = new PrintWriter(System.out);
            PrintWriter pw = new PrintWriter(new FileOutputStream("abc.txt",true));
            pw.println("THANK YOU");
            pw.flush();
            pw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
