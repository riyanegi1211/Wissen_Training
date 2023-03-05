package Wissen.JUnitTesting;

import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTesting {

	@Test
	public void arrayComparison()
	{
		String[] array1 = {"Apple","Orange","Guava"};
		String[] methodOutput = {"Apple","Orange","Guava"};
		assertArrayEquals(array1,methodOutput);
	}
}
