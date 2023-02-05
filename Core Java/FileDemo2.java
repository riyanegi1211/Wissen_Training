import java.util.*;
import java.io.*;
public class FileDemo2 {
    public static void main(String args[])
    {
        try
        {
            File f = new File("abc.txt");
            System.out.println("File length: ",f.length());
            System.out.println("It is a File: ",f.isFile());
            System.out.println("Is it a Directory: ",f.isDirectory());
            System.out.println("Last modified time", new Date(f.lastModified()));

            f.renameTo(new File("xyz.txt"));
            File f2 = new File("xyz.txt");
            f2.delete();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
