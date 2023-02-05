import java.util.*;
public class UtilDemo {
    public static void main(String args[])
    {
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println(d1.getHours()+" : "+d1.getMinutes()+" : "+d1.getSeconds());

        Date d2 = new Date();
        d2.setMonth(9);
        d2.setDate(2);
        System.out.println(d2);

        System.out.println(d1.after(d2));
        System.out.println(d1.before(d2));
        System.out.println(d1.equals(d2));

        Date d3 = new Date();
        d3.setTime(4031327609979L);
        System.out.println(d3);

        System.out.println("-----------------");
        String str = "Raju|22|25000|Clerk|raju@abc.com|Banglore";
        StringTokenizer st = new StringTokenizer(str,"|");

        /*
        System.out.println("Name: "+st.nextToken());
        System.out.println("Age: "+st.nextToken());
        System.out.println("Salary: "+st.nextToken());
        System.out.println("Designation: "+st.nextToken());
        System.out.println("Mail ID: "+st.nextToken());
        System.out.println("Location: "+st.nextToken());
        */

        /* If multiple Delimiter are there:
        String str = "Raju|22#25000:Clerk|raju@abc.com|Banglore";
        StringTokenizer st = new StringTokenizer(str,"|#;");
         */

        int count = st.countTokens();
        for(int i=0;i<count;i++)
        {
            System.out.println(st.nextToken());
        }
        System.out.println("-----------------");
        Stack s1 = new Stack();
        s1.push("1");
        s1.push("2");
        s1.push("3");
        s1.push("4");
        s1.push("5");

        /*
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.peek());
        System.out.println(s1.peek());
        System.out.println(s1.peek());
         */

        System.out.println(s1.search("6"));    // Will return -1
        System.out.println(s1.empty());

        System.out.println("----------------");

        //Vector and Enumeration

        Vector v1 = new Vector(2);  //Initial size is necessary to give, it saves time of the compiler if the size limit exceeds
        v1.add("HELLO");
        v1.add(new Integer(3234));
        v1.add(new Date());
        v1.add(new Thread());
        v1.add("THANK YOU");

        Enumeration e = v1.elements();
        while(e.hasMoreElements())
        {
            System.out.print(e.nextElement());
        }
    }
}
