import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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

    @Given("que o valor do contador é 15")
    public void queOValorDoContadorÉ(Integer int1) {
        contador = 15;
    }

    @When("eu incrementar em 3")
    public void euIncrementarEm(Integer int1) {
        contador = contador + 3;
    }

    @Then("o valor do contador será 18")
    public void oValorDoContadorSerá(Integer int1) {
        Assert.assertEquals(18, contador);
    }

    @Given("que o valor do contador é 123")
    public void queOValorDoContadorÉ() {
        contador = 123;
    }

    @When("eu incrementar em 35")
    public void euIncrementarEm() {
        contador = contador + 35;
    }

    @Then("o valor do contador será 158")
    public void oValorDoContadorSerá() {
        Assert.assertEquals(158, contador);
    }

    Date entrega = new Date();

    @Given("que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
    public void queAEntregaÉDia(int dia, int mes, int ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }

    @When("a entrega atrasar em (\\d+) dias$")
    public void aEntregaAtrasarEmDias(int int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }

    @Then("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);

    }
}
