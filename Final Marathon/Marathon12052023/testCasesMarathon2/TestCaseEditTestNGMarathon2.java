package testCasesMarathon2;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClassMarathon2.BaseClass;
import pagesMarathon2.LoginPage;

public class TestCaseEditTestNGMarathon2 extends BaseClass{
	@BeforeTest
	public void setValues() {
		ExcelFile = "EditIndividualSalesForce";
		testCase = "Edit Individual";
		testDescription = "This test case edits the individuals in the SalesForce Application";
		testAuthor = "Jahnavi A P";
		testCategory = "Positive Testing";
	}
	
	@Test(dataProvider="ExcelIntegrationMarathon")
	public void testCaseExecution(String lname, String fname) throws InterruptedException, IOException {
		LoginPage lp = new LoginPage();
		lp.userName("jahnavi90@tcs.com").password("SaiBaba@143$").login()
		.clickToggle().viewAll().partyConsent()
		.enterlnameforEdit(lname).editIndividual()
		.editInfo(fname).printEditInfo();
		
}
}