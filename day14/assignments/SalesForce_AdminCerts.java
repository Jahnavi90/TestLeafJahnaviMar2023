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

import io.github.sukgu.Shadow;

public class SalesForce_AdminCerts {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ntf = new ChromeOptions();
		ntf.addArguments("--disable-notifications");
		ChromeDriver cd  = new ChromeDriver(ntf);
		cd.manage().window().maximize();
		cd.get("https://login.salesforce.com");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cd.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		cd.findElement(By.id("password")).sendKeys("Leaf@123");
		cd.findElement(By.id("Login")).click();
		//Thread.sleep(7000);
		WebElement learnmore = cd.findElement(By.xpath("//span[text()='Learn More']"));
		WebDriverWait wait = new WebDriverWait(cd,Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(learnmore));
		until.click();
		//Thread.sleep(5000);
		Set<String> LearnMore = cd.getWindowHandles();
		List<String> LearnMoreList = new ArrayList<String>(LearnMore);
		cd.switchTo().window(LearnMoreList.get(1));
		cd.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow sh = new Shadow(cd);
		sh.findElementByXPath("//span[text()='Learning']").click();
		Thread.sleep(2000);
		WebElement mouseHover = sh.findElementByXPath("//span[text()='Learning on Trailhead']");
		Thread.sleep(3000);
		Actions LearningTrail = new Actions(cd);
		LearningTrail.moveToElement(mouseHover).perform();
//		WebElement scroll = sh.findElementByXPath("//div[contains(@class,'l3-panel')]");
//		Thread.sleep(5000);
//		LearningTrail.scrollToElement(scroll).perform();
		Thread.sleep(2000);
		WebElement salesforcecerti = sh.findElementByXPath("//a[text()='Salesforce Certification']");
		cd.executeScript("arguments[0].click()", salesforcecerti);
		//cd.findElement(By.xpath("//a[text()='Salesforce Associate']")).click();
		cd.findElement(By.xpath("//a[text()='Administrator']")).click();
		String text = cd.findElement(By.xpath("(//div[text()='Administrator'])[2]")).getText();
			if (text.contains("Administrator")) {
				System.out.println("We are on the Administrator overview page");
			}	else {
				System.out.println("We are not on the Administrator overview page");
			}
		System.out.println("****************************");
		List<WebElement> listOfCertificates = cd.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]"));
		List<String>listofCerts = new ArrayList<String>();
			int size = listOfCertificates.size();
			for (int i = 0; i < size; i++) {
				String certificateList = listOfCertificates.get(i).getText();	
				listofCerts.add(certificateList);
				//System.out.println("The below are the list of Certificates: "+"\n"+certificateList);
			}
			System.out.println("The below are the list of Certificates: "+"\n"+listofCerts);
			}	
	}
