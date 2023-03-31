package day2.assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		int range=8;
		int firstNum=0;
		int secNum=1;
		int sum;
		System.out.println(firstNum);
		System.out.println(secNum);
		for (int i = 1; i < range; i++) { //10 <= 10 // 8<8
			sum=firstNum+secNum; // 0+1, 1+1, 1+2 2+3, 3+5, 5+8, 8+13
			firstNum=secNum;
			secNum=sum;
		System.out.println(sum);
		}
	}
}