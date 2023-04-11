package day8.assignments;

public abstract class MultipleLanguage implements Language,TestTool{
	public void python() {
		System.out.println("Implemented method");
	}
	public abstract void ruby();
}
