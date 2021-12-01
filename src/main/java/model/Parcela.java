/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Wanderson_M
 */
public class Parcela {

    private int numero;
    private float valor;
    private LocalDate dataVencimento;
    private float juros;
    private float desconto;
    private LocalDate dataPagamento;
    private int id;

    public Parcela(int numero, float valor, LocalDate dataVencimento, Float juros, float desconto, LocalDate dataPagamento, int id) {
        this.numero = numero;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.juros = juros;
        this.desconto = desconto;
        this.dataPagamento = dataPagamento;
        this.id = id;
    }

    public Parcela() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Float getJuros() {
        return juros;
    }

    public void setJuros(Float juros) {
        this.juros = juros;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
