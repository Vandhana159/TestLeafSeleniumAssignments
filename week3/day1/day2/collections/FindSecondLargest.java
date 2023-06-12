package testLeafAssignmets.week3.day2.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/*
 * Pseudo Code: 
 * a) Create a empty Set Using TreeSet
 * b) Declare for loop iterator from 0 to data.length and add into Set 
 * c) converted Set into List
 * d) Print the second last element from List 
 */
public class FindSecondLargest {
	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		Set<Integer> intSet = new TreeSet<Integer>();
		for(int i = 0; i<data.length; i++)
		{
			intSet.add(data[i]);
		}
		List<Integer> intList = new LinkedList<Integer>();
		intList.addAll(intSet);
			System.out.println(intList.get(intList.size()-2));
	}
}
