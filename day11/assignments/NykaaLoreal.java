package day11.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NykaaLoreal {

		public static void main(String[] args) throws InterruptedException {
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("--disable-notifications");
			ChromeDriver cd = new ChromeDriver(opts);
			cd.manage().window().maximize();
			cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			cd.get("https://www.nykaa.com/");
			WebElement mouseHover = cd.findElement(By.xpath("//a[text()='brands']"));
			Actions Brands = new Actions(cd);
			Brands.moveToElement(mouseHover).perform();
			Thread.sleep(2000);
			cd.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
			Thread.sleep(1000);
			cd.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[2]")).sendKeys(Keys.ENTER);
			String Loreal = cd.getTitle();
			//System.out.println(Loreal);
				if (Loreal.contains("L'Oreal Paris")) {
				System.out.println("The title is correct");
				}
				else {
					System.out.println("Page hasn't loaded to the correct title");
				}
			cd.findElement(By.xpath("//button[contains(@class,'1aucgde')]")).click();
			Thread.sleep(2000);
			cd.findElement(By.xpath("//span[contains(text(),'top rated')]")).click();
			cd.findElement(By.xpath("//span[contains(text(),'Category')]")).click();
			Thread.sleep(1000);
 			cd.findElement(By.xpath("//li[@class='css-1do4irw']//div")).click();
 			Thread.sleep(1000);
			cd.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
 			Thread.sleep(1000);
			cd.findElement(By.xpath("(//div[contains(@class,'control-indicator')])[2]")).click();
 			Thread.sleep(1000);
			cd.findElement(By.xpath("//span[text()='Concern']")).click();
 			Thread.sleep(1000);
			cd.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
 			Thread.sleep(1000);
			String filterShampoo = cd.findElement(By.xpath("//span[@class='filter-value']")).getText();
			System.out.println(filterShampoo);
				if(filterShampoo.contains("Shampoo")) {
					System.out.println("Filter val has Shampoo");
				}else {
					System.out.println("Filter isn't applied properly");
			
				}
			Thread.sleep(2000);
			cd.findElement(By.xpath("//div[@class='css-1rd7vky']//div")).click();
			Set<String> windowHandles = cd.getWindowHandles();
			List<String> newPageLoreal = new ArrayList<String>(windowHandles);
			cd.switchTo().window(newPageLoreal.get(1));
			Thread.sleep(2000);
			cd.findElement(By.xpath("//span[text()='180ml']")).click();
			String mrp = cd.findElement(By.xpath("//div[@class='css-1d0jf8e']")).getText();
			System.out.println(mrp);
			cd.findElement(By.xpath("//button[@class=' css-13zjqg6']")).click();
			cd.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
			cd.switchTo().frame(0);
			String grandTotal = cd.findElement(By.xpath("//span[contains(@class,'css-1um1mkq e171rb9k3')]")).getText();
			System.out.println(grandTotal);
			Thread.sleep(2000);
			cd.findElement(By.xpath("(//button[@class='css-1j2bj5f e8tshxd0'])[2]")).click();
			Thread.sleep(2000);
			cd.switchTo().defaultContent();
			cd.findElement(By.xpath("(//button[@class='css-110s749 e8tshxd1'])[2]")).click();
			cd.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();
			cd.findElement(By.xpath("(//span[@class='css-1b232xc ehes2bo3']//img)[2]")).click();
			String youPay = cd.findElement(By.xpath("(//div[@class='css-vlqrtx e1d9ugpt3']/p)[3]")).getText();
			System.out.println(youPay);
				if(youPay.equals(grandTotal)) {
					System.out.println("The grand total is the same");
				}else {
					System.out.println("Grand total value has changed");
				}
			cd.quit();
			
				}
		}
