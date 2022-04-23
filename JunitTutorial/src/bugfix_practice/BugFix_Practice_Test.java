package bugfix_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import assertEquals.RectangleUtilities;

public class BugFix_Practice_Test 
{
	
	@Test
	public void testGetPerimeter()
	{
		int height=4;
		int width=6;
		int expected=20;
		
		int actual=RectangleUtilities.getPerimeter(4, 6);
		
		assertEquals(expected, actual);
		
	}

}
