package day4.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTapsCreateLead {

	public static void main(String[] args) {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("http://leaftaps.com/opentaps/control/login");
		cd.findElement(By.id("username")).sendKeys("DemoCsr");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Leads")).click();
		cd.findElement(By.linkText("Create Lead")).click();
		cd.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf.Org");
		cd.findElement(By.id("createLeadForm_firstName")).sendKeys("Padmavathi Jahnavi");
		cd.findElement(By.id("createLeadForm_lastName")).sendKeys("Aradhyula");
		cd.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("jahnavi.aradhyula5@gmail.com");
		cd.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9884653533");
		cd.findElement(By.name("submitButton")).click();
	}
}