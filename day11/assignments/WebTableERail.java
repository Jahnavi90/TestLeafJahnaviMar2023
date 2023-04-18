package day11.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableERail {

	public static void main(String[] args) {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cd.get("https://erail.in/");
		WebElement src = cd.findElement(By.id("txtStationFrom"));
				src.clear();
				src.sendKeys("ms",Keys.ENTER);
		WebElement dstn = cd.findElement(By.id("txtStationTo"));
				dstn.clear();
				dstn.sendKeys("vskp",Keys.ENTER);
		cd.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> listOfTrainNames = cd.findElements(By.xpath("//div[@id='divTrainsList']/table//tr[@onmouseout='HideCalendar()']"));
		int row = listOfTrainNames.size();
		System.out.println(row);
		for (int i = 2; i <= row+1; i++) {
			//div[@id='divTrainsList']/table//tr[2]/td[2]
		String text = cd.findElement(By.xpath("//div[@id='divTrainsList']/table//tr["+i+"]/td[2]/a")).getText();
		System.out.println(text);
			
		}

	}

}
