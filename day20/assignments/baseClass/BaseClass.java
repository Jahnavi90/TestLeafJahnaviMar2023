package baseClass;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseClass {
	
	private static final ThreadLocal<RemoteWebDriver> tdriver = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() {
		tdriver.set(new ChromeDriver());
		tdriver.set(new EdgeDriver());
	}
	public RemoteWebDriver getDriver() {
		return tdriver.get();
	}
	
	@BeforeMethod
		public void commonCode() {
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("http://leaftaps.com/opentaps/control/main");
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@AfterMethod
	public void closeBrowser() {
		getDriver().close();
}
}
