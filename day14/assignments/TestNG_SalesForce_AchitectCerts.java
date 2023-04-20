package day14.assignments;


import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class TestNG_SalesForce_AchitectCerts extends BaseClass_2{
@Test(dependsOnMethods="day14.assignments.TestNG_SalesForce_AdminCerts.adminCerts")
	public void architectCerts() throws InterruptedException {
		
		cd.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
		String text = cd.findElement(By.xpath("//div[@class='credentialBanner-card_description']")).getText();
		System.out.println(text);
		System.out.println("****************************");
		List<WebElement> listOfCertificates1 = cd.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]"));
		List<String>listofCerts1 = new ArrayList<String>();
			int size1 = listOfCertificates1.size();
			for (int i = 0; i < size1; i++) {
				String certificateList = listOfCertificates1.get(i).getText();	
				listofCerts1.add(certificateList);
				//System.out.println("The below are the list of Certificates: "+"\n"+certificateList);
			}
			System.out.println("The below are the list of Certificates: "+"\n"+listofCerts1);
		cd.findElement(By.xpath("//a[text()='Application Architect']")).click();
		List<WebElement> listOfCertificates2 = cd.findElements(By.xpath("//div[contains(@class,'credentials-card_title')]"));
		List<String>listofCerts2 = new ArrayList<String>();
			int size2 = listOfCertificates2.size();
			for (int i = 0; i < size2; i++) {
				String certificateList = listOfCertificates2.get(i).getText();	
				listofCerts2.add(certificateList);
				//System.out.println("The below are the list of Certificates: "+"\n"+certificateList);
			}
			System.out.println("The below are the list of Certificates: "+"\n"+listofCerts2);
		
	}

}
