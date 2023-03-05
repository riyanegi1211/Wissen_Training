package Wissen.JUnitTesting;

import static org.junit.Assert.*;
import org.junit.*;

class InvalidVotingException extends Exception
{
	InvalidVotingException(String str)
	{
		super(str);
	}
}

public class TestFunction {
	
	public String login(String userId, String password)
	{
		if(userId.equals("Riya") && password.equals("Admin"))
			return "Valid User";
		else
			return "Invalid User";
	}

	public int sum(int param1,int param2)
	{
		return param1+param2;
	}
	
	public String evenOrOdd(int num)
	{
		if(num%2==0)
			return "Even";
		else
			return "False";
	}
	public String vote(int age)throws InvalidVotingException
	{
		if(age>=18)
			return "You can vote";
		else
			throw new InvalidVotingException("You can vote");
	}
	
	//Unit Test Cases

	@Test
	public void testLogin()
	{
		TestFunction loginObj = new TestFunction();
		String result = loginObj.login("Riya", "Admin");
		
		assertEquals("Valid User",result);
	}

	@Test
	public void testSum()
	{
		TestFunction sumObj = new TestFunction();
		int x = 20;
		int y = 30;
		int result = sumObj.sum(x, y);
		assertEquals(50,result);
	}
	
	@Test
	public void testEvenOrOdd()
	{
		TestFunction obj = new TestFunction();
		int x = 12;
		String strResult = obj.evenOrOdd(x);
		assertEquals("Even",strResult);
	}
	
	@Test (expected = InvalidVotingException.class)
	public void testVoting() throws InvalidVotingException
	{
		TestFunction votingObj = new TestFunction();
		
		int x = 12;
		votingObj.vote(x);
		
	}
}
