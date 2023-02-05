import java.util.*;
/* 
class Emp implements Comparable<Emp>
{
    String name;
    int age;
    Emp(String n, int a)
    {
        name = n;
        age = a;
    }
    public String toString()
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        return "";
    }
    public int compareTo(Emp e)
    {
        return new Integer(this.age).compareTo(e.age);
    }
}
*/
class Emp
{
    String name;
    int age;
    
    Emp(String n, int a)
    {
        name = n;
        age = a;
    }
    public String toString()
    {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        return "";
    }
}
public class CollectionDemo3 {
    public static void main(String args[])
    {
        //TreeSet<Emp> obj = new TreeSet<Emp>(new AgeSorter());
        ArrayList<Emp> obj = new ArrayList<Emp>();

        obj.add(new Emp("Riya",22));
        obj.add(new Emp("Mohak",21));
        obj.add(new Emp("Kunal",22));
        obj.add(new Emp("Ayush",25));
        obj.add(new Emp("Pankaj",26));

        Collections.sort(obj, new NameSorters());

        Iterator i = obj.iterator();
        while(i.hasNext())
        {
            System.out.print(i.next());
        }
    }
}
