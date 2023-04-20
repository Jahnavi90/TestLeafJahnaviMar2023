package day13.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForce_CreateOpp {

	public static void main(String[] args) throws InterruptedException {
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
		String OppNameFinal = cd.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
			if(OppNameFinal.equals("Salesforce Automation by Jahnavi")) {
				System.out.println("Opportunity Name is verified and is the correct value");
			}else {
				System.out.println("Opportunity Name is wrong, please check");
			}
		Thread.sleep(2000);
		cd.close();

	}

}
