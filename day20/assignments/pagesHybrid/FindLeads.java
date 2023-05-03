package pagesHybrid;

import org.openqa.selenium.By;

import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;

public class FindLeads extends BaseClass_ExcelIntegration{
	@And("Click on the Phone tab")
	public FindLeads phNumber() {
		getDriver().findElement(By.xpath("//span[text()='Phone']")).click();
		return this;
	}
	@And("Enter the PhoneNum as (.*)$")
	public FindLeads passNum(String phNum) {
		getDriver().findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNum);
		return this;
	}
	@And("Click on Find Leads")
	public FindLeads clickFindLeads() throws InterruptedException {
		getDriver().findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		return this;
	}
	@And("Click on the first resulting Lead")
	public ViewLead clickLead() {
		getDriver().findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		return new ViewLead();
	}
}
