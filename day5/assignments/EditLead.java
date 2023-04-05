package day5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cd.get("http://leaftaps.com/opentaps/control/login");
		cd.findElement(By.id("username")).sendKeys("DemoCsr");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Leads")).click();
		cd.findElement(By.linkText("Find Leads")).click();
		//cd.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Padmavathi Jahnavi");
		cd.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Padmavathi Jahnavi"); 
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();
		cd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		Thread.sleep(2000);
			String title = cd.findElement(By.id("sectionHeaderTitle_leads")).getText();
				if (title.equals("View Lead")){
				System.out.println("Title verified successfully");
					}else {
				System.out.println("Page did not load to the required title");
					}
		cd.findElement(By.linkText("Edit")).click();
		WebElement edit = cd.findElement(By.id("updateLeadForm_companyName"));
		String oldName = edit.getText();
				edit.clear();				
				edit.sendKeys("TestLeaf Systems");
		cd.findElement(By.name("submitButton")).click();
		//logic for verifying the changed name
		String newName = cd.findElement(By.id("viewLead_companyName_sp")).getText();
			if (oldName.equals(newName)) {
				System.out.println("The name hasn't been updated");
			}else {
				System.out.println("The name has been updated");
			}
			
		cd.close();
	}
}
