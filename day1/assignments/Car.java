package day1.assignments;

public class Car {
	
	public void driveCar() {
		System.out.println("I drive a Car.");
	}
	public void applyBrake() {
		System.out.println("I apply brakes when required.");
	}
	public void soundHorn() {
		System.out.println("I sound the Horn when required.");
	}
	public void isPuncture() {
		System.out.println("Did my car's front tyre get punctured?");
	}
	public static void main(String[] args) {
		Car assignment1 = new Car();
		assignment1.driveCar();
		assignment1.applyBrake();
		assignment1.soundHorn();
		assignment1.isPuncture();
	}
}
