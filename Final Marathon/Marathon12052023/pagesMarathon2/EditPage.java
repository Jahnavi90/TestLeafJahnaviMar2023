package pagesMarathon2;

import java.io.IOException;

import org.openqa.selenium.By;

import baseClassMarathon2.BaseClass;
import io.cucumber.java.en.And;
	
public class EditPage extends BaseClass {
	@And("Provide the firstname as (.*)$")
	public Individuals editInfo(String fname) throws IOException {
		try {
			getDriver().findElement(By.xpath("//a[@class='select']")).click();
			getDriver().findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys(fname);
			getDriver().findElement(By.xpath("(//span[text()='Save'])[2]")).click();
			reportStatus("Pass", "Edited");
		} catch (Exception e) {
			reportStatus("Fail", "Not Edited");
		}
		return new Individuals();
	}
}
