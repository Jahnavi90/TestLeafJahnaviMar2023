package day2.assignments;

public class Mobile {

	public static void main(String[] args) {
		
		String mobileBrandName = "Motorola";
		char mobileLogo = 'M';
		short noOfMobilePiece = 25;
		int modelNumber = 60;
		long mobileIMEINumber = 675743241567890L;
		float mobilePrice = 15999.75f;
		boolean isDamaged = false;
		System.out.println("My mobile's brand is "+mobileBrandName+"\n"
				+ "My mobile's logo is "+mobileLogo+"\n"
				+ "The no of pieces of my mobile left in the market are "+noOfMobilePiece+"\n"
				+ "My Mobile's Brand Name is MotoG"+modelNumber+"\n"
				+ "My Mobile's IMEI number is "+mobileIMEINumber+"\n"
				+ "My Mobile's price is Rs."+mobilePrice+"\n"
				+ "Is my mobile phone damaged? "+isDamaged);
	}
}
