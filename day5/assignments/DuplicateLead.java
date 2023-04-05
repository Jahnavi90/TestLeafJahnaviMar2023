package day5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cd.get("http://leaftaps.com/opentaps/control/login");
		cd.findElement(By.id("username")).sendKeys("demosalesManager");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Leads")).click();
		cd.findElement(By.linkText("Find Leads")).click();
		cd.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[3]")).click();
		cd.findElement(By.name("emailAddress")).sendKeys("jahnavi.aradhyula5@gmail.com");
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();		
		Thread.sleep(3000);
		WebElement fname = cd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		 String name = fname.getText();
		 fname.click();	 
		cd.findElement(By.linkText("Duplicate Lead")).click();
		Thread.sleep(3000);
			String title = cd.findElement(By.id("sectionHeaderTitle_leads")).getText();
				if (title.equals("Duplicate Lead")){
				System.out.println("Title verified successfully");
					}else {
				System.out.println("Page did not load to the required title");
					}
		cd.findElement(By.name("submitButton")).click();
		String fname1 = cd.findElement(By.id("viewLead_firstName_sp")).getText();
		if (name.equals(fname1)){
			System.out.println("Duplicate created successfully");
		}else {
			System.out.println("The name is different and duplicate is not successfully created");
		}
		cd.close();
	}
}
