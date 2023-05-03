package pagesHybrid;

import java.time.Duration;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPage extends BaseClass_ExcelIntegration{
	
//	@Given("Set browser as (.*)$")
//	public LoginPage setBrowser(String browser) {
//	setDriver(browser);
//	getDriver().manage().window().maximize();
//	getDriver().get("http://leaftaps.com/opentaps/control/main");
//	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	return this;
//	}
	@Given("Enter the username as (.*)$")
	public LoginPage username(String uname) {
		getDriver().findElement(By.id("username")).sendKeys(uname);
		return this;
	}
	@And("Enter the password as (.*)$")
	public LoginPage password(String pwd) {
		getDriver().findElement(By.id("password")).sendKeys(pwd);
		return this;
	}
	@Then("Click on login button")
	public HomePage submit() {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		return new HomePage();
	}

}
