package day5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
		cd.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		cd.findElement(By.name("phoneNumber")).sendKeys("9884653533");
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 WebElement leadId = cd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		 String Leadno = leadId.getText();
		 leadId.click();
		cd.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		cd.findElement(By.linkText("Find Leads")).click();
		cd.findElement(By.name("id")).sendKeys(Leadno);
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String recMsg = cd.findElement(By.xpath("//div[text()='No records to display']")).getText();
			if (recMsg.contains("No records to display")){
				System.out.println("Record deleted successfully");
			}else {
				System.out.println("Record is not deleted successfully");
			}
			
		cd.close();
			
	}

}
