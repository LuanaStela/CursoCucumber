import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.junit.ComparisonFailure;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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

    @When("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(int int1, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if(tempo.equals("dias")) {
            cal.add(Calendar.DAY_OF_MONTH, int1);
        }
        if(tempo.equals("meses")) {
            cal.add(Calendar.MONTH, int1);
        }
        entrega = cal.getTime();
    }
    @Then("a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals("Correto: ", data, dataFormatada);

    }

    @Given("que o prazo é dia {int}\\/{int}\\/{int}")
    public void queOPrazoÉDia(Integer int1, Integer int2, Integer int3) {
    }

    @Given("^que o ticket( especial)? é A.(\\d{3})$")
    public void queOTicketÉAF345(String tipo, String arg1) {
    }
    @Given("^que o valor da passagem é R\\$ (\\d+), (\\d+)$")
    public void queOValorDaPassagemÉR$(int arg1, int arg2) {
    }
    @Given("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String arg1) {
    }
    @Given("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) {
    }
    @When("^criar os steps$")
    public void criarOsSteps() {
    }
    @Then("^o teste vai funcionar$")
    public void oTesteVaiFuncionar() {
    }
    @Given("que o valor da passagem é R$ {double}")
    public void queOValorDaPassagemÉR$(Double double1) {
    }
    @Given("que o ticket é CD123")
    public void queOTicketÉCD123() {
    }
    @Given("que o ticket é AG1234")
    public void queOTicketÉAG1234() {
    }
    @Given("que o valor da passagem é R$ {double},{int}")
    public void queOValorDaPassagemÉR$(Double double1, Integer int1) {
    }

    @Given("que o telefone do passageiro é {int}-{int}")
    public void queOTelefoneDoPassageiroÉ(Integer int1, Integer int2) {

    }


}
