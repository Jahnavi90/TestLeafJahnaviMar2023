package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseClass.BaseClass_ExcelIntegration;
import pagesHybrid.LoginPage;

public class TC_001 extends BaseClass_ExcelIntegration {

	@BeforeTest
	public void setData() {
		ExcelFile = "CreateLead";
	}

	@Test(dataProvider = "Excelintegration")

	public void executeCreateLead(String cname, String fname, String lname, String phnum) {

		LoginPage lp = new LoginPage();

		lp.username("Democsr").password("crmsfa").submit().crmlink().leads().create().cname(cname).fname(fname)
			.lname(lname).phnum(phnum).finalsubmit().verificationCL(cname);
	}
}
