package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass_SalesForce;
import pages.Login_SalesForce;

public class TC_003 extends BaseClass_SalesForce {
	@Test
	public void executeSalesOpp() throws InterruptedException {
		Login_SalesForce lsf = new Login_SalesForce(cd);
		lsf.uname().pwd().login().toggle().viewAll().sales().oppTab().newOpp()
		.oppName().dateDropdown().closeDate().stageDropDown().stage().submit()
		.verification();
	}
}
