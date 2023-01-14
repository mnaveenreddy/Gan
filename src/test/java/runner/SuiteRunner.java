package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        glue = "stepdefinitions")

public class SuiteRunner extends AbstractTestNGCucumberTests {

}