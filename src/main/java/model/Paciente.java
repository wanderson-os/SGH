package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {

    private float peso;

    public Paciente(float peso, String nome, String sobrenome, String cpf, String telefone, char sexo, LocalDate dataNasc, Endereco endereco) {
        super(nome, sobrenome, cpf, telefone, sexo, dataNasc, endereco);
        this.peso = peso;
    }

    public Paciente() {
    }

  

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
