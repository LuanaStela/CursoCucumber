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
        tags = "@funcionais",
        dryRun = false
)
public class RunnerFuncionalTest {

    @BeforeClass
    public static void reset () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("ariane@narin");
        driver.findElement(By.name("senha")).sendKeys("13");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
