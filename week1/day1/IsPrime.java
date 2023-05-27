package testLeafAssignmets.week1.day1;
//Print if the given number is prime  -- number should be greater than 1 and has 2 divisible numbers 1 and itself.
public class IsPrime {
	public static void main(String[] args) {
		int number=98, divisibleFactors = 0;
		if(number > 1)
		{
			for(int i =1; i <= number;i++)
			{
				if(number%i == 0)
					divisibleFactors++;
		}
			if(divisibleFactors  == 2)
				System.out.println(number+" is a prime number");
			else
				System.out.println(number+" is a not prime number");
		}
		else
		{
			System.out.println("Invalid number ");
		}
	}
}
