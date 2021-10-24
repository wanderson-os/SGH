package model;
import java.util.ArrayList;
public class Agenda {

	private ArrayList<EscalaDeServico> escalas;

    public Agenda(ArrayList<EscalaDeServico> escalas) {
        this.escalas = escalas;
    }

    public Agenda() {
    }

    public ArrayList<EscalaDeServico> getEscalas() {
        return escalas;
    }

    public void setEscalas(ArrayList<EscalaDeServico> escalas) {
        this.escalas = escalas;
    }
        

}
