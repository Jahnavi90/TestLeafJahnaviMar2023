package pagesHybrid;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;

public class MyHomePage extends BaseClass_ExcelIntegration{
@And("Click on the Leads tab button")
	public MyLeads leads() {
		getDriver().findElement(By.linkText("Leads")).click();
		return new MyLeads();
	}
}
