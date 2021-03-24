package bblog;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"bblog"},
        plugin = {"pretty", "html:target/cucumberReports/html",
                "json:target/cucumberReports/json"}
)
public class RunBBlogTests {
}