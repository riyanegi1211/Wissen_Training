/*
package com.abc.xyz;
public class A 
{
    public int x = 10;
    public void display()
    {
        System.out.println("From A.display method");
    }
    public static void main(String args[])
    {
        System.out.println("Package Demo");
    }
}
*/
package p1;
public class A //Father
{
    public int x;
    private int y;
    protected int z;
    int q;
    public void display()
    {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(q);
    }
}

class B extends A   //Child
{
    public void display()
    {
        System.out.println(x);
        //System.out.println(y);
        System.out.println(z);
        System.out.println(q);
    }
}
class C //Mother
{
    public void display()
    {
        A a1 = new A();
        System.out.println(a1.x);
        //System.out.println(a1.y);
        System.out.println(a1.z);
        System.out.println(a1.q);
    }
}
/*
Analogy with Family
private- toothbrush(Only father will use it)
default- TV,fridge (All the people staying at home can use it)
public- Water, Charity servive(available to anyone)
protected- property(even if a child goes out then also he/she will have an access to it)
*/