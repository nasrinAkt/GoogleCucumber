package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

 @CucumberOptions(features = {"src/test/resources/linkFeatures"},
 plugin = {"json:target/cucumber.json"},
 glue = "stepDefinition")//tags = {""})	
		
public class runnerClass extends AbstractTestNGCucumberTests{

}
