package model;

public class Endereco {

    private String bairro;

    private int numero;

    private String logradouro;

    private String uf;

    private String complemento;
    private String cep;
    private int id;
    private String cpf_pessoa;

    public Endereco() {
    }

    public Endereco(String bairro, int numero, String logradouro, String uf, String complemento, String cep, int id, String cpf_pessoa) {
        this.bairro = bairro;
        this.numero = numero;
        this.logradouro = logradouro;
        this.uf = uf;
        this.complemento = complemento;
        this.cep = cep;
        this.id = id;
        this.cpf_pessoa = cpf_pessoa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }

}
