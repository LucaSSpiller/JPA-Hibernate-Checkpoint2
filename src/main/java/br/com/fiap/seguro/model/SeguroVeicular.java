package br.com.fiap.seguro.model;

import br.com.fiap.asseguravel.model.Veiculo;
import br.com.fiap.pessoa.model.Pessoa;

import java.time.LocalDate;

public class SeguroVeicular extends Seguro {

    private Veiculo objeto;

    public SeguroVeicular() {
    }

    public SeguroVeicular(Long id, LocalDate inicioVigencia, LocalDate fimVigencia, Pessoa contratante, Corretor corretor, Veiculo objeto) {
        super(id, inicioVigencia, fimVigencia, contratante, corretor);
        this.objeto = objeto;
    }

    public Veiculo getObjeto() {
        return objeto;
    }

    public SeguroVeicular setObjeto(Veiculo objeto) {
        this.objeto = objeto;
        return this;
    }

    @Override
    public String toString() {
        return "SeguroVeicular{" +
                "objeto=" + objeto +
                "} " + super.toString();
    }
}
