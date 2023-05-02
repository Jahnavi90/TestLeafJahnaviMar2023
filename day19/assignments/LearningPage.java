package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;
import io.github.sukgu.Shadow;

public class LearningPage extends BaseClass_SalesForce {
	public LearningPage(RemoteWebDriver cd) {
		this.cd = cd;
	}

	public CertiPage learningPage() throws InterruptedException {
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
		return new CertiPage(cd);
	}
}
