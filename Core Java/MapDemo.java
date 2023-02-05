import java.util.*;
public class MapDemo {
    public static void main(String args[])
    {
        //Hashtable obj = new Hashtable();
        //HashMap obj =new HashMap();
        //TreeMap obj = new TreeMap();
        LinkedHashMap obj = new LinkedHashMap();

        obj.put("5", "Riya");
        obj.put("3","Mohak");
        obj.put("2","Kunal");
        obj.put("4","Diksha");
        obj.put("1","Manas");

        Set s = obj.entrySet();
        Iterator i = s.iterator();
        while(i.hasNext())
        {
            //System.out.println(i.next());// Prints key value pair
            Map.Entry me = (Map.Entry) i.next();
            System.out.println("\nEmp ID: "+me.getKey());
            System.out.println("Name: "+me.getValue());
        }
    }
}
