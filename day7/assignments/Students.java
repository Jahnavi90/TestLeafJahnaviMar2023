package day7.assignments;

public class Students {
	
	public int getStudentInfo(int id) {
			return id;
		}
	public void getStudentInfo() {
			int id=234;
			String name="Jahnavi";
			System.out.println("The name of the student with ID "+id+" is "+name);
		}
	public String getStudentInfo(String email, String phoneNumber) {
		return email+"\n"+phoneNumber;
		}
	public static void main(String[] args) {
		Students deets = new Students();
		
		System.out.println(deets.getStudentInfo(5000669));
		deets.getStudentInfo();
		System.out.println(deets.getStudentInfo("jaradhyula@gmail.com", "9884653533"));
	}

}
