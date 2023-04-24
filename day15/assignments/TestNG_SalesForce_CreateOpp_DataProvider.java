package day15.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_SalesForce_CreateOpp_DataProvider extends BaseClass_SalesForce{
@DataProvider(name="oppName")
	public String[][] oppName(){
		String[][] oppName = new String[3][1];
			oppName[0][0] = "Salesforce Automation by Murari";
		
			oppName[1][0] = "Salesforce Automation by Pokiri";
		
			oppName[2][0] = "Salesforce Automation by Khaleja";
			
		return oppName;
}
@Test(dataProvider="oppName")
	public void testNG_SalesForce1(String oppName) throws InterruptedException {

		WebElement opporName = cd.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']//input)[3]"));
		opporName.sendKeys(oppName);
		opporName.getText();
		
		cd.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[text()='19']")).click();
		cd.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		cd.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(2000);
		String OppNameFinal = cd.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		Thread.sleep(2000);	
		if(OppNameFinal.equals("Salesforce Automation by Jahnavi")) {
				System.out.println("Opportunity Name is verified and is the correct value");
			}else {
				System.out.println("Opportunity Name is wrong, please check");
			}
	}
}
