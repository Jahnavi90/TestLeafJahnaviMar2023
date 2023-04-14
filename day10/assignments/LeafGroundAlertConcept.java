package day10.assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundAlertConcept {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://www.leafground.com/alert.xhtml");
		
		cd.findElement(By.xpath("(//div[@class='card']/button)[1]")).click();
		Alert simple_alert = cd.switchTo().alert();
			simple_alert.accept();
		String simple_text = cd.findElement(By.xpath("//span[@id='simple_result']")).getText();
			System.out.println(simple_text);			
			
		cd.findElement(By.xpath("(//div[@class='card']/button)[2]")).click();
		Alert confirm_alert = cd.switchTo().alert();
			confirm_alert.dismiss();
		String confirm_text = cd.findElement(By.xpath("//span[@id='result']")).getText();
			System.out.println(confirm_text);			
			
		cd.findElement(By.xpath("(//h5[contains(text(),' Alert (Simple Dialog)')]/following-sibling::button)[2]")).click();
		cd.findElement(By.xpath("//span[contains(text(),'Dismiss')]")).click();
		Thread.sleep(2000);
		
		cd.findElement(By.xpath("(//button[contains(@class,'ui-button-help')]/span)[1]")).click();
		cd.findElement(By.xpath("(//a[contains(@class,'ui-corner-all')])[2]")).click();	
		
		cd.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		cd.findElement(By.xpath("(//span[contains(text(),'Show')])[5]")).click();
		Alert alert = cd.switchTo().alert();
		alert.sendKeys("Jahnavi");
		alert.accept();
		String confirm_result = cd.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(confirm_result);
		Thread.sleep(2000);
		
		cd.findElement(By.xpath("//button[contains(@class,'ui-button-danger')]")).click();
		cd.findElement(By.xpath("//button[contains(@class,'ui-confirmdialog-yes')]")).click();
		Thread.sleep(2000);
		
		cd.findElement(By.xpath("(//span[contains(text(),'Show')])[6]")).click();
		cd.findElement(By.xpath("//a[contains(@class,'maximize ')]")).click();
		Thread.sleep(2000);
		cd.close();

	}

}
