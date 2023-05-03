package pagesHybrid;
import org.openqa.selenium.By;
import baseClass.BaseClass;
import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.java.en.And;

public class MyLeads extends BaseClass_ExcelIntegration{
@And("Click on Create button")
	public CreateLead create() {
		getDriver().findElement(By.linkText("Create Lead")).click();
		return new CreateLead();
}
@And("Click on Find Leads button")
		public FindLeads findLeads() throws InterruptedException {
			getDriver().findElement(By.linkText("Find Leads")).click();
			return new FindLeads();
		}
}