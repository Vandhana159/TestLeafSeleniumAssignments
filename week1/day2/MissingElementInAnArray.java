package testLeafAssignmets.week1.day2;

import java.util.Arrays;
public class MissingElementInAnArray {
	public static void main(String[] args) {
	int[] arr = {1,2,3,7,6,8,9};
	Arrays.sort(arr);
	int diff = 0,count = 1;
	
	for(int i = 0; i<arr.length-1;i++)
	{
		diff=arr[i+1]-arr[i];
		System.out.println(arr[i]);
		while(diff>1)
		{
			System.out.println(arr[i]+count);
			diff--;
			count++;
		}
		count=1;
	}
	System.out.println(arr[arr.length-1]);
}
}
