package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsForCreate {
	public ChromeDriver driver;

	@Given("Launch Browser, add implicit wait, load the URL, maximize the screen.")
	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@And("Enter the Username as {string}")
	public void username(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@And("Enter the Password as {string}")
	public void password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on Login button")
	public void submit() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@And("Click on CRM\\/SFA Link")
	public void crmlink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Click on Leads tab button")
	public void leads() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Click on the Create button")
	public void create() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And("Enter the Company Name as TCS")
	public void cname() {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
	}

	@And("Enter the FirstName as Jahnavi")
	public void fname() {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jahnavi");
	}

	@And("Enter the LastName as Aradhyula")
	public void lname() {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Aradhyula");
	}

	@And("Enter the Phone Number 9884653533")
	public void phnum() {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
	}

	@When("Click on Submit button")
	public void finalsubmit() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify if the Lead is successfully created")
	public void verification() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TCS")) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");
		}
	}
	@And("Close the Browser")
	public void close() {
		driver.close();
	}
	@But("Login fails")
		public void assertConcept() {
			String acttitle = driver.getTitle();
			String exptitle = "CRM";
			if (acttitle.contains("CRM")) {
				System.out.println("Login Successful");
			} else {
				System.out.println("Login failed");
			SoftAssert sa = new SoftAssert();	
			sa.assertEquals(acttitle, exptitle);
			driver.close();
			sa.assertAll();
			}
		}
	}