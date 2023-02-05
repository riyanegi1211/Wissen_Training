//Package Created
package project;

//Predefined Packages imported
import java.util.InputMismatchException;
import java.util.*;
import java.util.regex.Pattern;
import java.sql.*;
import java.io.*;

abstract class Employee
{
    private int employeeID;
	private String name;
	private int age;
	private double salary;
	private String designation;
    public static int count=0;

    protected Employee(int salary, String designation)
	{
		this.employeeID = InvalidEmployeeIDException.employeeID();
		this.name = InvalidNameException.readName();
		this.age = InvalidAgeException.readAge();
		this.salary = salary;
		this.designation = designation;
        try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
            PreparedStatement pstmt = con.prepareStatement("Insert into EMPLOYEE values(?,?,?,?,?)");
            pstmt.setInt(1,employeeID);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setInt(4,salary);
			pstmt.setString(5,designation);
			
			pstmt.execute();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
    public static int getCount()
	{
		return count;
	}
    //Method to display records
    public static void display()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement pstmt = con.prepareStatement("select * from EMPLOYEE");
			ResultSet rs=pstmt.executeQuery();  
			while(rs.next())
			{
				System.out.println("\nEMPLOYEE ID : "+rs.getInt(1));
				System.out.println("NAME : "+rs.getString(2));
				System.out.println("AGE : "+rs.getInt(3));
				System.out.println("SALARY : "+rs.getInt(4));
				System.out.println("DESIGNATION : "+rs.getString(5));
			}
			pstmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
    //Method to Raise Salary
    public static void raiseSalary()
    {
        try
        {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
                Statement stmt = con.createStatement();

                stmt.executeUpdate("update EMPLOYEE set SALARY = SALARY + 2000 where DESIGNATION = 'Clerk'");
                stmt.executeUpdate("update EMPLOYEE set SALARY = SALARY + 5000 where DESIGNATION = 'Programmer'");
                stmt.executeUpdate("update EMPLOYEE set SALARY = SALARY + 10000 where DESIGNATION = 'Manager'");
                
            System.out.println("Salary raised for all");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    } 
    //Method to remove a record
    public static void remove()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement pstmt = con.prepareStatement("delete from EMPLOYEE where EID=?");
			System.out.print("Enter Employee ID : ");
			int id = new Scanner(System.in).nextInt();
			pstmt.setInt(1,id);
			pstmt.execute();
			pstmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
//Exception Handling
//For Age
class InvalidAgeException extends Exception
{
    public InvalidAgeException()
    {
              
    }
    public InvalidAgeException(String msg)
    {
        super(msg);
    }
    public static int readAge()
    {
        while(true)
        {
            try
            {
                System.out.print("Enter Age : ");
                int age=new Scanner(System.in).nextInt();
                if(age<21 || age>60)
                {
                    throw new InvalidAgeException();
                }
                else
                {
                    return age;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter number only ........");
            }
            catch(InvalidAgeException e)
            {
                System.out.println("Please Enter number between 20 to 60 ........");
            }
        }
    }
}
//For Name
class InvalidNameException extends Exception
{
    public InvalidNameException()
    {
        
    }
    public InvalidNameException(String msg)
    {
      super(msg);
    }
    public static String readName()
    {
        while(true)
        {
            try
            {
                System.out.print("Enter Name : ");
                String name=new Scanner(System.in).next();
                if(!(Pattern.matches("[a-zA-Z]+",name)))
                {
                    throw new InvalidNameException();
                }
                else
                {
                    return name;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter Letters only ........");
            }
            catch(InvalidNameException e)
            {
                System.out.println("Please Enter valid Name ........");
            }
        }
    }
}
//For choice
class InvalidChoiceException extends Exception
{
    public InvalidChoiceException()
    {
        
    }
    public InvalidChoiceException(String msg)
    {
      super(msg);
    }
    public static int readChoice()
    {
      while(true)
      {
            try
            {
                int ch=new Scanner(System.in).nextInt();
                if(ch!=1 && ch!=2 && ch!=3 && ch!=4 && ch!=5)
                {
                throw new InvalidChoiceException();
                }
                else
                {
                return ch;
                }
            }
            catch(InputMismatchException e)
            {
            System.out.println("Please Enter number only ........");
            }
            catch(InvalidChoiceException e)
            {
            System.out.println("Please Enter number 1 , 2 ,3 , 4 or 5........");
            }
        }
    }
}
//For Employee ID
class InvalidEmployeeIDException extends Exception{
	public InvalidEmployeeIDException()
	{

	}
	public InvalidEmployeeIDException(String msg)
	{
		super(msg);
	}
	public static int employeeID()
	{
		while(true)
		{
			try
			{
		    	System.out.print("Enter Employee ID: ");
	   			int employeeID = new Scanner(System.in).nextInt();
				if(employeeID<1 || employeeID>999)
				{
					throw new InvalidEmployeeIDException();
				}
				else
				{
					return employeeID;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter number only ....");
			}
			catch(InvalidEmployeeIDException e)
			{
				System.out.println("Please enter between 100 - 1000....");
			}
		}
	}
}

// class Clerk
final class Clerk extends Employee
{
	// Constructor
	public Clerk()
	{
		super(10000, "CLERK");
	}
}
// class Programmer
final class Programmer extends Employee
{
	// Constructor
	public Programmer()
	{
		super(25000, "PROGRAMMER");
	}
}

// class Manager
final class Manager extends Employee
{
	// Constructor
	public Manager()
	{
		super(40000, "MANAGER");
	}
}

public class EmployeeManagement 
{
    //Main Menu
    private void mainMenu()
    {
        System.out.println("\n-----CHOOSE YOUR OPTION-----");
        System.out.println("\n1. CREATE");
        System.out.println("2. DISPLAY");
        System.out.println("3. RAISE SALARY");
        System.out.println("4. REMOVE");
        System.out.println("5. EXIT");
        System.out.println("\n----------------------------");
        System.out.print("\nENTER YOUR CHOICE: ");
    }
    //Sub-Menu
    private void subMenu()
    {
        System.out.println("\n-----CHOOSE YOUR OPTION-----");
        System.out.println("\n1. CLERK");
        System.out.println("2. PROGRAMMER");
        System.out.println("3. MANAGER");
        System.out.println("4. EXIT");
        System.out.println("\n----------------------------");
        System.out.print("\nENTER YOUR CHOICE: ");
    }

	// the main function...
	public void run()
	{
		int choice1, choice2;
		do{
			mainMenu();
            choice1 = InvalidChoiceException.readChoice();
			System.out.println("--------------------------------------------------");
			
			switch(choice1)
			{
				// Create
				case 1:

					do{
						subMenu();

						choice2 = InvalidChoiceException.readChoice();

						System.out.println("--------------------------------------------------");
						switch(choice2)
						{
							// Clerk creation...
							case 1:
								new Clerk();
								break;
							// Programmer creation...
							case 2:
								new Programmer();
								break;
							// Manager creation...
							case 3:
								new Manager();
								break;
							case 4:
								System.out.println("------CREATED ALL------");
								break;
							default:
								System.out.println("INVALID VALUE ENTERED");
						}
					}while(choice2 != 4);
					break;

				// Display
				case 2:
					Employee.display();
					break;
				
				// Raise Salary
				case 3:
					Employee.raiseSalary();
					break;

				// Delete a record
				case 4:
                    Employee.remove();
					break;

				case 5:
                    System.out.print("Number of Employees are: "+Employee.count);
                    System.exit(0);
                    break;

				default:
					System.out.println("INVALID VALUE ENTERED");
			}
		}while(choice1 != 5);
	}
}
