package day8.assignments;

public class Automation extends MultipleLanguage {

	public void Java() {
		System.out.println("Java unimplemented");
		
	}

	public void Selenium() {
		System.out.println("Selenium unimplemented");
		
	}

	@Override
	public void ruby() {
		System.out.println("This is Ruby, unimplemented");
		
	}
public static void main(String[] args) {
		Automation auto = new Automation();
		auto.Java();
		auto.python();
		auto.ruby();
		auto.Selenium();

	}
}
