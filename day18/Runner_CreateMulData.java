package runner;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.BaseClass;

@CucumberOptions(features = "src/test/java/features/CreateLeadMultipleData.feature", 
					glue = "stepDefinition", 
					monochrome = true, publish = true)

public class Runner_CreateMulData extends BaseClass {

}
