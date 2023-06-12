package testLeafAssignmets.week3.day2.string;
//Build a logic to reverse the even position words (output: I ma a erawtfos tester)
public class ReverseEvenWords {

	public static void main(String[] args) {
		 String sentence="I am a software tester";
	     String[] words = sentence.split(" ");
	     for(int i=0;i<words.length;i++) {
	         if(i%2 == 0)
	        	 System.out.print(words[i]+" ");
	         else
	         {
	        char[] nameArray = words[i].toCharArray();
	     	for(int j = (nameArray.length-1) ; j >= 0; j--)
	     	{
	     		System.out.print(nameArray[j]);
	     	}
	     	System.out.print(" ");
	     }
	}
}
}