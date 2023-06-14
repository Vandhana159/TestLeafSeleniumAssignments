package testLeafAssignmets.week3.day2.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * Problem ::There will be running number between 1 to 10 One of the unique number will be missing Find the missing number
 */
public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,4,6,7,8,10};
		Set<Integer> intSet = new TreeSet<Integer>();
		for(int i=0; i <nums.length; i++)
		{
			intSet.add(nums[i]);
		}
		List<Integer> intList = new LinkedList<Integer>();
		intList.addAll(intSet);
		//System.out.println(intList);
		for(int i=0; i <intList.size(); i++)
		{
			if(i!= (intList.size()-1))
		   if(Math.abs(intList.get(i) - intList.get(i+1))!=1)
			   {
			   System.out.println(intList.get(i)+1);
			   }
		}
	}
}
