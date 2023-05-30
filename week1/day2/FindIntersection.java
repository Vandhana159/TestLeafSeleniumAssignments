package testLeafAssignmets.week1.day2;
/*
 * Pseudo Code
 * a) Declare An array for {3,2,11,4,6,7};	 
 * b) Declare another array for {1,2,8,4,9,7};
 * c) Declare for loop iterator from 0 to array length
 * d) Declare a nested for another array from 0 to array length
 * e) Compare Both the arrays using a condition statement
 *  f) Print the first array (should match item in both arrays)
 */
public class FindIntersection {
	public static void main(String[] args) {
		int[] num_set1 = {3,2,11,4,6,7};
		int[] num_set2 = {1,2,8,4,9,7};
		FindIntersection findObj = new FindIntersection();
		findObj.findIntersection(num_set1,num_set2);
		}
	
	public void findIntersection(int[] num_set1, int[] num_set2)
	{
			System.out.println("Numbers found in both array are ");
		for (int i = 0; i < num_set1.length; i++) {
			for (int j = 0; j < num_set2.length; j++) {
				
				if(num_set1[i] == num_set2[j] )
				{ 
					System.out.println(num_set1[i]);
				}
			}
		}
	}
	}

