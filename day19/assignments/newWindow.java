package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class newWindow extends BaseClass_SalesForce {
	public newWindow(RemoteWebDriver cd) {
		this.cd = cd;
	}

	public LearningPage confirmWindow() {
		cd.findElement(By.xpath("//button[text()='Confirm']")).click();
		return new LearningPage(cd);
	}
}
