class A
{
    //abstract int x = 10;
    public void abc()
    {

    }
}
interface I
{
    public void xyz();
}
abstract class B
{
    public void abc()
    {

    }
    public abstract void xyz();
}
abstract class C extends B
{

}
class D extends C
{
    public void xyz()
    {

    }
}
public class AbstractDemo {
    public static void main(String args[])
    {
        //B b1 = new B();
        //C c1 = new C();
    }
}
