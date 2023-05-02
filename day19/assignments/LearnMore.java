package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass_SalesForce;

public class LearnMore extends BaseClass_SalesForce {
	public LearnMore(RemoteWebDriver cd) {
		this.cd = cd;
	}

	public newWindow learnMore() {
		WebElement learnmore = cd.findElement(By.xpath("//span[text()='Learn More']"));
		WebDriverWait wait = new WebDriverWait(cd, Duration.ofSeconds(10));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(learnmore));
		until.click();
		Set<String> LearnMore = cd.getWindowHandles();
		List<String> LearnMoreList = new ArrayList<String>(LearnMore);
		cd.switchTo().window(LearnMoreList.get(1));
		return new newWindow(cd);
	}
}