package baseClassMarathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilsMarathon2.ExcelIntegrationMarathon2;

public class BaseClass extends AbstractTestNGCucumberTests{
	private static final ThreadLocal<RemoteWebDriver> tldriver = new ThreadLocal<RemoteWebDriver>();
	public String ExcelFile, testCase, testDescription, testAuthor, testCategory;
	public static ExtentReports reports;
	public static ExtentTest test;
	@BeforeSuite
		public void reports() {
		ExtentHtmlReporter htmlrepo = new ExtentHtmlReporter("./ExtentReports/MarathonHtml.html");
		htmlrepo.setAppendExisting(true);
		reports = new ExtentReports();
		reports.attachReporter(htmlrepo);
		}
	
	public void setDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions cops = new ChromeOptions();
		cops.addArguments("--disable-notifications");
		tldriver.set(new ChromeDriver(cops));
		}
		else if(browser.equalsIgnoreCase("edge")) {
		EdgeOptions eops = new EdgeOptions();
		eops.addArguments("--disable-notifications");
		tldriver.set(new EdgeDriver(eops));
		}
	}
	public RemoteWebDriver getDriver() {
		return tldriver.get();
	}
	@BeforeClass
	public void reportInformation() {
		test = reports.createTest(testCase, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}

	public void reportStatus(String status, String message) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			test.pass(message, MediaEntityBuilder
					.createScreenCaptureFromPath(".././snaps/img" + takeScreenshots() + ".jpeg").build());
		} else if (status.equalsIgnoreCase("fail")) {
			test.fail(message, MediaEntityBuilder
					.createScreenCaptureFromPath(".././snaps/img" + takeScreenshots() + ".jpeg").build());
		}
	}

	public int takeScreenshots() throws IOException {
		int randomNum = (int) (Math.random() * 99999);
		File src = getDriver().getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img" + randomNum + ".jpeg");
		FileUtils.copyFile(src, dest);
		return randomNum;
	} 
	
	@Parameters("browser")
	@BeforeMethod
	public void commonCode(String browser) {
		setDriver(browser);
		getDriver().get("https://login.salesforce.com/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@DataProvider(name="ExcelIntegrationMarathon")
	public String[][] readExcel() throws IOException {
		String [][] readData = ExcelIntegrationMarathon2.readExcel(ExcelFile);
		return readData;
	}
	@AfterMethod
	public void closeDriver() {
		getDriver().quit();
	}
@AfterSuite
public void reportClose() {
	reports.flush();
}
}
