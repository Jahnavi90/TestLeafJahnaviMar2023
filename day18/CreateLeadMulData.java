package stepDefinition;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadMulData extends BaseClass{
	
	public String cname;

//	@Given("Launch the Browser, add implicit wait, load the URL, maximize the screen.")
//	public void login() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://leaftaps.com/opentaps/control/main");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	@And("Enter the username as {string}")
	public void username(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@And("Enter the password as {string}")
	public void password(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on login button")
	public void submit() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@And("Click on the CRM\\/SFA Link")
	public void crmlink() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Click on the Leads tab button")
	public void leads() {
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Click on Create button")
	public void create() {
		driver.findElement(By.linkText("Create Lead")).click();
	}

	@And("Enter the CompanyName as (.*)$")
	public void cname(String cname) {
		this.cname = cname;
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
	}
	@And("Enter the First Name as (.*)$")
	public void fname(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}

	@And("Enter the Last Name as (.*)$")
	public void lname(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}

	@And("Enter the PhoneNumber (.*)$")
	public void phnum(String phNum) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNum);
	}

	@When("Click on the final Submit button")
	public void finalsubmit() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify if the Lead is created successfully")
	public void verification() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cname)) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");
		}
	}
	@And("Close the opened Browser")
	public void close() {
		driver.close();
	}
	@But("Verify if the Lead is not created successfully")
		public void assertConcept() throws InterruptedException {

			String error = driver.findElement(By.xpath("//li[contains(text(),'parameter is missing')]")).getText();
			Thread.sleep(3000);
			if (error.contains("missing")) {
				System.out.println("Create Lead is not successful");
			} else {
				System.out.println("Created the Lead");
			}			
			String acttitle = driver.getTitle();			
			String exptitle = "View Lead";
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(acttitle,exptitle);
			sa.assertAll();
		}
	}
