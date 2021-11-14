package model;

public class Acomodacao {

    private int numero;

    private String tipo;

    private int id;

    public Acomodacao() {
    }

    public Acomodacao(int numero, String tipo, int id) {
        this.numero = numero;
        this.tipo = tipo;
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

}
