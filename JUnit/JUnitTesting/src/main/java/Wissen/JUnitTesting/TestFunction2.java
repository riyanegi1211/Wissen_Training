package Wissen.JUnitTesting;

import static org.junit.Assert.*;
import org.junit.*;

public class TestFunction2 {
	@BeforeClass
	public static void beforeAllTestcases()
	{
		System.out.println("@BeforeClass is executed before the first test case");
	}
	public int sum(int param1, int param2)
	{
		return param1+param2;
	}
	public String login(String userId, String password)
	{
		if(userId.equals("Riya") && password.equals("Admin"))
			return "Valid User";
		else
			return "Invalid User";
	}
	@Before
	public void beforeTestCase()
	{
		System.out.println("@Before is executed before the testcases");
	}
	
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
	@After
	public void afterTestCase()
	{
		System.out.println("@After is executed after the testcases");
	}
	@AfterClass
	public static void afterAllTestCase()
	{
		System.out.println("@AfterClass is executed after the last testcases");
	}	
}
