package baseClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utils.ExcelIntegration_POM;

public class BaseClass_ExcelIntegration extends AbstractTestNGCucumberTests {

	private static final ThreadLocal<RemoteWebDriver> tdriver = new ThreadLocal<RemoteWebDriver>();
//	public void setDriver() {
	public void setDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			tdriver.set(new ChromeDriver());}
		else if (browser.equalsIgnoreCase("edge")) {
			tdriver.set(new EdgeDriver());}
	}
	public RemoteWebDriver getDriver() {
		return tdriver.get();
	}

	public String ExcelFile;
	@Parameters("browser")
	@BeforeMethod
	public void commonCode(String browser) {
		setDriver(browser);
//	public void commonCode() {
//		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps/control/main");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
	}

	@DataProvider(name = "Excelintegration")
	public String[][] createEditLead() throws IOException {
		String[][] readExcel = ExcelIntegration_POM.readExcel(ExcelFile);
		return readExcel;
	}
}
