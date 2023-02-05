import java.io.*;

public class IODemo3 {
    public static void main(String args[])
    {
        try
        {
            RandomAccessFile raf = new RandomAccessFile("abc.txt", "rw");
            //raf.seek(5);
            //System.out.println(raf.readLine());

            raf.seek(raf.length());
            raf.writeBytes("Good Afternoon");
            raf.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
