package testCasesMarathon2;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClassMarathon2.BaseClass;
import pagesMarathon2.LoginPage;

public class TestCaseDeleteTestNGMarathon2 extends BaseClass{
	@BeforeTest
	public void setValues() {
		ExcelFile = "DeleteIndividualSalesForce";
		testCase = "Delete Individuals";
		testDescription = "This test case deleted Individuals in the SalesForce Application";
		testAuthor = "Jahnavi A P";
		testCategory = "Positive Testing";
	}
	
	@Test(dataProvider="ExcelIntegrationMarathon")
	public void testCaseExecution(String lname) throws InterruptedException, IOException {
	LoginPage lp = new LoginPage();
	lp.userName("jahnavi90@tcs.com").password("SaiBaba@143$").login()
	.clickToggle().viewAll().partyConsent()
	.selectToDelete(lname).selectDelete().clickOnDelete().verifyDelete(lname);
	}
}
