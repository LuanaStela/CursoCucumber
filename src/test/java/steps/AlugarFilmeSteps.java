package steps;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import servicos.AluguelService;
import io.cucumber.datatable.DataTable;


public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    @Given("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Given("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPrecoDoAluguelSejaR$(int int1) {
        filme.setAluguel(int1);
    }

    @Given("um filme")
    public void umFilme(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setAluguel(Integer.parseInt(map.get("preco")));
        String tipo = map.get("tipo");
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;

    }
/*    @Then("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
*/
    @When("^alugar$")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Then("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int int1) {
        Assertions.assertEquals(int1, nota.getPreco());
    }

    @Then("^o estoque do filme será (\\d+) unidades$")
    public void oEstoqueDoFilmeSeráUnidades(Integer int1) {
        Assertions.assertEquals(int1, filme.getEstoque());
    }

    @Then("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assertions.assertEquals("Filme sem estoque", erro);
    }

    @Given("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
    }
    @Then("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(int int1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(int1);
/***/   Date dataReal = (Date) nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }
    @Then("^a pontuação será de (\\d+) pontos$")
    public void aPontuaçãoSeráDePontos(int int1) {
        Assert.assertEquals(int1, nota.getPontuacao());
    }

}
