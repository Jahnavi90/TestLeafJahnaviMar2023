package testCases;

import org.testng.annotations.Test;

import baseClass.BaseClass_SalesForce;
import pages.Login_SalesForce;

public class TC_004 extends BaseClass_SalesForce {
	@Test
	public void executeAdminCerts() throws InterruptedException {
		Login_SalesForce lsf = new Login_SalesForce(cd);

		lsf.uname().pwd().loginLearnMore().learnMore().confirmWindow().learningPage().certiPage().adminPage();

	}
}
