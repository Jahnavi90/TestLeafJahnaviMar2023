package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import baseClass.BaseClass_ExcelIntegration;
import pagesHybrid.LoginPage;

public class TC_002 extends BaseClass_ExcelIntegration {
	@BeforeTest
	public void setData() {
		ExcelFile = "EditLead";
	}

	@Test(dataProvider="Excelintegration")

	public void executeEditLead(String phNum, String upCname) throws InterruptedException {

		LoginPage lp = new LoginPage();

		lp.username("demoSalesManager").password("crmsfa").submit().crmlink().leads().findLeads()
		.phNumber().passNum(phNum).clickFindLeads().clickLead().clickEdit().updateCname(upCname)
		.updateButton().verificationEL(upCname);
		
	}
}
