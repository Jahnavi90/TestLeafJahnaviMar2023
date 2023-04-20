package day14.assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestNG_SalesForce_CreateOpp extends BaseClass_1{
@Test
	public void testNG_SalesForce1( ) throws InterruptedException {

		WebElement oppName = cd.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']//input)[3]"));
		oppName.sendKeys("Salesforce Automation by Jahnavi");
		oppName.getText();
		
		cd.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[text()='19']")).click();
		cd.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		cd.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(2000);
		String OppNameFinal = cd.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
			if(OppNameFinal.equals("Salesforce Automation by Jahnavi")) {
				System.out.println("Opportunity Name is verified and is the correct value");
			}else {
				System.out.println("Opportunity Name is wrong, please check");
			}


	}

}
