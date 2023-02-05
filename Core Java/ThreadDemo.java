/*
class A extends Thread
{
    public void run()
    {
        for(int i=1;i<=20;i++)
        {
            System.out.println("i: "+i);
        }
    }
}
class B extends Thread
{
    public void run()
    {
        for(int j=1;j<=20;j++)
        {
            System.out.println("j: "+j);
        }  
    }
}
class C extends Thread
{
    public void run()
    {
        for(int k=1;k<=20;k++)
        {
            System.out.println("k: "+k);
        }
    }
}
public class ThreadDemo {
    public static void main(String args[])
    {
        A a1 = new A();
        B b1 = new B();
        C c1 = new C();

        a1.start();
        b1.start();
        c1.start();
        System.out.println("Main Exit");
    }
}
*/

class A extends Thread
{
    public void run()
    {
        for(int i=1;i<=20;i++)
        {
            System.out.println("i: "+i);
            try
            {
                if(i%3==0)
                    Thread.sleep(2000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
class B extends Thread
{
    public void run()
    {
        for(int j=1;j<=20;j++)
        {
            System.out.println("j: "+j);
            try
            {
                Thread.sleep(5000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
class C extends Thread
{
    public void run()
    {
        for(int k=1;k<=20;k++)
        {
            System.out.println("k: "+k);
            try
            {
                Thread.sleep(10000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String args[])
    {
        A a1 = new A();
        B b1 = new B();
        C c1 = new C();

        a1.start();
        b1.start();
        c1.start();
        //refer to main thread
        Thread m1 = Thread.currentThread();
        for(int i=1;i<=200;i++)
        {
            System.out.print(" "+i);
            if(i==30)
                c1.suspend();
            if(i==35)
                b1.stop();
            if(i==150)
                a1.suspend();
            if(i==150)
                c1.resume();
            if(i==160)
            {    
                b1.resume();
            }    
            Thread.sleep(3000);
        }
        System.out.println("Main Exit");
    }
}
/*
A a1 = new A();
B b1 = new B();
C c1 = new C();

a1.start();
b1.start();
c1.start();
Thread m1 = Thread.currentThread();
a1.setName("Raju");
b1.setPriority(8);

System.out.println(a1);
System.out.println(b1);
System.out.println(c1);
System.out.println(m1);

a1.join(); //main waits for a1 to end
System.out.println("a1 is alive"+a1.isAlive());// To check if a thread is alive or not
System.out.println("Main Exit");
//yield() method-causes the currently executing thread 
object to temporarily pause and allow other 
threads to execute.
*/
