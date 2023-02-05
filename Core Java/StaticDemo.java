class A
{
    static int x;
    public static void abc()
    {
        System.out.println("HELLO");
    }
    static class B
    {

    }
}
public class StaticDemo {
    static int q=100;
    public static void main(String args[])
    {
        System.out.println("From Main Method");
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();

        a1.x = 10;
        a2.x = 20;
        a3.x = 30;

        a2.x = 50;

        System.out.println(a1.x);
        System.out.println(a2.x);
        System.out.println(a3.x); 
        
        A.abc();
    }
    static 
    {
        System.out.println("From Main Method"+q);
    }
}
