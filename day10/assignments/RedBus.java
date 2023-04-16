package day10.assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cd.get("https://www.redbus.in/");
		cd.findElement(By.id("src")).sendKeys("Chennai");
		Thread.sleep(3000);
		cd.findElement(By.xpath("//li[@class='selected']")).click();
		cd.findElement(By.id("dest")).sendKeys("Bangalore");
		Thread.sleep(3000);
		cd.findElement(By.xpath("//li[@class='selected']")).click();
		Thread.sleep(3000);
		cd.findElement(By.id("onward_cal")).click();
		Thread.sleep(3000);
		cd.findElement(By.xpath("(//td[@class='wd day'])[1]")).click();
		Thread.sleep(3000);
		cd.findElement(By.id("search_btn")).click();
		Thread.sleep(5000);
		cd.findElement(By.xpath("//div[@class='close-primo']")).click();
		Thread.sleep(3000);
		String srchResult = cd.findElement(By.xpath("//span[@class='w-60 d-block d-found']")).getText();
		System.out.println(srchResult);
		Thread.sleep(3000);
		WebElement sleeper = cd.findElement(By.xpath("//label[text()='SLEEPER']"));
		cd.executeScript("arguments[0].click()", sleeper);
		Thread.sleep(3000);
		String secBus = cd.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
		System.out.println(secBus);
		Thread.sleep(3000);
		String title = cd.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		cd.close();
	}	

}
