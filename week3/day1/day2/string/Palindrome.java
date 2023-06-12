package testLeafAssignmets.week3.day2.string;
/*
 * Pseudo Code
 * a) Declare A String value as"madam"
 * b) Declare another String rev value as ""
 * c) Iterate over the String in reverse order
 * d) Add the char into rev
 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
 */
public class Palindrome {

	public static void main(String[] args) {
		String str = "palindrome";
		String reverse = "";
		for(int i=str.length()-1; i >=0;i--)
		{ 
			reverse += str.charAt(i);
		}
		if(str.equalsIgnoreCase(reverse))
			System.out.println("Its a palindrome");
		else
			System.out.println("Its not a palindrome");
	}

}
