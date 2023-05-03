package pagesHybrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass_ExcelIntegration{
@And("Enter the Company_Name as (.*)$")
	public EditLead updateCname(String upCname) {
		WebElement companyName = getDriver().findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys(upCname);
		return this;
	}
@When("Click on the Update button")
	public ViewLead updateButton() {
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLead();
	}
}
