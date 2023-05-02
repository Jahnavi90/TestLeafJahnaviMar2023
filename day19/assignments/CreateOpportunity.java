package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class CreateOpportunity extends BaseClass_SalesForce {
		public CreateOpportunity(RemoteWebDriver cd) {
		this.cd = cd;
		}
		public CreateOpportunity oppName() {
			WebElement oppName = cd.findElement(By.xpath("(//div[@class='slds-form-element__control slds-grow']//input)[3]"));
			oppName.sendKeys("Salesforce Automation by Jahnavi");
			oppName.getText();
			return this;
		}
		public CreateOpportunity dateDropdown() throws InterruptedException {
			cd.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
			Thread.sleep(2000);
			return this;
		}
		public CreateOpportunity closeDate() {
		cd.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("02/05/2023");
		return this;
		}
		public CreateOpportunity stageDropDown() throws InterruptedException {
		cd.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]")).click();
		Thread.sleep(2000);
		return this;
		}
		public CreateOpportunity stage() throws InterruptedException {
		cd.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		Thread.sleep(2000);
		return this;
		}
		public OpportunityVerification submit() throws InterruptedException {
		cd.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Thread.sleep(2000);
		return new OpportunityVerification(cd);
		}

}
