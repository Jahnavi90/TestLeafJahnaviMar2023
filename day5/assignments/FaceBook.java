package day5.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://en-gb.facebook.com/");
		cd.findElement(By.linkText("Create new account")).click();
		cd.findElement(By.name("firstname")).sendKeys("Jason");
		cd.findElement(By.name("lastname")).sendKeys("Huggins");
		cd.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("7799299349");
		cd.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("practice");
		
		WebElement findElement = cd.findElement(By.id("day"));
				Select date = new Select(findElement);
				date.selectByIndex(6);
			Select month = new Select(cd.findElement(By.id("month")));
				month.selectByVisibleText("Jun");
			Select year = new Select(cd.findElement(By.id("year")));
				year.selectByValue("1990");
				
		cd.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		Thread.sleep(5000);
		
			
			
				
				
	}

}
