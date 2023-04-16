package day10.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--disable-notifications");
		EdgeDriver ed = new EdgeDriver(edgeOptions);
		ed.manage().window().maximize();
		ed.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ed.get("https://in.bookmyshow.com/");
		Thread.sleep(3000);
		ed.findElement(By.xpath("//span[text()='Hyderabad']")).click();
		Thread.sleep(3000);
		String URL = ed.getCurrentUrl();
			if (URL.equals("https://in.bookmyshow.com/explore/home/hyderabad")) {
				System.out.println("On the right page");
			}else {
				System.out.println("The page hasn't loaded yet");
					}
		Thread.sleep(3000);
		//ed.findElement(By.xpath("//div[text()='Refresh']")).click();
		//ed.findElement(By.xpath("(//*[name()='svg' and @xmlns='http://www.w3.org/2000/svg']//*[local-name()='path'])[2]")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).sendKeys("Shaakuntalam");
		Thread.sleep(3000);
		ed.findElement(By.xpath("//strong[text()='Shaakuntalam']")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("//span[text()='3D']")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		Thread.sleep(3000);
		String theatre = ed.findElement(By.xpath("//a[@href='/buytickets/amb-cinemas-gachibowli/cinema-hyd-AMBH-MT/20230416']")).getText();
		System.out.println(theatre);
		Thread.sleep(3000);
		ed.findElement(By.xpath("//div[@data-venue-code='AMBH']/div")).click();
		String parking = ed.findElement(By.xpath("//div[contains(text(),'Parking Facility')]")).getText();
			if(parking.contains("Parking")) {
				System.out.println("Parking facility is available in this venue");
			}else {
				System.out.println("Parking facility is not available in this venue");
			}
		Thread.sleep(3000);
		ed.findElement(By.xpath("//*[name()='svg' and @viewBox='0 0 23 23']")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("//a[@href='/booktickets/AMBH/51854']")).click();
		Thread.sleep(3000);
		ed.findElement(By.id("btnPopupAccept")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("(//ul[@id='popQty']/li)[1]")).click();
		Thread.sleep(3000);
		ed.findElement(By.id("proceed-Qty")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("//a[contains(@onclick,'B_2_029')]")).click();
		Thread.sleep(3000);
		ed.findElement(By.xpath("(//span[@id='btnSTotal_reserve'])[1]")).click();
		Thread.sleep(3000);
		String subTotal = ed.findElement(By.id("PayTotal")).getText();
		System.out.println(subTotal);
		Thread.sleep(3000);
	}

}
