package model;

import java.time.LocalDate;

public class Encaminhamento {

	private LocalDate data;

	private Funcionario medico;

	private Paciente paciente;

	private String descricao;

    public Encaminhamento(LocalDate data, Funcionario medico, Paciente paciente, String descricao) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.descricao = descricao;
    }

    public Encaminhamento() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Funcionario getMedico() {
        return medico;
    }

    public void setMedico(Funcionario medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

        
        
}
