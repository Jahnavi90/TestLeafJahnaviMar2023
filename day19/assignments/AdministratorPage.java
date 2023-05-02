package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClass.BaseClass_SalesForce;

public class AdministratorPage extends BaseClass_SalesForce {
	public AdministratorPage(RemoteWebDriver cd) {
		this.cd = cd;
	}

	public AdministratorPage adminPage() {
		String text = cd.findElement(By.xpath("(//div[text()='Administrator'])[2]")).getText();
		if (text.contains("Administrator")) {
			System.out.println("We are on the Administrator overview page");
		} else {
			System.out.println("We are not on the Administrator overview page");
		}
		System.out.println("****************************");
		List<WebElement> listOfCertificates = cd
				.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]"));
		List<String> listofCerts = new ArrayList<String>();
		int size = listOfCertificates.size();
		for (int i = 0; i < size; i++) {
			String certificateList = listOfCertificates.get(i).getText();
			listofCerts.add(certificateList);
		}
		System.out.println("The below are the list of Certificates: " + "\n" + listofCerts);
		return this;
	}
}
