/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filho;

import view.mae.Pessoa;
import dao.FuncionarioDao;
import dao.PacienteDao;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Paciente;

/**
 *
 * @author Wanderson_M
 */
public class PessoaDeletar extends Pessoa {

    javax.swing.JButton btnSalvar, btnPCbx, btnACbx;
    JComboBox cbxPessoa;
    ArrayList<model.Pessoa> pessoas;
    FuncionarioDao funcionarioDao;
    PacienteDao pacienteDao;
    String funcao, painel;
    private JButton jbExcluir;

    public PessoaDeletar(String painel, String funcao) {
        super(painel, funcao);
        this.funcao = funcao;
        this.painel = painel;
        if (painel == "funcionario") {
            funcionarioDao = new FuncionarioDao();
            pessoas = funcionarioDao.listarFuncao(funcao);
            funcionario();
        } else {
            pacienteDao = new PacienteDao();
            pessoas = pacienteDao.listar();
            paciente();

        }
        btnSalvar = new javax.swing.JButton();
        btnSalvar.setBounds(9, 500, 70, 25);
        this.setLayout(null);
        this.add(btnSalvar);
        cbxPessoa = new JComboBox();
        cbxPessoa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        cbxPessoa.setBounds(10, 20, 180, 30);
        btnACbx = new JButton();
        btnACbx.setText("Anterior");
        btnACbx.setBounds(200, 20, 100, 30);
        btnPCbx = new JButton();
        btnPCbx.setText("Proxímo");
        btnPCbx.setBounds(320, 20, 100, 30);

        this.add(btnPCbx);
        this.add(btnACbx);
        this.add(cbxPessoa);
        
        instanciaBotaoAcao("Excluir");
        SalvarBotoes();
        addItens();
        EditableOff();

    }

    private void funcionario() {
        this.setSize(450, 550);
        JDesktop.setBounds(0, 50, 560, 550);

    }

    private void paciente() {
        this.setSize(450, 450);
        JDesktop.setBounds(0, 50, 520, 450);

    }

    @Override
    public void jbAcaoActionPerformed(ActionEvent ae, String string) {
        int i = 0;
        int e = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "", JOptionPane.OK_CANCEL_OPTION);
        if (e == JOptionPane.OK_OPTION) {

            if ("paciente".equals(getTfFuncao().getText())) {
                i = pacienteDao.excluir((Paciente) pessoas.get(cbxPessoa.getSelectedIndex()));

                if (i == 1) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir paciente !");

                } else if (i == 2) {
                    JOptionPane.showMessageDialog(this, "Excluido com sucesso !");
                    dispose();

                }
            } else {
                i = funcionarioDao.excluir((Funcionario) pessoas.get(cbxPessoa.getSelectedIndex()));
                if (i == 1) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir funcionario");

                } else if (i == 2) {
                    JOptionPane.showMessageDialog(this, "Excluido com sucesso !");
                    dispose();

                }

            }

        }

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
        getTfFuncao().setText("paciente");
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

    public void EditableOff() {

        getTfNome().setEditable(false);
        getJftfCpf().setEditable(false);
        getTfSobrenome().setEditable(false);
        getJftfTelefone().setEditable(false);
        getJftfDataNascimento().setEditable(false);
        getTfLogradouro().setEditable(false);
        getTfNumero().setEditable(false);
        getTfBairro().setEditable(false);
        getTfComplemento().setEditable(false);
        getCbxUf().setEditable(false);
        getJftfCep().setEditable(false);
        getFtfDataInscricao().setEditable(false);
        getFtfCtps().setEditable(false);
        getTfEspecialidade().setEditable(false);
        getFtfRegistroProfissional().setEditable(false);
        getRbMasculino().setEnabled(false);
        getRbFeminino().setEnabled(false);

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

}
