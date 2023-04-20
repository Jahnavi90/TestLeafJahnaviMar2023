package day14.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass_1 {
		
	public ChromeOptions ntf;
	public ChromeDriver cd;
		
@BeforeMethod
		public  void beforeMethod() throws InterruptedException {
		ntf = new ChromeOptions();
		ntf.addArguments("--disable-notifications");	
		cd = new ChromeDriver(ntf);
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
	}

@AfterMethod
	public void afterMethod() throws InterruptedException {
	Thread.sleep(2000);
	cd.close();
}

}
