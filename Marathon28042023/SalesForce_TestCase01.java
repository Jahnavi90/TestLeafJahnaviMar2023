package Marathon28042023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForce_TestCase01 extends BaseClass {

	@BeforeTest
	public void setData() {
		ExcelSheet = "TestCase01";
	}

	@Test(dataProvider = "SalesForceExcelIntegration")
	public void SalesForceTC01(String question, String details) throws InterruptedException {
		WebElement searchBox = cd.findElement(By.xpath("//input[@class='slds-input']"));
		searchBox.click();
		Thread.sleep(1000);
		searchBox.sendKeys("Content");
		Thread.sleep(1000);
		cd.findElement(By.xpath("//a[@class='slds-text-heading_small']")).click();
		Thread.sleep(2000);
		// cd.findElement(By.xpath("(//button[text()='Dismiss'])[2]")).click();
		WebElement chatter = cd.findElement(By.xpath("//span[text()='Chatter']"));
		cd.executeScript("arguments[0].click()", chatter);
		Thread.sleep(2000);
		String title = cd.getTitle();
		//System.out.println(title);
		if (title.contains("Chatter")) {
			System.out.println("The user is on the right page");
		} else {
			System.out.println("The user is not on the right page");
		}
		cd.findElement(By.xpath("//span[text()='Question']")).click();
		cd.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(question);
		cd.findElement(By.xpath("//div[contains(@class,'slds-rich-text-area')]")).sendKeys(details);
		cd.findElement(By.xpath("//button[contains(@class,'cuf-publisherShareButton')]")).click();
		Thread.sleep(2000);
		String verify1 = cd.findElement(By.xpath("//span[@class='uiOutputText']/parent::div")).getText();
		Thread.sleep(2000);
		if (verify1.contains(question)) {
			System.out.println("The question has appeared in the Salesforce App");
		} else {
			System.out.println("Please check again");
		}
	}
}
