package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Prontuario {

    private Funcionario medico;
    private Paciente paciente;
    private LocalDate data;
    private LocalTime hora;
    private String diagnostico;
    private ArrayList<Medicamento> medicamentos;
    private ArrayList<Cirurgia> cirurgias;
    private ArrayList<Exame> exames;
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

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<Cirurgia> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(ArrayList<Cirurgia> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public void setExames(ArrayList<Exame> exames) {
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
