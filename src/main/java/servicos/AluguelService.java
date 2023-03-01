package servicos;

import entidades.Filme;
import entidades.NotaAluguel;
import io.cucumber.java.it.Date;
import utils.DateUtils;

public class AluguelService {
    public NotaAluguel alugar(Filme filme) {
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        nota.setDataEntrega((Date) DateUtils.obterDataDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;

    }
}
