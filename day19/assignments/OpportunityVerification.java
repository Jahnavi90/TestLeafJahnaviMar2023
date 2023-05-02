package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class OpportunityVerification extends BaseClass_SalesForce{
	
	public OpportunityVerification(RemoteWebDriver cd) {
		this.cd = cd;
	}
	public OpportunityVerification verification() {
	String OppNameFinal = cd.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
	if(OppNameFinal.contains("Jahnavi")) {
		System.out.println("Opportunity Name is verified and is the correct value");
	}else {
		System.out.println("Opportunity Name is wrong, please check");
	}
	return this;
}
}
