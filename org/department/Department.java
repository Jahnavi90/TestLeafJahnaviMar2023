package org.department;

import org.college.College;

public class Department extends College{
		
	protected void deptName() {
		System.out.println("Department Name from Parent");
	}
	
	public static void main(String[] args) {
		Department dpt = new Department();
		dpt.collegeCode();
		dpt.collegeName();
		dpt.collegeCode();
		dpt.deptName();

	}

}
