import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumber {

    @Given("que criei o arquivo corretamente")
    public void que_criei_um_arquivo_corretamente() {
        System.out.println("Qualquer coisa");
    }

    @When("executá-lo")
    public void executa_lo() {
        System.out.println("passo 2");
    }

    @Then("a especificação deve finalizar com sucesso")
    public void a_especificacao_deve_finalizar_com_sucesso() {
    }

    private int contador = 0;

    @Given("que o valor do contador é 15")
    public void queOValorDoContadorÉ() {
        contador = 15;
    }
    @When("eu incrementar em 3")
    public void euIncrementarEm() {
        contador = contador + 3;
    }
    @Then("o valor do contador será 18")
    public void oValorDoContadorSerá() {
        Assert.assertEquals(18, contador);
    }

    @Given("que o valor do contador é 123")
    public void que_o_valor_do_contador_é() {
        contador = 123;
    }
    @When("eu incrementar em 35")
    public void eu_incrementar_em() {
        contador = contador + 35;
    }
    @Then("o valor do contador será 158")
    public void o_valor_do_contador_será() {
        Assert.assertEquals(158, contador);
    }

    Date entrega = new Date();

    @Given("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
    public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }
    @When("^a entrega atrasar em (\\d+) dias$")
    public void aEntregaAtrasarEmDias(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }
    @Then("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }
}
