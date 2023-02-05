import java.lang.reflect.Array;
import java.util.*;

public class CollectionDemo {
    public static void main(String args[])
    {
        //HashSet obj = new HashSet();
        //TreeSet obj = new TreeSet();    //In sorted order
        //LinkedHashSet obj = new LinkedHashSet();    //Order in which it is entered
        //Vector obj = new Vector();
        //ArrayList obj = new ArrayList();    //Fast traversal Eg. Admisssion iin college
        //LinkedList obj = new LinkedList();  //Insertion Deletion is easier Eg. Ticket Booking
        PriorityQueue obj = new PriorityQueue();
        
        obj.add("5");
        obj.add("3");
        obj.add("2");
        obj.add("4");
        obj.add("1");

        Iterator i1 = obj.iterator();
        while(i1.hasNext())
        {
            System.out.println(i1.next());
        }
    }
}
