package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alta {

	private LocalDate data;

	private LocalTime hora;

	private Paciente paciente;

	private Funcionario medico;

    public Alta(LocalDate data, LocalTime hora, Paciente paciente, Funcionario medico) {
        this.data = data;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Alta() {
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Funcionario getMedico() {
        return medico;
    }

    public void setMedico(Funcionario medico) {
        this.medico = medico;
    }

        
        
}
