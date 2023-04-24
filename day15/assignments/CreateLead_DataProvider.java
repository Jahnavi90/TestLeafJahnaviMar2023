package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead_DataProvider extends BaseClass {
	
@DataProvider(name="create")
	public String[][] createLead(){
	String[][] create = new String[3][4];
		create[0][0] = "McKinsey";
		create[0][1] = "Kiara";
		create[0][2] = "Praveen";
		create[0][3] = "9897980091";
		
		create[1][0] = "Earnst & Young";
		create[1][1] = "Meena";
		create[1][2] = "Sadhwa";
		create[1][3] = "9086576788";
		
		create[2][0] = "Google";
		create[2][1] = "Jahnavi";
		create[2][2] = "Sairam";
		create[2][3] = "9834564578";
		
		return create;
		
}

@Test(dataProvider="create")
	public void runCreateLead(String cName, String fName, String lName, String phNum) {

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNum);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cName)) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
	}
}
