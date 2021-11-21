package model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Medicamento implements Cloneable {

    private String nome;
    private float preco;
    private int quantidade;
    private int id;

    public Medicamento(String nome, float preco, int quantidade, int id) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicamento() {
    }

    @Override
    public String toString() {
        return nome;
    }

    public Medicamento getClone() {
        try {
            return (Medicamento) super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Medicamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
