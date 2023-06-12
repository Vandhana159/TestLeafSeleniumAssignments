package testLeafAssignmets.week3.day2.collections;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * Pseudo code 
 * a) Use the declared String text as input
	String text = "We learn java basics as part of java sessions in java week1";
 *
 *Output= We learn java basics as part of sessions in week1
 */
public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] words = text.split(" ");
		Set<String> wordSet = new LinkedHashSet<String>();
		for(int i = 0; i < words.length; i++) {
		wordSet.add(words[i]);
		}
		for(String word : wordSet)
			System.out.print(word+" ");
		}
	}

