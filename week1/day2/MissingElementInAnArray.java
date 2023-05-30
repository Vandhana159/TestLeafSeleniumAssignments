package testLeafAssignmets.week1.day2;

import java.util.Arrays;

/* Execution details with sample input
 * nums[] = {11,25,23,15,18,4,9,3,27}
 * arr1[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27}
 * arr2[] = {3,4,9,11,15,18,23,25,27,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
 * num1[] = {0,0,3,4,0,0,0,0,9,0,11,0,0,0,15,0,0,18,0,0,0,0,23,0,25,0,27}
 */
public class MissingElementInAnArray {
	public static void main(String[] args) {
		//Array declaration
		int[] nums = {11,25,23,15,18,4,9,3,27};
		//Sort the array
		Arrays.sort(nums);
		int count = 1;
		//Finding the maximum digit in the sorted array and assigning it as length for 2 new arrays
		int length = nums[nums.length-1];
		System.out.println("length"+length);
		int[] arr1 = new int[length];
		int[] arr2 = new int[length];
		//Adding value into arr1 using for loop from 1 to (length of arr1 - 1)
		//Stores values from 1,2,.....(
		for(int i=0; i<arr1.length;i++)
		{
			arr1[i] = count;
			count++;
			}
		//Creating an array and adding value into it using for loop from 0th index to (length of nums-1) 
		//Remaining index values will be 0.
		int[] num1 = new int[length];
		for(int i=0; i<nums.length;i++)
		{
			num1[i] = nums[i];
		}	
		for(int i = 0; i<num1.length;i++)
		{
			for(int j=0; j<num1.length;j++)
			{
				//Comparing arr1 array and num1 array if same insert the value at i-th position in arr2 array
				if(arr1[i] == num1[j])
				{	
					arr2[i] = arr1[i];
					break;
				}
				//If element doesn't present insert 0 at i-th position in arr2 array
				else if(arr1[i] != num1[j])
					{
					arr2[i] = 0;
			}}
		}
		System.out.println("Missing Elements in the array are");
		//Iterate arr2 array 
		for(int i = 0; i<arr2.length;i++)
		{
			//If the element in the i-th position of arr2 array contains 0 value print the element as missing from arr1 of i-th position
			if(arr2[i]==0)
			{
				System.out.println(arr1[i]);
			}
		}
		}
	}
