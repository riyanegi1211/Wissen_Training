class A implements Runnable
{
    public void run()
    {
        for(int i=1;i<=20;i++)
        {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
public class RunnableDemo {
    public static void main(String args[])
    {
        /*
        A a1 = new A();
        Thread t1 = new Thread(a1);
        t1.start();
        OR
        */
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        Thread t3 = new Thread(new A());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main Exit");
    }
}
