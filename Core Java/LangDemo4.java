public class LangDemo4 {
    public static void main(String args[])
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            System.out.println("Ready for magic....");

            System.out.println("Wait for 10secs then");
            Thread.sleep(10000);
            Process p1 = rt.exec("calc.exe");

            System.out.println("Wait for 5secs then");
            Thread.sleep(5000);
            Process p2 = rt.exec("mspaint.exe");

            System.out.println("Wait for 5secs then");
            Thread.sleep(5000);
            Process p3 = rt.exec("notepad.exe");
            
            System.out.println("Finally wait for another 10 secs...");
            Thread.sleep(10000);
            p3.destroy();
            Thread.sleep(5000);
            p2.destroy();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
