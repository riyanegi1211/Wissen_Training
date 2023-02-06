//Package Created
package project2;

//Imported Packages
import java.util.InputMismatchException;
import java.util.*;
import java.util.regex.Pattern;
import java.sql.*;
import java.io.*;

class Student
{
	public static void add()
	{
	      int reg_no = InvalidRegIDException.readReg_no();
	      String name = InvalidNameException.readName();
	      int age = InvalidAgeException.readAge();
	      int standard = InvalidStandardException.readStandard();
	      String school = InvalidSchoolException.readSchool();

	      try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			PreparedStatement pstmt = con.prepareStatement("Insert into STUDENTS values(?,?,?,?,?)");
			pstmt.setInt(1,reg_no);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setInt(4,standard);
			pstmt.setString(5,school);

			pstmt.execute();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

//Method to display all records
public static void displayAll()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		PreparedStatement pstmt = con.prepareStatement("select * from STUDENTS");
		ResultSet rs=pstmt.executeQuery();  
		while(rs.next())
		{
			System.out.println("\nREGISTRATION NO : "+rs.getInt(1));
			System.out.println("NAME : "+rs.getString(2));
			System.out.println("AGE : "+rs.getString(3));
			System.out.println("STANDARD : "+rs.getInt(4));
			System.out.println("SCHOOL : "+rs.getString(5));
		}
		pstmt.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
//Method to display by Registration No.
public static void displayByRegNo()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");

		System.out.print("\nEnter Registration No.: ");
		int reg_no = new Scanner(System.in).nextInt();

		PreparedStatement pstmt = con.prepareStatement("select * from STUDENTS where REG_NO=?");
		pstmt.setInt(1,reg_no);
		ResultSet rs=pstmt.executeQuery();  
		while(rs.next())
		{
			System.out.println("\nREGISTRATION NO : "+rs.getInt(1));
			System.out.println("NAME : "+rs.getString(2));
			System.out.println("AGE : "+rs.getString(3));
			System.out.println("STANDARD : "+rs.getInt(4));
			System.out.println("SCHOOL : "+rs.getString(5));
		}
		pstmt.close();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
public static void result()
{
	try
      	{
		 BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		 PreparedStatement pstmt = con.prepareStatement("Insert into SUBJECTS values(?,?,?,?,?,?)");

		 System.out.println("--------Enter yours Marks-------");

		 System.out.println("REGISTRATION NO.: ");
		 int reg_no = Integer.parseInt(br.readLine());
		 pstmt.setInt(1,reg_no);
		 System.out.println("ENGLISH: ");
		 int english = Integer.parseInt(br.readLine());
		 pstmt.setInt(2,english);
		 System.out.println("HINDI: ");
		 int hindi = Integer.parseInt(br.readLine());
		 pstmt.setInt(3,hindi);
		 System.out.println("MATHS: ");
		 int maths = Integer.parseInt(br.readLine());
		 pstmt.setInt(4,maths);
		 System.out.println("SCIENCE: ");
		 int science = Integer.parseInt(br.readLine());
		 pstmt.setInt(5,science);
		 System.out.println("SOCIAL STUDIES: ");
		 int sst = Integer.parseInt(br.readLine());
		 pstmt.setInt(6,sst);

		 int sum = english+hindi+maths+science+sst;
		 double percentage = (sum/500)*100;
		 System.out.println("Your Percentange is: "+percentage);

		 pstmt.execute();  
		 pstmt.close(); 
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
                if(age<5 || age>17)
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
//For School name
class InvalidSchoolException extends Exception
{
    public InvalidSchoolException()
    {
        
    }
    public InvalidSchoolException(String msg)
    {
      super(msg);
    }
    public static String readSchool()
    {
        while(true)
        {
            try
            {
                System.out.print("Enter School Name: ");
                String school=new Scanner(System.in).next();
                if(!(Pattern.matches("[a-zA-Z]+",school)))
                {
                    throw new InvalidSchoolException();
                }
                else
                {
                    return school;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter Letters only ........");
            }
            catch(InvalidSchoolException e)
            {
                System.out.println("Please Enter valid School Name ........");
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
//For Student Registration No
class InvalidRegIDException extends Exception{
	public InvalidRegIDException()
	{

	}
	public InvalidRegIDException(String msg)
	{
		super(msg);
	}
	public static int readReg_no()
	{
		while(true)
		{
			try
			{
		    	System.out.print("Enter Registration No: ");
	   		int reg_no = new Scanner(System.in).nextInt();
				if(reg_no<1 || reg_no>999)
				{
					throw new InvalidRegIDException();
				}
				else
				{
					return reg_no;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter number only ....");
			}
			catch(InvalidRegIDException e)
			{
				System.out.println("Please enter between 1 - 1000....");
			}
		}
	}
}
//For Standard
class InvalidStandardException extends Exception
{
    public InvalidStandardException()
    {
              
    }
    public InvalidStandardException(String msg)
    {
        super(msg);
    }
    public static int readStandard()
    {
        while(true)
        {
            try
            {
                System.out.print("Enter Standard : ");
                int standard=new Scanner(System.in).nextInt();
                if(standard<1 || standard>10)
                {
                  throw new InvalidStandardException();
                }
                else
                {
                  return standard;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please Enter number only ........");
            }
            catch(InvalidStandardException e)
            {
                System.out.println("Please Enter number between 1 to 10 ........");
            }
        }
    }
}


//Main class of Menu
public class StudentManagement
{
    public void mainMenu()
    {
        System.out.println("\n-----CHOOSE YOUR OPTION-----");
        System.out.println("\n1. ADD");
        System.out.println("2. SEARCH");
        System.out.println("3. RESULT");
        System.out.println("4. EXIT");
        System.out.println("\n----------------------------");
        System.out.print("\nENTER YOUR CHOICE: ");
    }
    public void subMenu()
    {
        System.out.println("\n------CHOOSE YOUR OPTION------");
        System.out.println("\n1. BY REGISTRATION NO.");
        System.out.println("2. ALL STUDENTS");
        System.out.println("3. EXIT");
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
               				Student.add();
					break;
				// Display
				case 2:
            				do
					{
               					subMenu();

					       choice2 = InvalidChoiceException.readChoice();

					       System.out.println("--------------------------------------------------");
					       switch(choice2)
					       {
						  case 1:
						     Student.displayByRegNo();
						     break;
						  case 2:
						     Student.displayAll();
						     break;
						  case 3:
						     System.exit(0);
						     break;
						  default:
						     System.out.println("INVALID VALUE ENTERED");
					       }
				    	}while(choice2 != 3);
				    	break;
				//Show Result
				case 3:
					Student.result();
					break;
            			//Exit
				case 4:
				       System.exit(0);
				       break;
				default:
					System.out.println("INVALID VALUE ENTERED");
			}
		}while(choice1 != 4);
	}
}
