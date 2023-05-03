package testCases;

import org.testng.annotations.DataProvider;

import baseClass.BaseClass_ExcelIntegration;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="./src/main/java/features/CreateLead.feature",
				glue="pagesHybrid",
				monochrome=true,
				publish=true)
public class Cucumber_RunnerClass_Create extends BaseClass_ExcelIntegration{
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
	return super.scenarios();
}
}
