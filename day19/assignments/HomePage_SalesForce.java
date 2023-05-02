package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class HomePage_SalesForce extends BaseClass_SalesForce{
	public HomePage_SalesForce(RemoteWebDriver cd) {
	this.cd = cd;
}
	public HomePage_SalesForce toggle() throws InterruptedException {
	cd.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	Thread.sleep(2000);
	return this;
	}
	public HomePage_SalesForce viewAll() {
	cd.findElement(By.xpath("//button[text()='View All']")).click();
	return this;
	}
	public SalesPage sales() throws InterruptedException {
	cd.findElement(By.xpath("//p[text()='Sales']")).click();
	Thread.sleep(3000);
	return new SalesPage(cd);
	}
}
