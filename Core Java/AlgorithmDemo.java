import java.util.*;
public class AlgorithmDemo {
    public static void main(String args[])
    {
        LinkedList list = new LinkedList();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        //Collections.swap(list,3,6);
        //Collections.reverse(list);
        //Collections.shuffle(list);
        Collections.sort(list);

        Iterator i = list.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
    }
}
