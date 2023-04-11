package day6.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("http://leaftaps.com/opentaps");
		cd.findElement(By.xpath("//p[@class='top']//input")).sendKeys("demoSalesManager");
		cd.findElement(By.xpath("//input[@id='username']/following::input")).sendKeys("crmsfa");
		cd.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
		cd.findElement(By.xpath("//a[contains(text(),'CRM')]//parent::div")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//a[text()='Contacts']")).click();
		cd.findElement(By.xpath("(//a[text()='Find Contacts']/preceding::a)[32]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("(//span[text()='First name']/following::input)[1]")).sendKeys("John");
		cd.findElement(By.xpath("(//span[text()='Last name']/following::input)[1]")).sendKeys("Stewart");
		cd.findElement(By.xpath("//input[contains(@id,'createContactForm')]")).sendKeys("Selenium Automation");		
		cd.findElement(By.xpath("//textarea[@class='inputBox'][1]")).sendKeys("John works for Selenium Automation");
		cd.findElement(By.xpath("(//span[text()='E-Mail Address']/following::input)[1]")).sendKeys("john.stewart@gmail.com");
		Select state = new Select(cd.findElement(By.xpath("//select[contains(@id,'StateProvince')]")));
				state.selectByValue("WI");			
		cd.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//a[text()='Deactivate Contact']/preceding-sibling::a")).click();
		cd.findElement(By.xpath("//span[@class='tableheadtext']/following::textarea")).clear();
		cd.findElement(By.xpath("//textarea[contains(@id,'importantNote')]")).sendKeys("Please note John works for Automation only");
		cd.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title = cd.getTitle();
		System.out.println(title);
	}
}
