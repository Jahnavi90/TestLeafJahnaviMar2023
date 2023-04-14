package day10.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTesting {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver ed = new ChromeDriver();
		ed.manage().window().maximize();
		ed.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ed.get("https://www.amazon.in/");
		WebElement searchBox = ed.findElement(By.id("twotabsearchtextbox"));
					searchBox.click();
					searchBox.sendKeys("bags");
		Thread.sleep(2000);
		ed.findElement(By.xpath("//span[contains(text(),' for boys')]")).click();
		String text1 = ed.findElement(By.xpath("//span[text()='1-48 of over 50,000 results for']")).getText();
		String text2 = ed.findElement(By.xpath("(//span[contains(text(),'for boys')])[1]")).getText();
		System.out.println(text1+" "+text2);
		Thread.sleep(2000);
		ed.findElement(By.xpath("(//div[@id='brandsRefinements']//li/span/a)[1]")).click();
		Thread.sleep(2000);
		ed.findElement(By.xpath("(//div[@id='brandsRefinements']//li/span/a)[3]")).click();
		Thread.sleep(2000);
		ed.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		ed.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		Thread.sleep(3000);
		String text3 = ed.findElement(By.xpath("(//h2[contains(@class,'a-spacing-none')]//span)[1]")).getText();
		System.out.println(text3);
		String text4 = ed.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]")).getText();
		System.out.println(text4);
		Thread.sleep(2000);
		String title = ed.getTitle();
		System.out.println(title);
		Thread.sleep(1000);
		ed.close();
	}
}
