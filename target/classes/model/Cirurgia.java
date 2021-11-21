package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cirurgia extends Conta {

    private EquipeCirurgica equipeCirugica;
    private LocalDate data;
    private LocalTime hora;
    private double valor;
    private String relatorio;
    private Acomodacao salaCirurgia;
    private Prontuario prontuario;
    private int id;
    private int salaCirurgicaId;
    private int equipeCirurgicaId;

    public Cirurgia() {
    }

    public EquipeCirurgica getEquipeCirugica() {
        return equipeCirugica;
    }

    public void setEquipeCirugica(EquipeCirurgica equipeCirugica) {
        this.equipeCirugica = equipeCirugica;
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

    public Acomodacao getSalaCirurgia() {
        return salaCirurgia;
    }

    public void setSalaCirurgia(Acomodacao salaCirurgia) {
        this.salaCirurgia = salaCirurgia;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalaCirurgicaId() {
        return salaCirurgicaId;
    }

    public void setSalaCirurgicaId(int salaCirurgicaId) {
        this.salaCirurgicaId = salaCirurgicaId;
    }

    public int getEquipeCirurgicaId() {
        return equipeCirurgicaId;
    }

    public void setEquipeCirurgicaId(int equipeCirurgicaId) {
        this.equipeCirurgicaId = equipeCirurgicaId;
    }


    
    
}
