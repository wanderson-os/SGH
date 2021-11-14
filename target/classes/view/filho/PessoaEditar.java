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
import dao.PacienteDao;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Funcionario;
import model.Paciente;

/**
 *
 * @author Wanderson_M
 */
public class PessoaEditar extends Pessoa {

    javax.swing.JButton btnPCbx, btnACbx;
    JComboBox cbxPessoa;
    JLabel jlSelecione;
    ArrayList<model.Pessoa> pessoas;
    FuncionarioDao funcionarioDao;
    PacienteDao pacienteDao;
    String painel;
    private JButton jbSalvar;
    private String nome, sobrenome, cpf, telefone, ctps, funcao, registroProfissional, especialidade;
    float peso;
    private char sexo;
    LocalDate dataInscricao, dataNasc;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    GerenciaFuncionario gerenciaFuncionario;
    GerenciaPaciente gerenciaPaciente;
    EnderecoDao enderecoDao;

    public PessoaEditar(String painel, String funcao) {
        super(painel, funcao);
        this.funcao = funcao;
        this.painel = painel;
        if (painel == "funcionario") {
            funcionarioDao = new FuncionarioDao();
            pessoas = funcionarioDao.listar(funcao);
            funcionario();
        } else {
            pacienteDao = new PacienteDao();
            pessoas = pacienteDao.listar();
            paciente();

        }
        enderecoDao = new EnderecoDao();
        funcionarioDao = new FuncionarioDao();
        gerenciaFuncionario = new GerenciaFuncionario();
        gerenciaPaciente = new GerenciaPaciente();
        this.setLayout(null);
        cbxPessoa = new JComboBox();
        cbxPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        cbxPessoa.setBounds(100, 20, 180, 30);
        btnACbx = new JButton();
        btnACbx.setText("Anterior");
        btnACbx.setBounds(300, 20, 100, 30);

        btnPCbx = new JButton();
        btnPCbx.setText("Proxímo");
        btnPCbx.setBounds(400, 20, 100, 30);

        this.add(btnPCbx);
        this.add(btnACbx);
        this.add(cbxPessoa);
        jlSelecione = new JLabel();
        jlSelecione.setText("Selecione !");
        jlSelecione.setBounds(10, 20, 70, 30);
        add(jlSelecione);
        instanciaBotaoAcao("Alterar dados");
        SalvarBotoes();
        addItens();

    }

    private void funcionario() {
        this.setSize(540, 560);
        JDesktop.setBounds(0, 50, 560, 550);

    }

    private void paciente() {
        this.setSize(540, 450);
        JDesktop.setBounds(0, 50, 520, 450);

    }

    @Override
    public void jbAcaoActionPerformed(ActionEvent ae, String string) {

        PegaCampos();

        switch (painel) {
            case "paciente":
                Paciente paciente = (Paciente) pessoas.get(cbxPessoa.getSelectedIndex());
                paciente.setCpf(cpf);
                paciente.setDataNasc(dataNasc);
                paciente.setNome(nome);
                paciente.setSexo(sexo);
                paciente.setSobrenome(sobrenome);
                paciente.setTelefone(telefone);
                paciente.setEndereco(endereco(paciente));
                int r = gerenciaPaciente.alterar(paciente);
                if (r == 2) {
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados !");

                }
                break;
            case "funcionario":
                Funcionario funcionario = (Funcionario) pessoas.get(cbxPessoa.getSelectedIndex());
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
                funcionario.setEndereco(endereco(funcionario));
                int rf = gerenciaFuncionario.alterar(funcionario);

                if (rf == 2) {
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar dados !");

                }

        }

    }

    public Endereco endereco(model.Pessoa p) {
        Endereco endereco;
        try {
            endereco = new Endereco(getTfBairro().getText(), Integer.parseInt(getTfNumero().getText()), getTfLogradouro().getText(),
                    getCbxUf().getSelectedItem().toString(), getTfComplemento().getText(), getJftfCep().getText(), p.getEndereco().getId(), p.getCpf());
        } catch (Exception e) {
            endereco = null;
        }

        return endereco;
    }

    public void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
        if (painel == "funcionario") {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            Funcionario funcionario = (Funcionario) pessoas.get(cbxPessoa.getSelectedIndex());
            preencheCamposPessoa(funcionario);
            getFtfDataInscricao().setText(fmt.format(Date.valueOf(funcionario.getDataInscricao())));
            getFtfCtps().setText(funcionario.getCtps());
            getTfEspecialidade().setText(funcionario.getEspecialidade());
            getFtfRegistroProfissional().setText(funcionario.getRegistroProfissional());
            getTfFuncao().setText(funcionario.getFuncao());

        } else if (painel == "paciente") {
            Paciente paciente = (Paciente) pessoas.get(cbxPessoa.getSelectedIndex());
            preencheCamposPessoa(paciente);

        }

    }

    public void addItens() {
        if (pessoas == null || pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cadastro encontrado !");
            jbAcao.setEnabled(false);
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                cbxPessoa.addItem(pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome());
            }
            btnPCbx.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPCbxActionPerformed(evt);
                }
            });
            btnACbx.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnACbxActionPerformed(evt);
                }
            });

        }
    }

    public void preencheCamposPessoa(model.Pessoa p) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        getTfNome().setText(p.getNome());
        getJftfCpf().setText(p.getCpf());
        getTfSobrenome().setText(p.getSobrenome());
        getJftfTelefone().setText(p.getTelefone());
        getJftfDataNascimento().setText(fmt.format(Date.valueOf(p.getDataNasc())));
        getTfLogradouro().setText(p.getEndereco().getLogradouro());
        getTfNumero().setText(String.valueOf(p.getEndereco().getNumero()));
        getTfBairro().setText(p.getEndereco().getBairro());
        getTfComplemento().setText(p.getEndereco().getComplemento());
        getCbxUf().setSelectedItem(p.getEndereco().getUf());
        getJftfCep().setText(p.getEndereco().getCep());
        if (p.getSexo() == 'M') {
            getRbMasculino().setSelected(true);
        } else {
            getRbFeminino().setSelected(true);
        }
    }

    public void btnPCbxActionPerformed(ActionEvent evt) {
        if (cbxPessoa.getSelectedIndex() + 1 >= cbxPessoa.getItemCount()) {
            cbxPessoa.setSelectedIndex(0);
        } else {

            cbxPessoa.setSelectedIndex(cbxPessoa.getSelectedIndex() + 1);
        }

    }

    public void btnACbxActionPerformed(ActionEvent evt) {
        if (cbxPessoa.getSelectedIndex() - 1 < 0) {
            cbxPessoa.setSelectedIndex(cbxPessoa.getItemCount() - 1);
        } else {

            cbxPessoa.setSelectedIndex(cbxPessoa.getSelectedIndex() - 1);
        }

    }

    public void PegaCampos() {

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

    }

}
