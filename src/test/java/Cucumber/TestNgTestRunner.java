package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue="CrocusRobotic.Stepdefination", monochrome=true, plugin= {"html:target/cucumber.htm"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
