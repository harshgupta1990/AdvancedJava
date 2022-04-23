package assertEquals;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class RectangleUtilitiesTest {
	
	@Test
	public void testGetArea()
	{
		System.out.println("Testing in progress.....");
		int expected=6;
		int actual=RectangleUtilities.getArea(2, 5);	
		assertEquals(expected, actual);
		//assertNotEquals(expected, actual);
		
		System.out.println("Testing completed.");
	}
	


}
