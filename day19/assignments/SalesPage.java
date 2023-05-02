package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class SalesPage extends BaseClass_SalesForce{
	
		public SalesPage(RemoteWebDriver cd) {
			this.cd = cd;
		}
		public SalesPage oppTab() {
		WebElement Opportunities = cd.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		cd.executeScript("arguments[0].click()", Opportunities);
		return this;
		}
		public CreateOpportunity newOpp() {
		cd.findElement(By.xpath("//div[text()='New']")).click();
		return new CreateOpportunity(cd);
	}
}
