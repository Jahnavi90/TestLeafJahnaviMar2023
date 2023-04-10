package org.system;

public class Desktop extends Computer{
	
	public void desktopSize() {
		System.out.println("Desktop Size from child");
	}

	public static void main(String[] args) {
		Desktop singleinh = new Desktop();
		singleinh.computerModel();
		singleinh.desktopSize();

	}

}
