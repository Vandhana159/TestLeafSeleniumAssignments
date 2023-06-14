package testLeafAssignmets.week3.day2.string;
/* Remove duplicates in a sentence without using Set
 * i/p  We learn java basics as part of java sessions in java week1 
 * o/p  We learn java basics as part of sessions in  week1
 */
public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";	
		String[] textArray = text.split(" ");
		for(int i = 0; i<textArray.length;i++) {		
			for(int j = i+1; j<textArray.length;j++) {
		if(textArray[i].equalsIgnoreCase(textArray[j]))
		{
			textArray[j] ="";
		}}}
		for(int i = 0; i<textArray.length; i++)
		{   if(!textArray[i].equals(""))
			System.out.print(textArray[i]+" ");
		}
}
}