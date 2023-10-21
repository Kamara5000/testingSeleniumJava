package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/feature/SauceDemo.feature", monochrome = true, plugin = {"pretty", "html:target/cucumber.html"})
public class Test_Runner {

}
