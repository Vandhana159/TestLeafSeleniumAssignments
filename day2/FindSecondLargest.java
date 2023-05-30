package testLeafAssignmets.week1.day2;
import java.util.Arrays;
/*
Pseudo Code:
1) Arrange the array in ascending order
2) Pick the 2nd element from the last and print it
*/
public class FindSecondLargest {
public static void main(String[] args) {
			int[] data = {3,2,11,4,6,7,15,14,18,22,16};
			Arrays.sort(data);
			System.out.println("Second largest number in the array is " +data[data.length-2]);
}
}
