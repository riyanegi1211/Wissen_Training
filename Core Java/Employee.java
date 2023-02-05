//Package Created
package Project;

//Predefined Packages imported
import java.util.InputMismatchException;
import java.util.*;
import java.util.regex.Pattern;

abstract class Emp
{
   private String name;
   private int age;
   private int salary;
   private String designation;
   public static int count=0;
   //Constructor to assign values
   public Emp(int salary, String designation)
   {
      this.salary=salary;
      this.designation=designation;

      name= InvalidNameException.readName();
      age= InvalidAgeException.readAge();
      count++;
   }


   public String toString()
   {
      return "Name: "+ this.name+'\n'+
      "Age: "+ this.age+'\n'+
      "Salary: "+ this.salary+'\n'+
      "Designation: "+ this.designation+'\n';
   }

   /*
   protected final void display()
   {
      System.out.println("\nName: "+this.name);
      System.out.println("Age: "+this.age);
      System.out.println("Salary: "+this.salary);
      System.out.println("Designation: "+this.designation);
   }
    */
   public abstract void raiseSalary();

   public int getSalary()
	{
		return salary;
	}

	// method to set salary value
	public void setSalary(int salary)
	{
		if(salary >= 0)
		this.salary = salary;
	}
   public String getName()
   {
      return name;
   }
   public int getAge()
   {
      return age;
   }
   public String getDesignation()
   {
      return designation;
   }
}
final class Clerk extends Emp
{
   public Clerk()
   {
      super(10000,"Clerk");        
   }
   public void raiseSalary()
   {
      setSalary(getSalary()+2000);
   }
 }
final class Programmer extends Emp
{
   public Programmer()
   {
      super(25000,"Programmer");        
   }
   public void raiseSalary()
   {
      setSalary(getSalary()+5000);
   }
}

final class Manager extends Emp
{
   public Manager()
   {
      super(80000,"Manager");        
   }
   public void raiseSalary()
   {
      setSalary(getSalary()+10000);
   }
}

//Exception Handling
class InvalidAgeException extends Exception
{
   public InvalidAgeException()
   {
   }
   public InvalidAgeException(String msg)
   {
      //calling the constructor of parent Exception
      super(msg);
   }
   
   public static int readAge()
   {
      while(true)
      {
         try
         {
            System.out.print("Enter Age: ");
            int age = new Scanner(System.in).nextInt();
            if(age<21 || age>60)
               throw new InvalidAgeException();
            else
               return age;
         }
         catch(InputMismatchException e)
         {
            System.out.println("Please enter number only");
         }
         catch(InvalidAgeException e)
         {
            System.out.println("Please enter age between 21-60");
         }
      }
   }
}
class InvalidNameException extends Exception
{
   public InvalidNameException()
   {
   }
   public InvalidNameException(String msg)
   {
      //calling the constructor of parent Exception
      super(msg);
   }
   public static String readName()
   {
      while(true)
      {
         try
         {
            System.out.print("Enter Name: ");
            String name = new Scanner(System.in).next();
            if (!(Pattern.matches("[a-zA-Z]+",name)))
               throw new InvalidNameException();
            else
               return name;
         }
         catch(InvalidNameException e)
         {
            System.out.println("Please enter Characters only");
         }
      }
   }
}

//Main class of Menu
public class Employee
{
   /*
    static void print(Emp e1)
   {
      e1.display();
   }
    */

   public static void mainMenu()
   {
      System.out.println("\n-----CHOOSE YOUR OPTION-----");
      System.out.println("\n1. CREATE");
      System.out.println("2. DISPLAY");
      System.out.println("3. RAISE SALARY");
      System.out.println("4. EXIT");
      System.out.println("\n----------------------------");
      System.out.print("\nENTER YOUR CHOICE: ");
   }
   public static void subMenu()
   {
      System.out.println("\n----------------------------");
      System.out.println("\n1. CLERK");
      System.out.println("2. PROGRAMMER");
      System.out.println("3. MANAGER");
      System.out.println("4. EXIT");
      System.out.println("\n----------------------------");
      System.out.print("\nENTER YOUR CHOICE: ");
   }
   public static void displayMenu()
   {
      System.out.println("\n----------------------------");
      System.out.println("\n--------BASED ON--------");
      System.out.println("1. DESIGNATION");
      System.out.println("2. AGE");
      System.out.println("3. NAME");
      System.out.println("4. SALARY");
      System.out.println("\n----------------------------");
      System.out.print("\nENTER YOUR CHOICE: ");
   }
   public void run()
   {
      //Emp emp[]=new Emp[100];
      ArrayList<Emp> e = new ArrayList<Emp>();
      int choice,choice2,choice3;
      int i=0;
      String str1;
      Scanner sc = new Scanner(System.in);
      do
      {
         mainMenu();

         choice = new Scanner(System.in).nextInt();
         switch(choice)
         {
            case 1:
                 do
                 {
                  subMenu();                  
                  choice2 = new Scanner(System.in).nextInt();
                  switch(choice2)
                  {
                     case 1:
                       {
                           //emp[Emp.count] = new Clerk();
                           e.add(new Clerk());
                           break;
                        }   
                     case 2:
                        {
                           //emp[Emp.count] = new Programmer();
                           e.add(new Programmer());
                           break;
                        }
                     case 3:
                        {
                           //emp[Emp.count] = new Manager();
                           e.add(new Manager());
                           break;
                        }   
                     case 4:
                        {
                           System.out.println("--------CREATED ALL--------");
                           break;
                        }
                     default:
                        {
                           System.out.println("INVALID INPUT");
                        }
                     }     
                 }while(choice2!=4);
                 break;
            case 2:
            {
               /*for (int j = 0; j < i; j++) 
               {
                  //emp[j].display();
                  print(emp[j]);
               }
               */
               Iterator it = e.iterator();
               while(it.hasNext())
               {
                  System.out.println(it.next());
               }
               break;
            }  
            case 3:
            {
               /*for(int j=0;j<i;j++)
                  {
                     emp[j].raiseSalary();
                  }
               */
              
               Iterator<Emp> it = e.iterator();
               while(it.hasNext())
               {
                   it.next().raiseSalary();
               }
               break;
            }     
            case 4:
            {
               System.out.println("Number of Employees are: "+Emp.count);
               System.exit(0);
               break;
            }   
            default:
            {
               System.out.println("INVALID INPUT");
            }  
         }
      }while(choice!=4);
   }
}
