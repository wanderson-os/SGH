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
public class Juros {

    private int id;
    private float porcentagem;

    public Juros(int numero, float porcentagem) {
        this.id = numero;
        this.porcentagem = porcentagem;
    }

    public Juros() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(float porcentagem) {
        this.porcentagem = porcentagem;
    }

}
