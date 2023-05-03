package pagesHybrid;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass_ExcelIntegration{


	@And("Enter the CompanyName as (.*)$")
	public CreateLead cname(String cname) {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		return this;
	}
	@And("Enter the First Name as (.*)$")
	public CreateLead fname(String fname) {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		return this;
	}
	@And("Enter the Last Name as (.*)$")
	public CreateLead lname(String lname) {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		return this;
	}
	@And("Enter the PhoneNumber as (.*)$")
	public CreateLead phnum(String phnum) {
		getDriver().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnum);
		return this;
	}
	@When("Click on the final Submit button")
	public ViewLead finalsubmit() {
		getDriver().findElement(By.name("submitButton")).click();
		return new ViewLead();
	}
}
