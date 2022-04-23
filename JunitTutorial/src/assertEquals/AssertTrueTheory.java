package assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTrueTheory {
	
	
	@Test
	public void test1()
	{
		assertTrue(true);
	}

	@Test
	public void test2()
	{
		assertTrue(2==3);
	}
	
	@Test
	public void test3()
	{
		assertTrue("abc".length()==3);
	}
	
	
	@Test
	public void test4()
	{
		assertFalse("abc".length()==4);
	}
	
	
}
