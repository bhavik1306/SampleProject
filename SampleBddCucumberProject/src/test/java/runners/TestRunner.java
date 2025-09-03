package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
//        plugin = {"pretty", "html:target/cucumber-reports.html"},
        plugin = {"pretty",
                "json:target/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:allure-results/cucumber-html-report.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
