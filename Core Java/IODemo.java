import java.io.*;
public class IODemo {
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter File Name: ");
            String filename = br.readLine();

            File f = new File(filename);
            if(f.exists())
            {
                BufferedReader fr = new BufferedReader(new FileReader(filename));

                String line = null;
                while((line=fr.readLine()) != null) //while the there are lines it will keep on reading
                {
                    System.out.print(line);
                }
                fr.close(); //close the file
            }
            else
            {
                System.out.print("Sorry! File doesn't exist");
            }
            br.close(); //close the bufferedReader to free the resources
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
