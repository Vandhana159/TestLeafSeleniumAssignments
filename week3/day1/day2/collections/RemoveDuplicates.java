package testLeafAssignmets.week3.day2.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		//Declare a String as "PayPal India"
		String input = "PayPal India";
		//Convert it into a character array
		char[] inputArray = input.toCharArray();
		//Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<Character>();
		//Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		//Iterate character array and add it into charSet
		for(int i = 0; i<inputArray.length;i++)
		{	//add the in the charSet if unique
			boolean add = charSet.add(inputArray[i]);
			//if the character is already in the charSet then, add it to the dupCharSet
			if(!add)
				dupCharSet.add(inputArray[i]);	
		}
		//Check the iterator variable isn't equals to an empty space
		if(dupCharSet.size()!= 0) {
			System.out.println("Unique characters in the strings are");
			//Iterate using charSet
		for(Character s : charSet)
			System.out.print(s);
		System.out.println("\nDuplicate character in the string are/is ");
		for(Character s : dupCharSet)
			//print it
			System.out.print(s);
	}
		else
			System.out.println("No duplicate variables");
}
}