package testCasesMarathon2;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClassMarathon2.BaseClass;
import pagesMarathon2.LoginPage;

public class TestCaseCreateTestNGMarathon2 extends BaseClass {
	@BeforeTest
	public void setValues() {
		ExcelFile = "CreateIndividualSalesForce";
		testCase = "Create Individual";
		testDescription = "This test case Creates a individuals in the SalesForce Application";
		testAuthor = "Jahnavi A P";
		testCategory = "Positive Testing";
	}
	
	@Test(dataProvider="ExcelIntegrationMarathon")
	public void testCaseExecution(String lname) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage();
		lp.userName("jahnavi90@tcs.com").password("SaiBaba@143$").login()
		.clickToggle().viewAll().partyConsent()
		.clickNew().lastName(lname).saveButton()
		.printIndividualInfo();
		
	}
}
