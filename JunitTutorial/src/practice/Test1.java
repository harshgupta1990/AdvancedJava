package practice;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Test1 {
	
	int x=2,y=2,z=3;

	boolean a= (x==y);
	boolean b= (y==z);
	
	@Test
	public void test()
	{
		assertTrue(x==y);
	}

	@Test
	public void testing()
	{
		assertFalse(y==z);
	}
	
	
	@Test
	public void testing1()
	{
		assertTrue(a);
		assertFalse(b);
	}
	
	
	@Test
	public void testing2()
	{
		assertNotEquals(a, b);
	}
	
}
