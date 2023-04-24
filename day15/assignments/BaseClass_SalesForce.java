package day15.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass_SalesForce {
		
	public ChromeOptions ntfc;
	public EdgeOptions ntfe;
	public RemoteWebDriver cd;
	
@Parameters({"browser","url","username","password"})
		
	@BeforeMethod
		public  void beforeMethod(String browser, String url, String uName, String pwd) throws InterruptedException {
		ntfc = new ChromeOptions();
		ntfe = new EdgeOptions();
		ntfc.addArguments("--disable-notifications");
		ntfe.addArguments("--disable-notifications");
		
			if(browser.equalsIgnoreCase("chrome")) {
				cd  = new ChromeDriver(ntfc);
			}else if(browser.equalsIgnoreCase("edge")){
				cd 	= new EdgeDriver(ntfe);
		}
		cd.manage().window().maximize();
		cd.get(url);
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		cd.findElement(By.id("username")).sendKeys(uName);
		cd.findElement(By.id("password")).sendKeys(pwd);
		cd.findElement(By.id("Login")).click();
		cd.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//button[text()='View All']")).click();
		cd.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		WebElement Opportunities = cd.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		cd.executeScript("arguments[0].click()", Opportunities);
		cd.findElement(By.xpath("//div[text()='New']")).click();
	}

@AfterMethod
	public void afterMethod() throws InterruptedException {
	Thread.sleep(2000);
	cd.close();
}

}
