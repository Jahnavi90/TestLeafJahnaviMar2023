package day2.assignments;

public class CheckIfTheNumberIsPositiveOrNegative {
	
	public static void main(String[] args) {
		int num = 75;
		if(num<0) {
		System.out.println("The number "+num+" is Negative");
	}else if(num>0){
		System.out.println("The number "+num+" is Positive");
	}else {
		System.out.println("The number "+num+" is neither positive nor negative");
	}
}
}
