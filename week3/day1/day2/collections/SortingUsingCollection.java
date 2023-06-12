package testLeafAssignmets.week3.day2.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//I/p  : {"Google","Microsoft","Zoho","TestLeaf","Maverick","Accenture","Wipro","CTS"}
//O/p :  Zoho Wipro TestLeaf Microsoft Maverick Google CTS Accenture
public class SortingUsingCollection {

	public static void main(String[] args) {
		String[] companyNames = {"Google","Microsoft","Zoho","TestLeaf","Maverick","Accenture","Wipro","CTS"};
		Set<String> comp = new TreeSet<String>();
		for(int i = 0; i<companyNames.length;i++)
		{
			comp.add(companyNames[i]);
		}
		List<String> companyList = new LinkedList<String>();
		companyList.addAll(comp);
		for(int i = companyList.size()-1;i>=0; i--)
			System.out.print(companyList.get(i)+" ");
	}

}
