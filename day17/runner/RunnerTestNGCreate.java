package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/LoginAndCreateLead.feature",
				glue="stepDefinition/StepsForCreate",
				monochrome=true,
				publish=true)

public class RunnerTestNGCreate extends AbstractTestNGCucumberTests{

	}
