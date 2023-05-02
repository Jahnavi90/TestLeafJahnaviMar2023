package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class Login_SalesForce extends BaseClass_SalesForce{
	public Login_SalesForce(RemoteWebDriver cd) {
	this.cd = cd;
	}
	public Login_SalesForce uname() {
		cd.findElement(By.id("username")).sendKeys("jahnavi90@tcs.com");
		return this;
	}
	public Login_SalesForce pwd() {
		cd.findElement(By.id("password")).sendKeys("SaiBaba@143$");
		return this;
	}
	public HomePage_SalesForce login() {
	cd.findElement(By.id("Login")).click();
	return new HomePage_SalesForce(cd);
	
	}
	
	public LearnMore loginLearnMore() {
		cd.findElement(By.id("Login")).click();
		return new LearnMore(cd);
		
		}
}
