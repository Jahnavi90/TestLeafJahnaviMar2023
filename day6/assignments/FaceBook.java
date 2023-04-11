package day6.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cd.get("https://en-gb.facebook.com/");
		cd.findElement(By.xpath("(//a[contains(text(),'Forgotten password?')]/following::a)[1]")).click();
		cd.findElement(By.xpath("//i[contains(@class,'l2kzVUyK8Q5')]/preceding-sibling::input")).sendKeys("Jason");
		cd.findElement(By.xpath("//div[text()='Surname']/following-sibling::input")).sendKeys("Huggins");
		cd.findElement(By.xpath("(//div[@class='_5dbb']//input)[3]")).sendKeys("7799299349");
		cd.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("practice");	
		Thread.sleep(5000);
		WebElement findElement = cd.findElement(By.xpath("(//select[@id='month']/preceding-sibling::select)"));
				Select date = new Select(findElement);
				date.selectByIndex(6);
			Select month = new Select(cd.findElement(By.xpath("(//select[@id='year']/preceding-sibling::select)[2]")));
				month.selectByVisibleText("Jun");
			Select year = new Select(cd.findElement(By.xpath("(//select[@id='month']/following-sibling::select)[1]")));
				year.selectByValue("1990");
				
		cd.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		Thread.sleep(5000);
		cd.close();
		}
}
