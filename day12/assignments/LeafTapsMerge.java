package day12.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafTapsMerge {

	public static void main(String[] args) {
		ChromeDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cd.get("http://leaftaps.com/opentaps/control/login");
		cd.findElement(By.id("username")).sendKeys("demoSalesManager");
		cd.findElement(By.id("password")).sendKeys("crmsfa");
		cd.findElement(By.className("decorativeSubmit")).click();
//		Alert simple = cd.switchTo().alert();
//		simple.accept();
		cd.findElement(By.linkText("CRM/SFA")).click();
		cd.findElement(By.linkText("Contacts")).click();
		cd.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
		cd.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandlesfrom = cd.getWindowHandles();
		List<String> contactsFirst = new ArrayList<String>(windowHandlesfrom);
		cd.switchTo().window(contactsFirst.get(1));
		cd.findElement(By.xpath("//div[@class='x-grid3-row   ']//table/tbody/tr/td/div/a[1]")).click();
//		cd.close();
		cd.switchTo().window(contactsFirst.get(0));
		cd.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandlesTo = cd.getWindowHandles();
		List<String> contactsTo = new ArrayList<String>(windowHandlesTo);
		cd.switchTo().window(contactsTo.get(1));
		cd.findElement(By.xpath("//div[@class='x-grid3-row    x-grid3-row-alt']//table/tbody/tr/td/div/a[1]")).click();
//		cd.close();
		cd.switchTo().window(contactsFirst.get(0));
		cd.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert accept = cd.switchTo().alert();
		accept.accept();
		String title = cd.getTitle();
		System.out.println(title);
	}

}
