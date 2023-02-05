import java.io.*;
public class FileDemo {
    public static void main(String args[])
    {
        try
        {
            File dir1 = new File("abc");
            dir1.mkdir();

            File dir2 = new File("xyz");
            dir2.mkdir();

            File f = new File(dir2,"atoz.txt");
            f.createNewFile();

            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
            pw.flush();
            pw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
