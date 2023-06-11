package testLeafAssignments.week3.day1;

import java.util.Scanner;

//Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber

public class Students {
	public void getStudentInfo(){
		System.out.println("Searching with filters is more easy... ");
	}
	public void getStudentInfo(int studentId){
		if(studentId == 55 )
			System.out.println("\nStudent name : Yuvasree\nDepartment : IT ");
		else if(studentId == 54 )
			System.out.println("\nStudent name : Vinoth\nDepartment : CSE ");
		else
			System.out.println("No record found");
		
	}
	public void getStudentInfo(int studentId,String name){
		if(studentId == 55 && name =="Yuvasree" )
			System.out.println("\nDepartment : IT ");
		else if(studentId == 54 && name== "Vinoth")
			System.out.println("\nDepartment : CSE ");
		else if(studentId == 52 && name == "Vandhana")
			System.out.println("\nDepartment : IT");
		else
			System.out.println("No record found");
	}
	public void getStudentInfo(String eMail,long phoneNumber){
		if(eMail == "vandhana@gmail.com" && phoneNumber ==654789123 )
			System.out.println("\nDepartment : IT ");
		else if(eMail == "nandhitha@gmail.com" && phoneNumber ==987654321 )
			System.out.println("\nDepartment : CSE ");
		else if(eMail == "vamsiKrishnan@gmail.com" && phoneNumber ==879456123 )
			System.out.println("\nDepartment : IT");
		else
			System.out.println("No record found");
	}
	public static void main(String[] args) {
		Students studObj =new Students();
		studObj.getStudentInfo();
		System.out.println("\nFetching datas with student Id : 55");
		studObj.getStudentInfo(55);
		System.out.println("\nFetching datas with student Id : 52 and Name : Vandhana");
		studObj.getStudentInfo(52, "Vandhana");
		System.out.println("\nFetching datas with student Email Id : nandhitha@gmail.com and Mobile number : 987654321");
		studObj.getStudentInfo("nandhitha@gmail.com", 987654321);
	}

}
