package day2.assignments;

public class Factorial {

	public static void main(String[] args) {
	int a=5;
	int fact=1;
	for (int i = 1; i <= a; i++) { // 
		fact=fact * i;
		System.out.println("The factorial of "+a+" is "+fact);
		}
	
	}
}
