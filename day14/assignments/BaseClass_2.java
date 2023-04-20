package day14.assignments;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.sukgu.Shadow;

public class BaseClass_2 {
		
	public ChromeOptions ntf;
	public ChromeDriver cd;
	public Shadow sh;
		
@BeforeMethod

public  void beforeMethod() throws InterruptedException {
	ntf = new ChromeOptions();
	ntf.addArguments("--disable-notifications");	
	cd = new ChromeDriver(ntf);
	cd.manage().window().maximize();
	cd.get("https://login.salesforce.com");
	cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	cd.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
	cd.findElement(By.id("password")).sendKeys("Leaf@123");
	cd.findElement(By.id("Login")).click();
	WebElement learnmore = cd.findElement(By.xpath("//span[text()='Learn More']"));
	WebDriverWait wait = new WebDriverWait(cd,Duration.ofSeconds(10));
	WebElement until = wait.until(ExpectedConditions.elementToBeClickable(learnmore));
	until.click();
	Set<String> LearnMore = cd.getWindowHandles();
	List<String> LearnMoreList = new ArrayList<String>(LearnMore);
	cd.switchTo().window(LearnMoreList.get(1));
	cd.findElement(By.xpath("//button[text()='Confirm']")).click();
	sh = new Shadow(cd);
	sh.findElementByXPath("//span[text()='Learning']").click();
	Thread.sleep(2000);
	WebElement mouseHover = sh.findElementByXPath("//span[text()='Learning on Trailhead']");
	Thread.sleep(3000);
	Actions LearningTrail = new Actions(cd);
	LearningTrail.moveToElement(mouseHover).perform();
	Thread.sleep(2000);
	WebElement salesforcecerti = sh.findElementByXPath("//a[text()='Salesforce Certification']");
	cd.executeScript("arguments[0].click()", salesforcecerti);

	}
@AfterMethod
	public void afterMethod() {
	cd.quit();
	
}
}
