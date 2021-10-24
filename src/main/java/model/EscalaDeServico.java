package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class EscalaDeServico {

	private Acomodacao sala;

	private Funcionario funcionario;

	private LocalTime horarioEntrada;

	private LocalTime horarioSaida;

	private LocalDate data;

    public EscalaDeServico(Acomodacao sala, Funcionario funcionario, LocalTime horarioEntrada, LocalTime horarioSaida, LocalDate data) {
        this.sala = sala;
        this.funcionario = funcionario;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.data = data;
    }

    public EscalaDeServico() {
    }

    public Acomodacao getSala() {
        return sala;
    }

    public void setSala(Acomodacao sala) {
        this.sala = sala;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

        
}
