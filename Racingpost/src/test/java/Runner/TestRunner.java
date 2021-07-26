package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:Features/upcomingrace.feature"
		,glue= {"StepDefinition"}
		,dryRun=false
		,monochrome=true	
		,plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"}
		
		
		)



public class TestRunner {

}
