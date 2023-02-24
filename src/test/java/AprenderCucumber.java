import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AprenderCucumber {

    @Given("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {
        System.out.println("Qualquer coisa");
    }
    @When("executá-lo")
    public void executáLo() {
    }
    @Then("a especificação deve finalizar com sucesso")
    public void aEspecificaçãoDeveFinalizarComSucesso() {
    }

    private int contador = 0;

    @Given("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = int1;
    }
    @When("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador = contador + int1;
    }
    @Then("o valor do contador será {int}")
    public void oValorDoContadorSerá(Integer int1) {
        System.out.println(int1);
        System.out.println(contador);
        System.out.println(int1 == contador);
        Assert.assertTrue(int1 == contador);
    }
}
