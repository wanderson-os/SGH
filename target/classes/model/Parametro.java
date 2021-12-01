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
public class Parametro {

    private int quantidadeDeParcelas;
    private float jurosPorcentagem;
    private float descontoPorcentagem;

    public Parametro(int quantidadeDeParcelas, float jurosPorcentagem, float descontoPorcentagem) {
        this.quantidadeDeParcelas = quantidadeDeParcelas;
        this.jurosPorcentagem = jurosPorcentagem;
        this.descontoPorcentagem = descontoPorcentagem;
    }

    public Parametro() {
    }

    public int getQuantidadeDeParcelas() {
        return quantidadeDeParcelas;
    }

    public void setQuantidadeDeParcelas(int quantidadeDeParcelas) {
        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }

    public float getJurosPorcentagem() {
        return jurosPorcentagem;
    }

    public void setJurosPorcentagem(float jurosPorcentagem) {
        this.jurosPorcentagem = jurosPorcentagem;
    }

    public float getDescontoPorcentagem() {
        return descontoPorcentagem;
    }

    public void setDescontoPorcentagem(float descontoPorcentagem) {
        this.descontoPorcentagem = descontoPorcentagem;
    }
    
    

}
