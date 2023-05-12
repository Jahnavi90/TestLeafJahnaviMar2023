package pagesMarathon2;

import java.io.IOException;

import org.openqa.selenium.By;

import baseClassMarathon2.BaseClass;
import io.cucumber.java.en.And;

public class HomePage extends BaseClass{
	@And("Click the toggle menu in the Home Page")
	public HomePage clickToggle() throws IOException {
		try {
			getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			reportStatus("Pass", "Clicked");
		} catch (Exception e) {
			reportStatus("Fail", "Not clicked");
		}
		return this;
	}
	@And("Click on View All button")
	public ToggleMenu viewAll() throws IOException {
		try {
			getDriver().findElement(By.xpath("//button[text()='View All']")).click();
			reportStatus("Pass", "Clicked");
		} catch (Exception e) {
			reportStatus("Fail", "Not clicked");
		}
		return new ToggleMenu();
	}

}
