package testLeafAssignmets.week3.day2.collections;

import java.util.LinkedHashSet;
import java.util.Set;

//Declare a String as "PayPal India"
//Convert it into a character array
//Declare a Set as charSet for Character
//Declare a Set as dupCharSet for duplicate Character
//Iterate character array and add it into charSet
//if the character is already in the charSet then, add it to the dupCharSet
//Check the dupCharSet elements and remove those in the charSet
//Iterate using charSet
//Check the iterator variable isn't equals to an empty space
//print it
public class RemoveDuplicates {

	public static void main(String[] args) {
		String input = "India Pakistan";
		char[] inputArray = input.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		System.out.println("input string "+input);
		for(int i = 0; i<inputArray.length;i++)
		{
			boolean add = charSet.add(inputArray[i]);
			if(!add)
				dupCharSet.add(inputArray[i]);	
		}
		
		if(dupCharSet.size()!= 0) {
			System.out.println("\nUnique characters ");
		for(Character s : charSet)
			System.out.print(s);
		System.out.println("\nDuplicate character in the string are/is \n");
		for(Character s : dupCharSet)
			System.out.print(s);
	}
		else
			System.out.println("No duplicate variables");
}
}