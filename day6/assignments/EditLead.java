package day6.assignments;

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
		cd.findElement(By.xpath("//p[@class='top']//input")).sendKeys("demoSalesManager");
		cd.findElement(By.xpath("//input[@id='username']/following::input")).sendKeys("crmsfa");
		cd.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
		cd.findElement(By.xpath("//a[contains(text(),'CRM')]//parent::div")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("(//ul[@class='sectionTabBar']//a)[2]")).click();
		cd.findElement(By.xpath("//a[text()='Request Catalog ']/preceding::a[text()='Find Leads']")).click();
		//cd.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Padmavathi Jahnavi");
		cd.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Padmavathi Jahnavi"); 
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();
		cd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		Thread.sleep(2000);
			String title = cd.findElement(By.xpath("//div[text()='View Lead']")).getText();
				if (title.equals("View Lead")){
				System.out.println("Title verified successfully");
					}else {
				System.out.println("Page did not load to the required title");
					}
		cd.findElement(By.xpath("(//a[text()='Qualify Lead']/following-sibling::a)[1]")).click();
		Thread.sleep(2000);
		WebElement edit = cd.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		String oldName = edit.getText();
				edit.clear();				
				edit.sendKeys("TestLeaf Systems");
		cd.findElement(By.xpath("(//td[@colspan=4]/input)[1]")).click();
		//logic for verifying the changed name
		String newName = cd.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
			if (oldName.equals(newName)) {
				System.out.println("The name hasn't been updated");
			}else {
				System.out.println("The name has been updated");
			}
		Thread.sleep(3000);
		cd.close();
	}
}
