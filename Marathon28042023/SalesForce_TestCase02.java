package Marathon28042023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForce_TestCase02 extends BaseClass {

	@BeforeTest
	public void setData() {
		ExcelSheet = "TestCase02";
	}

	@Test(dataProvider = "SalesForceExcelIntegration")
	public void SalesForceTC02(String oppName, String amount) throws InterruptedException {
		cd.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(2000);
		WebElement scroll = cd.findElement(By.xpath("//span[text()='View All Key Deals']"));
		Actions scrollDown = new Actions(cd);
		scrollDown.scrollToElement(scroll).perform();
		Thread.sleep(2000);
		WebElement viewAllKeyFields = cd.findElement(By.xpath("//span[text()='View All Key Deals']"));
		cd.executeScript("arguments[0].click()", viewAllKeyFields);
		Thread.sleep(2000);
		cd.findElement(By.xpath("//div[text()='New']")).click();
		cd.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);
		cd.findElement(By.xpath("//input[@name='Name']")).sendKeys(oppName);
		cd.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("29/04/2023");
		cd.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[1]")).click();
		Thread.sleep(1000);
		cd.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		WebElement dropDown1 = cd.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[2]"));
		cd.executeScript("arguments[0].click()", dropDown1);
		Thread.sleep(1000);
		cd.findElement(By.xpath("//span[text()='New Customer']")).click();
		cd.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input-value')])[3]")).click();
		Thread.sleep(1000);
		cd.findElement(By.xpath("//span[text()='Partner Referral']")).click();
		cd.findElement(By.xpath("//input[@placeholder='Search Campaigns...']")).click();
		Thread.sleep(1000);
		cd.findElement(By.xpath("//span[text()='New Campaign']")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys("New Campaign by Jahnavi");
		cd.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String OppNameFinal = cd.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		Thread.sleep(2000);
		if (OppNameFinal.equals(oppName)) {
			System.out.println("Opportunity Name is verified and is the correct value");
		} else {
			System.out.println("Opportunity Name is wrong, please check");
		}
	}
}
