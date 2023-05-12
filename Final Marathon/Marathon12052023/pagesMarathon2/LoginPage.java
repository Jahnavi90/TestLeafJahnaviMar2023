package pagesMarathon2;

import java.io.IOException;

import org.openqa.selenium.By;

import baseClassMarathon2.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginPage extends BaseClass{
	@Given("Enter Username as (.*)$")
	public LoginPage userName(String uname) throws IOException {
		try {
			getDriver().findElement(By.id("username")).sendKeys(uname);
			reportStatus("Pass", "Username is entered");
		} catch (Exception e) {
			reportStatus("Pass", "Username is not entered");;
		}
		return this;
	}
	@And("Enter password as (.*)$")
	public LoginPage password(String pwd) throws IOException {
		try {
			getDriver().findElement(By.id("password")).sendKeys(pwd);
			reportStatus("Pass", "Password is entered");
		} catch (Exception e) {
			reportStatus("Fail", "Passowrd is not entered");
		}
		return this;
	}
	@And("Click on login button")
	public HomePage login() throws IOException {
		try {
			getDriver().findElement(By.id("Login")).click();
			reportStatus("Pass", "Login is clicked");
		} catch (Exception e) {
			reportStatus("Fail", "Login is not clicked");
		}
		return new HomePage();
	}
}
