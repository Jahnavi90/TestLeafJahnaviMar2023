package pagesHybrid;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;

public class HomePage extends BaseClass_ExcelIntegration{
@And("Click on the CRM\\/SFA Link")
	public MyHomePage crmlink() {
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}
}
