class Al implements Cloneable// if we dont provide cloneable than it will return null
{
int x;
public String toString(){
    return "value is "+x;
}
    public Al clone()
    {
        try{
            return (Al)super.clone();// this doeas the actual work
        }
        catch(Exception q){
            System.out.println(q);
        }
        return null;
    }
    public void finalize(){
        System.out.println("object  with vale"+x+"destroyed");
    }
    //-------OR-------
// getDuplicateclone() its is random name given 
// return (Al)super.clone();// this doeas the actual work

    // public Al getDuplicateclone()// override
    // {
    //     try{
    //         return (Al)super.clone();
    //     }
    //     catch(Exception q){
    //         System.out.println(q);
    //     }
    //     return null;
    // }

}
public class LangDemo {

    public static void main(String[] args) {
    Al a1=new Al();
    a1.x=20;
    
    Al a2=new Al();
    a2.x=70;

    Al a3=a1.clone();

     System.out.println(a1);  // automatically call tostring()  
     System.out.println(a2);  // automatically call tostring()  
     System.out.println(a3);  // automatically call tostring()  
    
        Class c1=a3.getClass();
         System.out.println("a3 is object of class"+c1.getName());
        Class c2="hello".getClass();
        System.out.println("'hello ' is object of "+c2.getName());

        a2=null;
        a1=null;
        System.gc();
        

        String s1="Hello";
        String s2="Hello";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        

    }
}