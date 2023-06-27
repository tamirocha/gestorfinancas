package com.gestorfinancas.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private BigDecimal saldo;

    @NotNull
    @Column(name = "limite_saque_diario")
    private BigDecimal limiteSaqueDiario;

    @NotNull
    @Column(name = "flag_ativo")
    private boolean flagAtivo;

    @NotNull
    @Column(name = "tipo_conta")
    private int tipoConta;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "codigo_pessoa")
    private Pessoa pessoa;


    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public boolean isFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}




