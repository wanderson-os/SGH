package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    
    private String ctps;
    private String funcao;
    private String especialidade;
    private String registroProfissional;
    private LocalDate dataInscricao;

    public Funcionario(String ctps, String funcao, String especialidade, String registroProfissional, LocalDate dataInscricao, String nome, String sobrenome, String cpf, String telefone, char sexo, LocalDate dataNasc, Endereco endereco) {
        super(nome, sobrenome, cpf, telefone, sexo, dataNasc, endereco);
        this.ctps = ctps;
        this.funcao = funcao;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.dataInscricao = dataInscricao;
    }

    public Funcionario() {
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public LocalDate getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    
    
    
    
    
    
       
}
