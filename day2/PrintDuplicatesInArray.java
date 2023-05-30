package testLeafAssignmets.week1.day2;

import java.util.Arrays;

//Program to print numbers 
public class PrintDuplicatesInArray {
public static void main(String[] args) {
	//input array
		int[] arr = {1,2,3,4,1,2,3,5,6,6,6,6,3,3};
		int count =0;
		//Array sorting - arr={1,1,2,2,3,3,3,3,4,5,6,6,6}
		Arrays.sort(arr);
		//Creating an array and inserting values based on maximum value in array 1 [temp={1,2,3,4,5,6,0,0,0,0,0,0,0}]
		int[] temp = new int[arr.length];
		int number = arr[0];
		for(int i =0; i<arr[arr.length-1];i++)
		{
			temp[i] = number;
			number++;
		}
		//Comparing elements from temp array with arr and incrementing the counter value based on the element duplication in array 1
		for(int i=0;i<temp.length;i++)
		{	count =0;
			for(int j=0;j<arr.length;j++)
			{
				if(temp[i] >0)
				{
					if(temp[i] == arr[j])
						count++;
				}
				else
					break;
			}
			if(count>1)
			{
				System.out.println(temp[i]);
			}
		}
		}
		}
