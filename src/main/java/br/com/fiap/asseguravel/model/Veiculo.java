package br.com.fiap.asseguravel.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_VEICULO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NR_CHASSI", columnNames = "NR_CHASSI"),
        @UniqueConstraint(name = "UK_NR_PLACA", columnNames = "NR_PLACA")
})
public class Veiculo {

    @Column(name = "NR_CHASSI")
    private String chassis;
    @Column(name = "NR_PLACA")
    private String placa;
    @Column(name = "DS_MODELO")
    private String modelo;
    @Column(name = "DT_DATA_FABRIC")
    private int anoDeFabricacao;
    @Column(name = "NM_FABRICANTE")
    private String fabricante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA",
        foreignKey = @ForeignKey(name = "FK_VEICULO_PROPRIETARIO", value = ConstraintMode.CONSTRAINT)
    )
    private Pessoa proprietario;

    public Veiculo() {
    }

    public Veiculo(String chassis, String placa, String modelo, int anoDeFabricacao, String fabricante, Pessoa proprietario) {
        this.chassis = chassis;
        this.placa = placa;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.fabricante = fabricante;
        this.proprietario = proprietario;
    }

    public String getChassis() {
        return chassis;
    }

    public Veiculo setChassis(String chassis) {
        this.chassis = chassis;
        return this;
    }

    public String getPlaca() {
        return placa;
    }

    public Veiculo setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Veiculo setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public Veiculo setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
        return this;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Veiculo setFabricante(String fabricante) {
        this.fabricante = fabricante;
        return this;
    }


    public Pessoa getProprietario() {
        return proprietario;
    }

    public Veiculo setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
        return this;
    }
}
