package baseClass;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class BaseClass_SalesForce {
	public RemoteWebDriver cd;
	public ChromeOptions ntfc;
	public EdgeOptions ntfe;
	public Shadow sh;

	@Parameters({"browser"})

	@BeforeMethod
	public void commonCodeSF(String browser) {
			ntfc = new ChromeOptions();
			ntfe = new EdgeOptions();
			ntfc.addArguments("--disable-notifications");
			ntfe.addArguments("--disable-notifications");
			if (browser.equalsIgnoreCase("chrome")) {
				cd = new ChromeDriver(ntfc);
			} else if (browser.equalsIgnoreCase("edge")) {
				cd = new EdgeDriver(ntfe);
			}
		cd.manage().window().maximize();
		cd.get("https://login.salesforce.com");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@AfterMethod
	public void closeBrowser() {
		cd.quit();
	}
}