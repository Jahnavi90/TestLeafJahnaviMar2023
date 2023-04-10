package day7.assignments;

public class AxisBank extends BankInfo{
	public void deposit() {
		System.out.println("Deposit Amount from Bank is overridden by Axis Bank");
	}
	public static void main(String[] args) {
		AxisBank bnk = new AxisBank();
		bnk.deposit();
		bnk.saving();
		bnk.fixed();

	}

}
