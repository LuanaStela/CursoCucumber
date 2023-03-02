package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/report.json"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/alugar_filme.feature",
        glue = "steps"
)
public class RunnerTest {
}
