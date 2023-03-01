package steps;

import entidades.Filme;
import entidades.NotaAluguel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import servicos.AluguelService;
import utils.DateUtils;

import java.util.Calendar;


public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private String tipoAluguel;

    @Given("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Given("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }

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
       Assert.assertEquals(int1, nota.getPreco());
    }

    @Then("^o estoque do filme será (\\d+) unidades$")
    public void oEstoqueDoFilmeSeráUnidades(int int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Then("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assertions.assertEquals("Filme sem estoque", erro);
    }

    @Given("^que o tipo do aluguel seja (.*)$")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo;
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
