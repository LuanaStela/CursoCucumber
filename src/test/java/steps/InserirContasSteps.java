package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class InserirContasSteps {

    private WebDriver driver;

    @Given("que desejo adicionar uma conta")
    public void queDesejoAdicionarUmaConta() {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("ariane@narin");
        driver.findElement(By.name("senha")).sendKeys("13");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();

    }
    @When("adiciono a conta {string}")
    public void adicionoAConta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);
        driver.findElement(By.tagName("button")).click();
    }
    @Then("recebo a mensagem {string}")
    public void receboAMensagem(String string) {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
        Assert.assertEquals(string, texto);
    }

//Hooks//
    @After (order = 1, value = "@funcionais")
    public void screenshot(Scenario cenario) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File ("target/screenshots/"+cenario.getId()+".jpg"));
    }
    @After (order = 0, value = "@funcionais")
    public void fecharBrowser() {
        driver.quit();
        System.out.println("Terminando");
    }
}
