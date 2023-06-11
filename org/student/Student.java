package org.student;

import org.department.Department;

public class Student extends Department{
	public void studentName() {
		System.out.println("Student Name : Vandhana M S");
	}
	public void studentDept() {
		System.out.println("Student Department : IT");
	}
	public void studentId() {
		System.out.println("Student Id : 5113122055052");
	}
	public static void main(String[] args) {
		Student studentObject = new Student();
		studentObject.collegeCode();
		studentObject.collegeName();
		studentObject.collegeRank();
		studentObject.deptName();
		studentObject.studentName();
		studentObject.studentId();
		studentObject.studentDept();
	}
}
