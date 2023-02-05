class A implements Runnable
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName()+"Has Started");
        synchronized(this)
        {
            for(int i=1;i<=20;i++)
            {
                System.out.println(Thread.currentThread().getName()+": "+i);
                try
                {
                    Thread.sleep(500);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}
public class SynchronizedDemo {
    public static void main(String args[])
    {
        
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        Thread t3 = new Thread(new A());

        t1.setName("Rita");
        t2.setName("Geeta");
        t3.setName("Sita");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Main Exit");
    }
}
