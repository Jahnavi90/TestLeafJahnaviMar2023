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

public class SalesForce_AchitectCerts {

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
		WebElement learnmore = cd.findElement(By.xpath("//span[text()='Learn More']"));
		WebDriverWait wait = new WebDriverWait(cd,Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(learnmore));
		until.click();
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
		Thread.sleep(2000);
		WebElement salesforcecerti = sh.findElementByXPath("//a[text()='Salesforce Certification']");
		cd.executeScript("arguments[0].click()", salesforcecerti);
		cd.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
		String text = cd.findElement(By.xpath("//div[@class='credentialBanner-card_description']")).getText();
		System.out.println(text);
		System.out.println("****************************");
		List<WebElement> listOfCertificates1 = cd.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]"));
		List<String>listofCerts1 = new ArrayList<String>();
			int size1 = listOfCertificates1.size();
			for (int i = 0; i < size1; i++) {
				String certificateList = listOfCertificates1.get(i).getText();	
				listofCerts1.add(certificateList);
				//System.out.println("The below are the list of Certificates: "+"\n"+certificateList);
			}
			System.out.println("The below are the list of Certificates: "+"\n"+listofCerts1);
		cd.findElement(By.xpath("//a[text()='Application Architect']")).click();
		List<WebElement> listOfCertificates2 = cd.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]"));
		List<String>listofCerts2 = new ArrayList<String>();
			int size2 = listOfCertificates2.size();
			for (int i = 0; i < size2; i++) {
				String certificateList = listOfCertificates2.get(i).getText();	
				listofCerts2.add(certificateList);
				//System.out.println("The below are the list of Certificates: "+"\n"+certificateList);
			}
			System.out.println("The below are the list of Certificates: "+"\n"+listofCerts2);
		
	}

}
