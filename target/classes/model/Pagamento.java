/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Wanderson_M
 */
public class Pagamento {

    private Prontuario prontuario;
    private String tipo;
    private ArrayList<Parcela> parcelas;
    private int id;

    public Pagamento(Prontuario prontuario, String tipo, int id, ArrayList<Parcela> parcelas) {
        this.prontuario = prontuario;
        this.tipo = tipo;
        this.id = id;
        this.parcelas = parcelas;
    }

    public Pagamento() {
        parcelas = new ArrayList();
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(ArrayList<Parcela> parcelas) {
        this.parcelas = parcelas;
    }

    public void addParcela(Parcela p) {
        parcelas.add(p);

    }

}
