package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exame extends Conta {

    private String Tipo;
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    private String relatorio;
    private Acomodacao salaExame;
    private Prontuario prontuario;
    private int salaExameId;
    private int id;

    public Exame() {
    }

    public Exame(String Tipo, LocalDate data, LocalTime hora, double valor, String relatorio, Acomodacao salaExame, Prontuario prontuario, int salaExameId, int id) {
        this.Tipo = Tipo;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.relatorio = relatorio;
        this.salaExame = salaExame;
        this.prontuario = prontuario;
        this.salaExameId = salaExameId;
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Acomodacao getSalaExame() {
        return salaExame;
    }

    public void setSalaExame(Acomodacao salaExame) {
        this.salaExame = salaExame;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public int getSalaExameId() {
        return salaExameId;
    }

    public void setSalaExameId(int salaExameId) {
        this.salaExameId = salaExameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
