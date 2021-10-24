package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {

	private LocalTime hora;

	private LocalDate data;

    public Horario(LocalTime hora, LocalDate data) {
        this.hora = hora;
        this.data = data;
    }

    public Horario() {
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

	
        
        
        
        
        public void horariosDisponiveis() {

	}

        
        
}
