package day14.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestNG_SalesForce_TomoDate extends BaseClass_1{
	
@Test
	public void testNG_SalesForce2() throws InterruptedException {
		
		cd.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
		Thread.sleep(2000);
		cd.findElement(By.xpath("//span[text()='20']")).click();
		cd.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String snag = cd.findElement(By.xpath("//div[@class='fieldLevelErrors']")).getText();
			if(snag.contains ("Review the following fields")){
					System.out.println("Error message has appeared: "+"\n"	+snag);
			}else {
				System.out.println("Warning has not appeared");
			}
	}
}
