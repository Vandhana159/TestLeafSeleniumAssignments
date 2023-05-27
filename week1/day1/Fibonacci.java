package testLeafAssignmets.week1.day1;
//a series of numbers in which each number ( Fibonacci number ) is the sum of the two preceding numbers.
//Ex.0  1  1  2  3  5  8  13  21  34  55  89  144
public class Fibonacci {
	public static void main(String[] args) {
		//Initializing 3 input variables
		int firstNumber = 0, secondNumber = 1,sum=0;
		//Print first number a
		System.out.println(firstNumber+"\n"+secondNumber);
		//Set iterate condition
		for(int i = 1; i <= 11;i++)
		{	//Add first and second number assign to sum
			sum = firstNumber+secondNumber;
			//Assign second number to the first number
			firstNumber = secondNumber;
			//Assign sum to the second number
			secondNumber = sum;
			//Print sum
			System.out.println(sum);
		}
		
	}

}