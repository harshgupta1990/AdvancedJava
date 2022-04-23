package assertEquals;

import java.util.HashSet;
import java.util.Scanner;

public class StringUtilities 
{
	
	HashSet<Character> lowerCaseVowels = new HashSet<>();
	HashSet<Character> upperCaseVowels = new HashSet<>();
	
	public StringUtilities() 
	{
		lowerCaseVowels.add('a');
		lowerCaseVowels.add('e');
		lowerCaseVowels.add('i');
		lowerCaseVowels.add('o');
		lowerCaseVowels.add('u');
		upperCaseVowels.add('A');
		upperCaseVowels.add('E');
		upperCaseVowels.add('I');
		upperCaseVowels.add('O');
		upperCaseVowels.add('U');
		
	}
	
	
	public int vowelCount(String str)
	{
		int count=0;
		if(str == null)
				return 0;
		else 
		{
			for(int i=0;i<str.length();i++)
			{
				if(lowerCaseVowels.contains(str.charAt(i)))
				{
					count++;
				}
				
				if(upperCaseVowels.contains(str.charAt(i)))
				{
							count++;
				}
			}
			
			return count;
		}
		
	}
	
	public boolean isCapitalized(String str) {
		
		if(str==null || str.length()==0)
			return false;
		else
		{
			return upperCaseVowels.contains(str.charAt(0));
		}
		
	}
	
	
}
