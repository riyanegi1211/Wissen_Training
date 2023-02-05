import java.io.*;
public class SerializationDemo {
    public static void main(String args[])
    {
        try
        {
            Person p1 = new Person();
            p1.name = "Riya";
            p1. age = 22;

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
            oos.writeObject(p1);
            oos.close();

            System.out.println("Serialized successfully...");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
