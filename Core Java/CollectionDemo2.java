import java.util.*;
public class CollectionDemo2 {
    public static void main(String args[])
    {
        ArrayList<Object> list = new ArrayList<Object>();

        list.add("Hello");
        list.add(35262);
        list.add(new Date());
        list.add(45.6);
        
        System.out.println(list);

        HashMap<Integer, String> map= new HashMap<Integer, String>();
        map.put(111,"Rajesh");
        map.put(222,"Mahesh");
        map.put(333,"Mukesh");

        System.out.println(map);

        AddingElements<Integer> obj1 = new AddingElements<Integer>;
        obj1.add(111,222);
        AddingElements<String> obj2 = new AddingElements<String>;
        obj2.add("abc","xyz");
        AddingElements<Boolean> obj3 = new AddingElements<Boolean>;
        obj3.add(true,false);

    }
}
class AddingElements<T>
{
    public void add(T a, T b)
    {
        System.out.println("Addition of some type");
    }
}
