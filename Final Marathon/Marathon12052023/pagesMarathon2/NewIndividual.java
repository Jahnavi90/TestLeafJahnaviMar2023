package pagesMarathon2;

import java.io.IOException;

import org.openqa.selenium.By;

import baseClassMarathon2.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class NewIndividual extends BaseClass{
	@And("Provide the last Name value as (.*)$")
	public NewIndividual lastName(String lname) throws IOException {
		try {
			getDriver().findElement(By.xpath("//input[contains(@class,'lastName compound')]")).sendKeys(lname);
			reportStatus("Pass", "Value passed");
		} catch (Exception e) {
			reportStatus("Fail", "Value not passed");
		}
		return this;
	}
	@Then("Click on Save button")
	public Individuals saveButton() throws IOException {
		try {
			getDriver().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			reportStatus("Pass", "Saved");
		} catch (Exception e) {
			reportStatus("Fail", "Not saved");
		}
		return new Individuals();
	}
}
