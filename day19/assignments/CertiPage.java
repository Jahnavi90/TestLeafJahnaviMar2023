package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class CertiPage extends BaseClass_SalesForce {
	public CertiPage(RemoteWebDriver cd) {
		this.cd = cd;
	}

	public AdministratorPage certiPage() {
		cd.findElement(By.xpath("//a[text()='Administrator']")).click();
		return new AdministratorPage(cd);
	}
}
