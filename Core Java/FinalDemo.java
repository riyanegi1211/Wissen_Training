class A
{
    final int var = 50;
    final int x;
    A()
    {
        x = 50;
    }
    final public void greet()
    {
        System.out.println("HI from A class");
    }
}
final class B extends A
{
    /*
    public void greet()
    {
        System .out.println("HI from B class");
    }
     */
}
/*class C extends B
{

}
*/
public class FinalDemo {
    public static void main(String args[])
    {
        final int x = 10;
        System.out.println(x);
        //x = 20;
        System.out.println(x);

        A a1 = new A();
        System.out.println(a1.var);
        //a1.var = 100;
        System.out.println(a1.var);

        a1.greet();

        B b1 = new B();
        b1.greet();
    }
}
