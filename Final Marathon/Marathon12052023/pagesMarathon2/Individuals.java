package pagesMarathon2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClassMarathon2.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class Individuals extends BaseClass {

	@And("Click on New Individual")
	public NewIndividual clickNew() throws IOException {
		try {
			WebElement clk = getDriver().findElement(By.xpath("//div[text()='New']"));
			getDriver().executeScript("arguments[0].click();", clk);
			reportStatus("Pass", "Clicked");
		} catch (Exception e) {
			reportStatus("Fail", "Not Clicked");
		}
		return new NewIndividual();
	}
	@And("Verify the Individual info")
	public Individuals printIndividualInfo() throws IOException {
		try {
			String message = getDriver()
					.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))
					.getText();
			System.out.println(message);
			reportStatus("Pass", "Verified");
		} catch (Exception e) {
			reportStatus("Fail", "Not verified");
		}
		return this;
	}
	@Given("Enter the value to edit as (.*)$")
	public Individuals enterlnameforEdit(String lname) throws InterruptedException, IOException {
		try {
			WebElement clk = getDriver().findElement(By.xpath("//a[@title='Individuals']//span[1]"));
			getDriver().executeScript("arguments[0].click();", clk);
			getDriver().findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys(lname, Keys.ENTER);
			Thread.sleep(4000);
			reportStatus("Pass", "Entered");
		} catch (InterruptedException e) {
			reportStatus("Fail", "Not entered");
		}
		return this;
	}
	@And("Click on the edit button")
	public EditPage editIndividual() throws InterruptedException, IOException {
		try {
			WebElement ele = getDriver().findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
			getDriver().executeScript("arguments[0].click();", ele);
			Thread.sleep(3000);
			WebElement edit = getDriver().findElement(By.xpath("//a[@title='Edit']/div"));
			getDriver().executeScript("arguments[0].click();", edit);
			reportStatus("Pass", "Edit clicked");
		} catch (InterruptedException e) {
			reportStatus("Fail", "Edit not clicked");
			e.printStackTrace();
		}
		return new EditPage();
	}
	@And("Verify the edited info")
	public Individuals printEditInfo() throws IOException {
		try {
			String msg = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			System.out.println(msg);
			reportStatus("Pass", "Verified");
		} catch (Exception e) {
			reportStatus("Fail", "Not verified");
		}
		return this;
	}
	@Given("Provide the lname as (.*)$")
	public Individuals selectToDelete(String lname) throws InterruptedException, IOException {
		try {
			WebElement clk = getDriver().findElement(By.xpath("//a[@title='Individuals']//span[1]"));
			getDriver().executeScript("arguments[0].click();", clk);
			getDriver().findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys(lname, Keys.ENTER);
			Thread.sleep(2000);
			reportStatus("Pass", "Value passed");
		} catch (InterruptedException e) {
			reportStatus("Fail", "Value not passed");
		}
		return this;
	}
	@And("Select the delete from the dropdown")
	public Individuals selectDelete() throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			WebElement ele = getDriver()
					.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
			getDriver().executeScript("arguments[0].click();", ele);
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
			WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"))));
			getDriver().executeScript("arguments[0].click();", delete);
			reportStatus("Pass", "Delete selected");
		} catch (InterruptedException e) {
			reportStatus("Fail", "Not selected");
		}
		return this;
	}
	@And("Click on Delete button")
	public Individuals clickOnDelete() throws IOException {
		try {
			getDriver().findElement(By.xpath("//span[text()='Delete']")).click();
			String msg = getDriver().findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			System.out.println(msg);
			reportStatus("Pass", "Deleted");
		} catch (Exception e) {
			reportStatus("Pass", "Not Deleted");
		}
		return this;
	}
	@And("Verify if the lname is deleted (.*)$")
	public Individuals verifyDelete(String lname) throws InterruptedException, IOException {
		try {
			getDriver().findElement(By.xpath("//input[@class='slds-input']")).sendKeys(lname,Keys.ENTER);
			Thread.sleep(2000);
			String verify = getDriver().findElement(By.xpath("//span[text()='No items to display.']")).getText();
			System.out.println(verify);
			reportStatus("Pass", "Verified");
		} catch (InterruptedException e) {
			reportStatus("Fail", "Verified");
		}
		return this;
	}
}
