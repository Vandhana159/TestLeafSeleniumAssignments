package testLeafAssignmets.week3.day2.collections;
//PrintUniqueCharacter
	/*
	 * Problem
	 * a) Take your name as input
	 * b) Print all unique characters only (any order)
	 * 
	 * Input:  babu
	 * Output: a u 
	 * 
	 */

import java.util.LinkedHashSet;
import java.util.Set;

/*
	 * Psuedocode
	 * 
	 * a) Convert String to Character array
	 * b) Create a new Set -> HashSet
	 * c) Add each character to the Set and if it is already there, remove it
	 * d) Finally, print the set
	 * 
	 */
public class PrintUniqueCharacter {

	public static void main(String[] args) {
	   String input = "Vandhana";
	   char[] name = input.toCharArray();
	   Set<Character> setName = new LinkedHashSet<Character>();
	   System.out.println("Input word is "+input);
	   System.out.println("Unique characters are ");
	   for(int i = 0 ; i < name.length; i++)
	   setName.add(name[i]);

	   for(Character uniq : setName)
		   System.out.print(uniq+" ");
	}

}
