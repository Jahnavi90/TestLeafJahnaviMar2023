package day13.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestNG_SalesForce_TomoDate {
	
@Test
	public void testNG_SalesForce2() throws InterruptedException {
		ChromeOptions ntf = new ChromeOptions();
		ntf.addArguments("--disable-notifications");
		ChromeDriver cd  = new ChromeDriver(ntf);
		cd.manage().window().maximize();
		cd.get("https://login.salesforce.com");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cd.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		cd.findElement(By.id("password")).sendKeys("Leaf@123");
		cd.findElement(By.id("Login")).click();
		cd.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//button[text()='View All']")).click();
		cd.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		WebElement Opportunities = cd.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		cd.executeScript("arguments[0].click()", Opportunities);
		cd.findElement(By.xpath("//div[text()='New']")).click();
		cd.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[text()='20']")).click();
		cd.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String snag = cd.findElement(By.xpath("//div[@class='fieldLevelErrors']")).getText();
			if(snag.contains ("Review the following fields")){
					System.out.println("Error message has appeared: "+"\n"	+snag);
			}else {
				System.out.println("Warning has not appeared");
			}
		cd.close();
	}

}
