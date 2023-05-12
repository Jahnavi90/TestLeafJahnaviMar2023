package testCasesMarathon2;

import org.testng.annotations.DataProvider;

import baseClassMarathon2.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="./src/test/java/featuresMarathon2/SalesForceMarathonDelete.feature",
			glue="pagesMarathon2",
			monochrome=true,
			publish=true)
	public class DeleteCucumberRunnerMarathon2 extends BaseClass{
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
