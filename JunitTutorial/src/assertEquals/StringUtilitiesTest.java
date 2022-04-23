package assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class StringUtilitiesTest {
	
	@Test
	public void testVowelCount()
	{
		StringUtilities stringUtilities = new StringUtilities();
		assertEquals(2, stringUtilities.vowelCount("Harshit"));
		assertEquals(3, stringUtilities.vowelCount("Abhinav"));
		assertEquals(2, stringUtilities.vowelCount("Prakash"));
		assertEquals(2, stringUtilities.vowelCount("Vimal"));
		
		//assertNotEquals(2, stringUtilities.vowelCount("Vimal"));
		
		
	}

	
	@Test
	public void isCapitalized()
	{
		StringUtilities stringUtilities = new StringUtilities();
		assertFalse(stringUtilities.isCapitalized("Harshit"));
		assertFalse(stringUtilities.isCapitalized("abhinav"));
		assertFalse(stringUtilities.isCapitalized("prakash"));
		assertFalse(stringUtilities.isCapitalized("Vimal"));
		assertFalse(stringUtilities.isCapitalized("a"));
		assertFalse(stringUtilities.isCapitalized(""));
		assertFalse(stringUtilities.isCapitalized(null));
		
		
		
	}
	
}
