
package model;
public class Acomodacao {

	private int numero;

	private String tipo;

    public Acomodacao(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public Acomodacao() {
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
    

}
