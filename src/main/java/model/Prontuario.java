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

}
