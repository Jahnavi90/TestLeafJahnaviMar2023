package pagesHybrid;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ViewLead extends BaseClass_ExcelIntegration{

@Then("Verify if the Lead is created successfully (.*)$")
	public ViewLead verificationCL(String cname) {
		String text = getDriver().findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cname)) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");
		}
		return this;
}
@And("Click on Edit Button")
		public EditLead clickEdit() {
			getDriver().findElement(By.linkText("Edit")).click();
			return new EditLead();
		}
@Then("Verify if the Lead is edited successfully (.*)$")
public ViewLead verificationEL(String upCname) {
	String text = getDriver().findElement(By.id("viewLead_companyName_sp")).getText();
	if (text.contains(upCname)) {
		System.out.println("Lead edited successfully");
	} else {
		System.out.println("Lead is not edited");
	}
	return this;
}
}
