package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@unitários",
        dryRun = false
)
public class RunnerTest {

}
