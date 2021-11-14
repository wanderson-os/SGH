/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Wanderson_M
 */
public class CpfF {

    private String cirurgiaoPrincipal;

    private String cirurgiaoAssistente;

    private String enfermeiroChefe;

    private String anestesista;

    private String instrumentador;

    private String circulante;
    private int id;

    public CpfF(String cirurgiaoPrincipal, String cirurgiaoAssistente, String enfermeiroChefe, String anestesista, String instrumentador, String circulante, int id) {
        this.cirurgiaoPrincipal = cirurgiaoPrincipal;
        this.cirurgiaoAssistente = cirurgiaoAssistente;
        this.enfermeiroChefe = enfermeiroChefe;
        this.anestesista = anestesista;
        this.instrumentador = instrumentador;
        this.circulante = circulante;
        this.id = id;
    }

    public String getCirurgiaoPrincipal() {
        return cirurgiaoPrincipal;
    }

    public void setCirurgiaoPrincipal(String cirurgiaoPrincipal) {
        this.cirurgiaoPrincipal = cirurgiaoPrincipal;
    }

    public String getCirurgiaoAssistente() {
        return cirurgiaoAssistente;
    }

    public void setCirurgiaoAssistente(String cirurgiaoAssistente) {
        this.cirurgiaoAssistente = cirurgiaoAssistente;
    }

    public String getEnfermeiroChefe() {
        return enfermeiroChefe;
    }

    public void setEnfermeiroChefe(String enfermeiroChefe) {
        this.enfermeiroChefe = enfermeiroChefe;
    }

    public String getAnestesista() {
        return anestesista;
    }

    public void setAnestesista(String anestesista) {
        this.anestesista = anestesista;
    }

    public String getInstrumentador() {
        return instrumentador;
    }

    public void setInstrumentador(String instrumentador) {
        this.instrumentador = instrumentador;
    }

    public String getCirculante() {
        return circulante;
    }

    public void setCirculante(String circulante) {
        this.circulante = circulante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  
}
