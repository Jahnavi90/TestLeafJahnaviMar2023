package day6.assignments;

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
		cd.findElement(By.xpath("//p[@class='top']//input")).sendKeys("demoSalesManager");
		cd.findElement(By.xpath("//input[@id='username']/following::input")).sendKeys("crmsfa");
		cd.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
		cd.findElement(By.xpath("//a[contains(text(),'CRM')]//parent::div")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("(//ul[@class='sectionTabBar']//a)[2]")).click();
		cd.findElement(By.xpath("//a[text()='Request Catalog ']/preceding::a[text()='Find Leads']")).click();
		cd.findElement(By.xpath("(//em[@class='x-tab-left']/span)[2]")).click();
		cd.findElement(By.xpath("(//div[contains(@class,'x-plain-body')]//input)[13]")).sendKeys("9884653533");
		cd.findElement(By.xpath("(//em[@unselectable='on']/button)[6]")).click();
		 WebElement leadId = cd.findElement(By.xpath("(//div[contains(@class,'col-partyId')]/a)[1]"));
		 String Leadno = leadId.getText();
		 leadId.click();
		 System.out.println(Leadno);
		cd.findElement(By.xpath("(//a[@class='subMenuButton']/following-sibling::a)[3]")).click();
		cd.findElement(By.xpath("(//a[text()='Merge Leads']/preceding::a)[33]")).click();
		cd.findElement(By.xpath("(//label[text()='Lead ID:']/following::input)[1]")).sendKeys(Leadno);
		cd.findElement(By.xpath("//button[text()='Find Leads']/parent::em")).click();
		
		String recMsg = cd.findElement(By.xpath("//div[text()='No records to display']")).getText();
			if (recMsg.contains("No records to display")){
				System.out.println("Record deleted successfully");
			}else {
				System.out.println("Record is not deleted successfully");
			}
			
		//cd.close();
			
	}

}
