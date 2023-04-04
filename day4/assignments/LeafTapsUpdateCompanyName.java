package day4.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LeafTapsUpdateCompanyName {

	public static void main(String[] args) {
		EdgeDriver ed = new EdgeDriver();
		ed.manage().window().maximize();
		ed.get("http://leaftaps.com/opentaps/control/login");
		ed.findElement(By.id("username")).sendKeys("DemoCsr");
		ed.findElement(By.id("password")).sendKeys("crmsfa");
		ed.findElement(By.className("decorativeSubmit")).click();
		ed.findElement(By.linkText("CRM/SFA")).click();
		ed.findElement(By.linkText("Leads")).click();
		ed.findElement(By.linkText("Create Lead")).click();
		ed.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf.Org");
		ed.findElement(By.id("createLeadForm_firstName")).sendKeys("Padmavathi Jahnavi");
		ed.findElement(By.id("createLeadForm_lastName")).sendKeys("Aradhyula");
		ed.findElement(By.name("submitButton")).click();
		ed.findElement(By.linkText("Edit")).click();
		WebElement Update = ed.findElement(By.id("updateLeadForm_companyName"));
			Update.clear();				
			Update.sendKeys("Org.TestLeaf");
		//ed.findElement(By.id("updateLeadForm_companyName")).sendKeys("Org.TestLeaf");
		ed.findElement(By.name("submitButton")).click();
	}

}
