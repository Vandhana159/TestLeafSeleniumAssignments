package testLeafAssignmets.week3.day2.string;
/*
Pseudo Code
* Declare String Input as Follow
* String test = "changeme";
* a) Convert the String to character array
* b) Traverse through each character (using loop)
* c)find the odd index within the loop (use mod operator)
* d)within the loop, change the character to uppercase, if the index is odd else don't change
*/
public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String test = "changeme";
		char[] cArray = test.toCharArray();
		for(int i=0; i<cArray.length; i++)
		{   
			if((i%2) != 0)
			 {
				cArray[i] = Character.toUpperCase(cArray[i]);
			 }
			System.out.print(cArray[i]);
		}
	}

}
