package br.com.fiap.asseguravel.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_IMOVEL", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NR_REGISTRO", columnNames = "NR_REGISTRO_CART")

})
public class Imovel {

    @Column(name = "NR_QTD_QUARTO")
    private int qtdQuartos;
    @Column(name = "NR_QTD_BANHEIRO")
    private int qtdBanheiros;
    @Column(name = "QTD_VAGA_GARAGEM")
    private int intQtdVagasDeGaragem;
    @Column(name = "NR_REGISTRO_CART")
    private String numeroRegistroNoCartorio;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_PROPRIETARIO",
            joinColumns = {
                    @JoinColumn(
                            name = "ID_IMOVEL",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(name = "FK_IMOVEL")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ID_PROPRIETARIO",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(name = "FK_PROPRIETARIO")
                    )
            }
    )
    protected Set<Pessoa> proprietarios = new LinkedHashSet<>();


    public Imovel() {
    }

    public Imovel(int qtdQuartos, int qtdBanheiros, int intQtdVagasDeGaragem, String numeroRegistroNoCartorio) {
        this.qtdQuartos = qtdQuartos;
        this.qtdBanheiros = qtdBanheiros;
        this.intQtdVagasDeGaragem = intQtdVagasDeGaragem;
        this.numeroRegistroNoCartorio = numeroRegistroNoCartorio;
    }

    public int getQtdQuartos() {
        return qtdQuartos;
    }

    public Imovel setQtdQuartos(int qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
        return this;
    }

    public int getQtdBanheiros() {
        return qtdBanheiros;
    }

    public Imovel setQtdBanheiros(int qtdBanheiros) {
        this.qtdBanheiros = qtdBanheiros;
        return this;
    }

    public int getIntQtdVagasDeGaragem() {
        return intQtdVagasDeGaragem;
    }

    public Imovel setIntQtdVagasDeGaragem(int intQtdVagasDeGaragem) {
        this.intQtdVagasDeGaragem = intQtdVagasDeGaragem;
        return this;
    }

    public String getNumeroRegistroNoCartorio() {
        return numeroRegistroNoCartorio;
    }

    public Imovel setNumeroRegistroNoCartorio(String numeroRegistroNoCartorio) {
        this.numeroRegistroNoCartorio = numeroRegistroNoCartorio;
        return this;
    }


    public Set<Pessoa> getProprietarios() {
        return Collections.unmodifiableSet(proprietarios);
    }


    public Imovel addProprietario(Pessoa pessoa) {
        this.proprietarios.add(pessoa);
        return this;
    }


    public Imovel removerProprietario(Pessoa pessoa) {
        this.proprietarios.remove(pessoa);
        return this;
    }


    @Override
    public String toString() {
        return "Imovel{" +
                "qtdQuartos=" + qtdQuartos +
                ", qtdBanheiros=" + qtdBanheiros +
                ", intQtdVagasDeGaragem=" + intQtdVagasDeGaragem +
                ", numeroRegistroNoCartorio='" + numeroRegistroNoCartorio + '\'' +
                ", proprietarios=" + proprietarios +
                '}';
    }
}
