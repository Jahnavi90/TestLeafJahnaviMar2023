package day5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("http://leaftaps.com/opentaps");
		cd.findElement(By.id("username")).sendKeys("demoSalesManager");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Contacts")).click();
		cd.findElement(By.linkText("Create Contact")).click();
		cd.findElement(By.id("firstNameField")).sendKeys("John");
		cd.findElement(By.id("lastNameField")).sendKeys("Stewart");
		cd.findElement(By.id("createContactForm_departmentName")).sendKeys("Selenium Automation");
		cd.findElement(By.name("description")).sendKeys("John works for Selenium Automation");
		cd.findElement(By.id("createContactForm_primaryEmail")).sendKeys("john.stewart@gmail.com");
		Select state = new Select(cd.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
				state.selectByVisibleText("New York");
		cd.findElement(By.name("submitButton")).click();
		cd.findElement(By.linkText("Edit")).click();
		cd.findElement(By.name("description")).clear();
		cd.findElement(By.id("updateContactForm_importantNote")).sendKeys("Please note John works for Automation only");
		cd.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title = cd.getTitle();
		System.out.println(title);
	}
}
