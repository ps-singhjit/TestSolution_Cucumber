package parallel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qa.util.ConfigReader;

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
	@DataProvider(parallel = true) //"true" to run all scenarios in parallel
	public Object[][] scenarios() {
		return super.scenarios();
	}

	
}
