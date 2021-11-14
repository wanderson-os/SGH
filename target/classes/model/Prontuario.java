package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Prontuario {

    private Funcionario medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;
    private String diagnostico;
    private Medicamento[] medicamentos;
    private Cirurgia[] cirurgias;
    private Exame[] exames;
    private Alta alta;
    private int id;

    public Prontuario() {
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

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Medicamento[] getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamento[] medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Cirurgia[] getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(Cirurgia[] cirurgias) {
        this.cirurgias = cirurgias;
    }

    public Exame[] getExames() {
        return exames;
    }

    public void setExames(Exame[] exames) {
        this.exames = exames;
    }

    public Alta getAlta() {
        return alta;
    }

    public void setAlta(Alta alta) {
        this.alta = alta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
}
