/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filho;

import view.mae.Pessoa;
import controller.GerenciaFuncionario;
import controller.GerenciaPaciente;
import dao.EnderecoDao;
import dao.FuncionarioDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Funcionario;
import model.Paciente;

/**
 *
 * @author Wanderson_M
 */
public class PessoaCadastrar extends Pessoa {
    
    EnderecoDao enderecoDao;
    FuncionarioDao funcionarioDao;
    GerenciaFuncionario gerenciaFuncionario;
    GerenciaPaciente gerenciaPaciente;
    private String nome, sobrenome, cpf, telefone, ctps, funcao, registroProfissional, especialidade;
    float peso;
    private char sexo;
    LocalDate dataInscricao, dataNasc;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public PessoaCadastrar(String painel, String funcao) {
        super(painel, funcao);
        instanciaBotaoAcao("Salvar");
        initComponents(painel, funcao);
        enderecoDao = new EnderecoDao();
        funcionarioDao = new FuncionarioDao();
        gerenciaFuncionario = new GerenciaFuncionario();
        gerenciaPaciente = new GerenciaPaciente();
        
    }
    
    private void initComponents(String painel, String funcao) {
        
        if (painel.equals("paciente")) {
                    SalvarBotoes();


        } else if (painel.equals("funcionario")) {
            getTfFuncao().setText(funcao);
                    SalvarBotoes();

        }
    }
    
    public void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        
        JOptionPane.showMessageDialog(this, "Cancelar");
        
    }
    
    public void PegaCampos() {
        try {
            
        nome = getTfNome().getText();
        sobrenome = getTfSobrenome().getText();
        cpf = getJftfCpf().getText();
        dataNasc = LocalDate.parse(getJftfDataNascimento().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        telefone = getJftfTelefone().getText();
        ctps = getFtfCtps().getText();
        funcao = getTfFuncao().getText();
        registroProfissional = getFtfRegistroProfissional().getText();
        especialidade = getTfEspecialidade().getText();
        if (!especialidade.equals("")) {
            dataInscricao = LocalDate.parse(getFtfDataInscricao().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        peso = (float) getJsPeso().getValue();
        System.out.println("Valor" + peso);
        if (getRbMasculino().isSelected()) {
            sexo = 'M';
        } else if (getRbFeminino().isSelected()) {
            sexo = 'F';
        }
        
        } catch (Exception e) {
        }
        
    }
    
    @Override
    public void jbAcaoActionPerformed(ActionEvent ae, String painel) {
        
        PegaCampos();
        
        switch (painel) {
            case "paciente":
                Paciente paciente = new Paciente();
                paciente.setCpf(cpf);
                paciente.setDataNasc(dataNasc);
                paciente.setNome(nome);
                paciente.setSexo(sexo);
                paciente.setSobrenome(sobrenome);
                paciente.setTelefone(telefone);
                paciente.setEndereco(endereco(paciente.getCpf()));
                paciente.setPeso(peso);
                int rp = gerenciaPaciente.cadastrar(paciente);
                if (rp == 2) {
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso !");
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar");
                    
                }
                break;
            case "funcionario":
                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(cpf);
                funcionario.setCtps(ctps);
                funcionario.setDataInscricao(dataInscricao);
                funcionario.setDataNasc(dataNasc);
                funcionario.setEspecialidade(especialidade);
                funcionario.setFuncao(funcao);
                funcionario.setNome(nome);
                funcionario.setRegistroProfissional(registroProfissional);
                funcionario.setSexo(sexo);
                funcionario.setSobrenome(sobrenome);
                funcionario.setTelefone(telefone);
                funcionario.setEndereco(endereco(funcionario.getCpf()));
                int rf = gerenciaFuncionario.cadastrar(funcionario);
                if (rf == 2) {
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso !");
                    dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar");
                    
                }
        }
    }
    
    public Endereco endereco(String cfp_pessoa) {
        Endereco endereco;
        try {
            endereco = new Endereco(getTfBairro().getText(), Integer.parseInt(getTfNumero().getText()), getTfLogradouro().getText(),
                    getCbxUf().getSelectedItem().toString(), getTfComplemento().getText(), getJftfCep().getText(), enderecoDao.id(), cfp_pessoa);
        } catch (Exception e) {
            endereco = null;
        }
        
        return endereco;
    }
    
}
