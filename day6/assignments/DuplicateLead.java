package day6.assignments;

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
		cd.findElement(By.xpath("//p[@class='top']//input")).sendKeys("demoSalesManager");
		cd.findElement(By.xpath("//input[@id='username']/following::input")).sendKeys("crmsfa");
		cd.findElement(By.xpath("(//form[@id='login']//input)[3]")).click();
		cd.findElement(By.xpath("//a[contains(text(),'CRM')]//parent::div")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("(//ul[@class='sectionTabBar']//a)[2]")).click();
		cd.findElement(By.xpath("//a[text()='Request Catalog ']/preceding::a[text()='Find Leads']")).click();
		cd.findElement(By.xpath("(//span[@class='x-tab-strip-inner']/span)[3]")).click();
		cd.findElement(By.xpath("(//div[@class='x-form-item x-tab-item']//input)[5]")).sendKeys("jahnavi.aradhyula5@gmail.com");
		cd.findElement(By.xpath("//button[text()='Find Leads']")).click();		
		Thread.sleep(3000);
		WebElement fname = cd.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		 String name = fname.getText();
		 fname.click();	 
		cd.findElement(By.xpath("//a[text()='Qualify Lead']/preceding-sibling::a")).click();
		Thread.sleep(3000);
			String title = cd.findElement(By.xpath("//div[@class='frameSectionExtra']/preceding-sibling::div")).getText();
				if (title.equals("Duplicate Lead")){
				System.out.println("Title verified successfully");
					}else {
				System.out.println("Page did not load to the required title");
					}
		cd.findElement(By.xpath("(//td[@colspan=4]/input)[3]")).click();
		Thread.sleep(3000);
		String fname1 = cd.findElement(By.xpath("(//span[text()='Last name']/preceding::span)[12]")).getText();
		if (name.equals(fname1)){	
			System.out.println("Duplicate created successfully");
		}else {
			System.out.println("The name is different and duplicate is not successfully created");
		}
		Thread.sleep(2000);
//		cd.close();
	}
}
