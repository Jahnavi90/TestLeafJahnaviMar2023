package pagesMarathon2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClassMarathon2.BaseClass;
import io.cucumber.java.en.And;

public class ToggleMenu extends BaseClass{
	@And("In the toggle Menu click on Individuals")
	public Individuals partyConsent() throws IOException {
		try {
			WebElement scroll = getDriver().findElement(By.xpath("//p[text()='Party Consent']"));
			getDriver().executeScript("arguments[0].scrollIntoView();", scroll);
			WebElement individual = getDriver().findElement(By.xpath("//p[text()='Individuals']"));
			getDriver().executeScript("arguments[0].click();", individual);
			reportStatus("Pass", "Clicked");
		} catch (Exception e) {
			reportStatus("Fail", "Not clicked");
		}
		return new Individuals();
	}
}
