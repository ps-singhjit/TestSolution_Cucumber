package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/parallel/LoginPage.feature"},		
		monochrome = true,
		glue = {"parallel"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				},
//		tags = "not @Skip",
		publish = true,
		dryRun = false
		)
public class ParallelRunnerTestNG extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = false) //"true" to run all scenarios in parallel
	public Object[][] scenarios() {
		return super.scenarios();
	}

	
}
