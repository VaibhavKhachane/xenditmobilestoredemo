
package Runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepDef"},
        tags = {"~@Ignore"},
        dryRun = false,
        format = {
                "com.cucumber.listener.ExtentCucumberFormatter:report/maven-JVM-report/Maven-Extent-Reports/Xendit-Extent-Report.html",
                "html:report/cucumber-html-report/cucumber-pretty",
                "html:target/cucumber-html-report",
                "html:target/cucumber.xml",
                "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml",
                "rerun:target/failed_scenarios.txt"
        })

public class TestRunnerTestNG {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }

}
