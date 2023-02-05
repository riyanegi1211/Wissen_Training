package project.employee;
import java.util.*;

class DesignationSort implements Comparator<Emp>
{
    public int compare(Emp e1,Emp e2)
    {
        String d1=e1.getDesignation();
        String d2=e2.getDesignation();

        return d1.compareTo(d2);
    }
}
class AgeSort implements Comparator<Emp>
{
    public int compare(Emp e1,Emp e2)
    {
        Integer a1=e1.getAge();
        Integer a2=e2.getAge();

        return a1.compareTo(a2);
    }
}
class NameSort implements Comparator<Emp>
{
    public int compare(Emp e1,Emp e2)
    {
        String n1=e1.getName();
        String n2=e2.getName();
        
        return n1.compareTo(n2);
    }
    
}
class SalarySort implements Comparator<Emp>
{
    public int compare(Emp e1,Emp e2)
    {
        Integer s1=e1.getSalary();
        Integer s2=e2.getSalary();
        
        return s1.compareTo(s2);
    }
}