/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciaMedicamento;
import dao.MedicamentoDao;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Wanderson_M
 */
public class Medicamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form Medicamento
     */
    String nome;
    MedicamentoDao md;
    GerenciaMedicamento gm;
    ArrayList<model.Medicamento> medicamentos;

    public Medicamento() {
        initComponents();
        md = new MedicamentoDao();
        gm = new GerenciaMedicamento();
        jpCampos.setVisible(false);
        jpCbx.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jpCbx = new javax.swing.JPanel();
        cbxMedicamentos = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jpCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jsQuantidade = new javax.swing.JSpinner();
        btnAcao = new javax.swing.JButton();
        tfPreco = new javax.swing.JTextField();

        setClosable(true);

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/create.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/read.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/update.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        cbxMedicamentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMedicamentosItemStateChanged(evt);
            }
        });

        jToggleButton1.setText("<<");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText(">>");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCbxLayout = new javax.swing.GroupLayout(jpCbx);
        jpCbx.setLayout(jpCbxLayout);
        jpCbxLayout.setHorizontalGroup(
            jpCbxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCbxLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpCbxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbxMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpCbxLayout.createSequentialGroup()
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpCbxLayout.setVerticalGroup(
            jpCbxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCbxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jpCbxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addContainerGap())
        );

        jLabel1.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Quantidade");

        jsQuantidade.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCamposLayout = new javax.swing.GroupLayout(jpCampos);
        jpCampos.setLayout(jpCamposLayout);
        jpCamposLayout.setHorizontalGroup(
            jpCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNome)
                    .addGroup(jpCamposLayout.createSequentialGroup()
                        .addGroup(jpCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jsQuantidade)
                            .addComponent(tfPreco))
                        .addGap(0, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpCamposLayout.setVerticalGroup(
            jpCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCamposLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAcao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastrar)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnCadastrar)
                .addGap(45, 45, 45)
                .addComponent(btnConsultar)
                .addGap(35, 35, 35)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        jpCampos.setVisible(true);
        jpCbx.setVisible(false);
        btnAcao.setText("Salvar");
        tfNome.setEditable(true);
        tfPreco.setEditable(true);
        tfNome.setText(null);
        tfPreco.setText(null);
        jsQuantidade.setValue(1);

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        jpCampos.setVisible(true);
        tfNome.setEditable(false);
        tfPreco.setEditable(false);
        jpCbx.setVisible(true);
        jsQuantidade.setEnabled(false);
        btnAcao.setText("Fechar");
        if (cbxMedicamentos.getItemCount() <= 0) {
            preencheCampos();
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        jpCampos.setVisible(true);
        jpCbx.setVisible(true);
        tfNome.setEditable(true);
        tfPreco.setEditable(true);
        btnAcao.setText("Alterar");
        jsQuantidade.setEnabled(true);

        if (cbxMedicamentos.getItemCount() <= 0) {
            preencheCampos();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        jpCampos.setVisible(true);
        tfNome.setEditable(false);
        tfPreco.setEditable(false);
        jpCbx.setVisible(true);
        jsQuantidade.setEnabled(false);
        if (cbxMedicamentos.getItemCount() <= 0) {
            preencheCampos();
        }
        btnAcao.setText("Excluir");    }//GEN-LAST:event_btnExcluirActionPerformed


    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        switch (btnAcao.getText()) {
            case "Salvar":
                model.Medicamento medicamento = new model.Medicamento();
                medicamento.setNome(tfNome.getText());
                medicamento.setPreco(Float.valueOf(tfPreco.getText()));
                medicamento.setQuantidade((int) jsQuantidade.getValue());
                int r = gm.cadastrar(medicamento);
                if (r != 1) {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar medicamento !");
                } else {
                    JOptionPane.showMessageDialog(this, "Cadastrado com sucesso !");
                    dispose();
                }

                break;
            case "Excluir":
                int e = JOptionPane.showConfirmDialog(this, "Deseja excluir ?", "", JOptionPane.OK_CANCEL_OPTION);
                if (e == JOptionPane.OK_OPTION) {
                    int re = gm.excluir(medicamentos.get(cbxMedicamentos.getSelectedIndex()));
                    if (re == 1) {
                        JOptionPane.showMessageDialog(this, "Medicamento excluido com sucesso !");
                        preencheCampos();
                    } else {

                        JOptionPane.showMessageDialog(this, "Erro ao excluir medicamento !");

                    }

                }
                break;
            case "Alterar":
                model.Medicamento m = medicamentos.get(cbxMedicamentos.getSelectedIndex());
                m.setNome(tfNome.getText());
                m.setPreco(Float.valueOf(tfPreco.getText()));
                m.setQuantidade((int) jsQuantidade.getValue());
                int rf = gm.alterar(m);
                if (rf == 1) {
                    JOptionPane.showMessageDialog(this, "Alterado com sucesso !");
                    preencheCampos();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar !");
                    dispose();
                }
                break;
            case "Fechar":

                int re = JOptionPane.showConfirmDialog(this, "Deseja Fechar ?", "", JOptionPane.OK_CANCEL_OPTION);

                if (re == JOptionPane.OK_OPTION) {
                    dispose();

                }
                break;

        }

    }//GEN-LAST:event_btnAcaoActionPerformed

    private void cbxMedicamentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMedicamentosItemStateChanged

        if (cbxMedicamentos == null || cbxMedicamentos.getItemCount() <= 0) {

        } else {
            model.Medicamento m = medicamentos.get(cbxMedicamentos.getSelectedIndex());
            tfNome.setText(m.getNome());
            tfPreco.setText(String.valueOf(m.getPreco()));

            jsQuantidade.setValue(m.getQuantidade());
            nome = tfNome.getText();

        }

//   if (!medicamentos.isEmpty()) {
//
//            SpinnerModel model = new SpinnerNumberModel(1, 1, medicamentos.get(cbxMedicamentos.getSelectedIndex()).getQuantidade(), 1);
//            jsQuantidade.setModel(model);
//        }

    }//GEN-LAST:event_cbxMedicamentosItemStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if (cbxMedicamentos.getSelectedIndex() + 1 >= cbxMedicamentos.getItemCount()) {
            cbxMedicamentos.setSelectedIndex(0);
        } else {

            cbxMedicamentos.setSelectedIndex(cbxMedicamentos.getSelectedIndex() + 1);
        }


    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (cbxMedicamentos.getSelectedIndex() - 1 < 0) {
            cbxMedicamentos.setSelectedIndex(cbxMedicamentos.getItemCount() - 1);
        } else {

            cbxMedicamentos.setSelectedIndex(cbxMedicamentos.getSelectedIndex() - 1);
        }


    }//GEN-LAST:event_jToggleButton1ActionPerformed

    public void preencheCampos() {
        medicamentos = md.listar();
        if (medicamentos == null || medicamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum medicamento cadastrado !");
        } else {
            cbxMedicamentos.removeAllItems();
            for (int i = 0; i < medicamentos.size(); i++) {
                cbxMedicamentos.addItem(medicamentos.get(i).getNome());
            }
        }

    }

    public void statosTextos() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cbxMedicamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPanel jpCampos;
    private javax.swing.JPanel jpCbx;
    private javax.swing.JSpinner jsQuantidade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    // End of variables declaration//GEN-END:variables
}
