/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Wanderson_M
 */
public class Pessoa extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pessoa
     */
    private boolean CadastrouEndereco = false;
    public Pessoa(String painel,String funcao) {
        initComponents();
        jpPaciente.setVisible(false);
        jpFuncionario.setVisible(false);
        visivel(painel);
        tfFuncao.setText(funcao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        jpPaciente = new javax.swing.JPanel();
        jlPeso = new javax.swing.JLabel();
        tfPeso = new javax.swing.JTextField();
        jpFuncionario = new javax.swing.JPanel();
        ftfCtps = new javax.swing.JFormattedTextField();
        jlCtps = new javax.swing.JLabel();
        jlFuncao = new javax.swing.JLabel();
        jlRegistroProfissional = new javax.swing.JLabel();
        ftfRegistroProfissional = new javax.swing.JFormattedTextField();
        ljDataInscricao = new javax.swing.JLabel();
        ftfDataInscricao = new javax.swing.JFormattedTextField();
        jlEspecialidade = new javax.swing.JLabel();
        tfEspecialidade = new javax.swing.JTextField();
        tfFuncao = new javax.swing.JTextField();
        btnCadastrarEndereco = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jpPessoa = new javax.swing.JPanel();
        jlCpf = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlSobrenome = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        jlDataNascimento = new javax.swing.JLabel();
        jftfDataNascimento = new javax.swing.JFormattedTextField();
        jftfTelefone = new javax.swing.JFormattedTextField();
        tfSobrenome = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        jftfCpf = new javax.swing.JFormattedTextField();
        jlSexo = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();

        jlPeso.setText("Peso");

        javax.swing.GroupLayout jpPacienteLayout = new javax.swing.GroupLayout(jpPaciente);
        jpPaciente.setLayout(jpPacienteLayout);
        jpPacienteLayout.setHorizontalGroup(
            jpPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpPacienteLayout.setVerticalGroup(
            jpPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPacienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPeso)
                    .addComponent(tfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        try {
            ftfCtps.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlCtps.setText("CTPS");

        jlFuncao.setText("Função");

        jlRegistroProfissional.setText("Registro Profissional");

        try {
            ftfRegistroProfissional.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        ljDataInscricao.setText("Data da Inscriçao");

        try {
            ftfDataInscricao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlEspecialidade.setText("Especialidade");

        tfFuncao.setEditable(false);

        javax.swing.GroupLayout jpFuncionarioLayout = new javax.swing.GroupLayout(jpFuncionario);
        jpFuncionario.setLayout(jpFuncionarioLayout);
        jpFuncionarioLayout.setHorizontalGroup(
            jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFuncao)
                            .addComponent(jlCtps))
                        .addGap(50, 50, 50)
                        .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ftfCtps, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tfFuncao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ljDataInscricao)
                            .addComponent(jlRegistroProfissional)))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jlEspecialidade)
                        .addGap(18, 18, 18)
                        .addComponent(tfEspecialidade)))
                .addGap(18, 18, 18)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ftfRegistroProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfDataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jpFuncionarioLayout.setVerticalGroup(
            jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfCtps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCtps)
                    .addComponent(ljDataInscricao)
                    .addComponent(ftfDataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFuncao)
                    .addComponent(ftfRegistroProfissional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlRegistroProfissional)
                    .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEspecialidade)
                    .addComponent(tfEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrarEndereco.setText("Cadastrar Endereço");
        btnCadastrarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarEnderecoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        jlCpf.setText("CPF");

        jlNome.setText("Nome");

        jlSobrenome.setText("Sobrenome");

        jlTelefone.setText("Telefone");

        jlDataNascimento.setText("Data de Nascimento");

        try {
            jftfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#.####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlSexo.setText("Sexo");

        bgSexo.add(rbMasculino);
        rbMasculino.setText("Masculino");

        bgSexo.add(rbFeminino);
        rbFeminino.setText("Feminino");

        javax.swing.GroupLayout jpPessoaLayout = new javax.swing.GroupLayout(jpPessoa);
        jpPessoa.setLayout(jpPessoaLayout);
        jpPessoaLayout.setHorizontalGroup(
            jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPessoaLayout.createSequentialGroup()
                        .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSobrenome)
                            .addComponent(jlCpf)
                            .addComponent(jlNome))
                        .addGap(103, 103, 103)
                        .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jftfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlTelefone)
                    .addComponent(jlDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPessoaLayout.createSequentialGroup()
                        .addComponent(jlSexo)
                        .addGap(18, 18, 18)
                        .addComponent(rbMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbFeminino)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jpPessoaLayout.setVerticalGroup(
            jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPessoaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCpf)
                    .addComponent(jftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSobrenome)
                    .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTelefone)
                    .addComponent(jftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDataNascimento)
                    .addComponent(jftfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSexo)
                    .addComponent(rbMasculino)
                    .addComponent(rbFeminino))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelar)
                        .addGap(64, 64, 64)
                        .addComponent(btnCadastrarEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jpPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarEndereco)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (CadastrouEndereco) {
            System.out.println("Clicou");
        }
        else
            System.out.println("Não clicou");
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCadastrarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarEnderecoActionPerformed
CadastrouEndereco = true;

    }//GEN-LAST:event_btnCadastrarEnderecoActionPerformed

    public void visivel(String painel) {

        if (painel.equals("paciente")) {
            jpPaciente.setVisible(true);
        } else if (painel.equals("funcionario")) {
            jpFuncionario.setVisible(true);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JButton btnCadastrarEndereco;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField ftfCtps;
    private javax.swing.JFormattedTextField ftfDataInscricao;
    private javax.swing.JFormattedTextField ftfRegistroProfissional;
    private javax.swing.JFormattedTextField jftfCpf;
    private javax.swing.JFormattedTextField jftfDataNascimento;
    private javax.swing.JFormattedTextField jftfTelefone;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlCtps;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlEspecialidade;
    private javax.swing.JLabel jlFuncao;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlRegistroProfissional;
    private javax.swing.JLabel jlSexo;
    private javax.swing.JLabel jlSobrenome;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JPanel jpFuncionario;
    private javax.swing.JPanel jpPaciente;
    private javax.swing.JPanel jpPessoa;
    private javax.swing.JLabel ljDataInscricao;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField tfEspecialidade;
    private javax.swing.JTextField tfFuncao;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPeso;
    private javax.swing.JTextField tfSobrenome;
    // End of variables declaration//GEN-END:variables
}
