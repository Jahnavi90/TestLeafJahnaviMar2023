package org.student;

import org.department.Department;

public class Student extends Department{
	
	public void studentName() {
		System.out.println("Student Name from Child");
	}
	public void studentDept() {
		System.out.println("Student Department from Child");
	}
	public void studentID() {
		System.out.println("Student ID from Child");
	}
	public static void main(String[] args) {
		Student std = new Student();
		
		std.collegeName();
		std.collegeCode();
		std.collegeRank();
		std.deptName();
		std.studentName();
		std.studentID();
		std.studentDept();

	}

}
