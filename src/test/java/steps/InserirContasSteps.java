package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private WebDriver driver;
    @Given("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }
    @When("informo o usuário {string}")
    public void informoOUsuário(String string) {
        driver.findElement(By.id("email")).sendKeys(string);
    }
    @When("a senha {string}")
    public void aSenha(String string) {
        driver.findElement(By.name("senha")).sendKeys(string);
    }
    @When("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("visualizo a página inicial")
    public void visualizoAPáginaInicial() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, Ariane!", texto);
    }
    @When("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }
    @When("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }
    @When("informo a conta {string}")
    public void informoAConta(String arg1) {
       driver.findElement(By.id("nome")).sendKeys(arg1);
    }
    @When("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("a conta é inserida com sucesso")
    public void aContaÉInseridaComSucesso() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
    @Then("sou notificado que o nome da conta é obrigatório")
    public void souNotificadoQueONomeDaContaÉObrigatório() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Informe o nome da conta", texto);
    }
    @Then("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);
    }
    @Then("recebo a mensagem {string}")
    public void receboAMensagem(String string) {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-']")).getText();
        Assert.assertEquals(string, texto);
    }

    @Before
    public void inicio() {
        System.out.println("Começando aqui");
    }

    @After
    public void fecharBrowser() {
        driver.quit();
        System.out.println("Terminando");
    }
}
