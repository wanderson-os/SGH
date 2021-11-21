/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciaExame;
import dao.AcomodacaoDao;
import dao.ExameDao;
import dao.ProntuarioDao;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Acomodacao;

/**
 *
 * @author Wanderson_M
 */
public class ExameConsultar extends javax.swing.JInternalFrame {

    /**
     * Creates new form ExameCadastrar
     */
    dao.AcomodacaoDao ad;
    ArrayList<Acomodacao> acomodacaoS;
    GerenciaExame ge;
    Consulta consulta;
    ArrayList<model.Prontuario> prontuarios;
    dao.ProntuarioDao pd;
    dao.ExameDao ed;
    ArrayList<model.Exame> exames;

    public ExameConsultar() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        pd = new ProntuarioDao();
        prontuarios = pd.listarTodos();
        ad = new AcomodacaoDao();
        acomodacaoS = ad.listar("Sala de exame");
        ge = new GerenciaExame();
        this.consulta = consulta;
        tfTipo.setEditable(false);
        btnAnterior.setEnabled(false);
        btnAvancar.setEnabled(false);
        ftfValor.setEditable(false);
        cbxSala.setEnabled(false);
        jsHora.setEnabled(false);
        jsMinuto.setEnabled(false);
        taRelatorio.setEditable(false);
        jdcData.setEnabled(false);
        ed = new ExameDao();
        exames = ed.listar();

        for (int i = 0; i < acomodacaoS.size(); i++) {
            cbxSala.addItem(acomodacaoS.get(i).getTipo() + " - " + acomodacaoS.get(i).getNumero());
        }
        for (int i = 0; i < exames.size(); i++) {
            cbxExames.addItem("Exame - " + exames.get(i).getId() + "- " + exames.get(i).getData());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jdcData = new com.toedter.calendar.JDateChooser();
        jsMinuto = new javax.swing.JSpinner();
        jsHora = new javax.swing.JSpinner();
        tfTipo = new javax.swing.JTextField();
        ftfValor = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taRelatorio = new javax.swing.JTextArea();
        jpSalaCirurgia = new javax.swing.JPanel();
        cbxSala = new javax.swing.JComboBox<>();
        btnAnterior = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        cbxExames = new javax.swing.JComboBox<>();
        btnFechar = new javax.swing.JButton();

        jdcData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jsMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jsMinuto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minuto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jsHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jsHora.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora"));

        tfTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ftfValor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        taRelatorio.setColumns(20);
        taRelatorio.setRows(5);
        jScrollPane4.setViewportView(taRelatorio);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        cbxSala.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        cbxSala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSalaItemStateChanged(evt);
            }
        });

        btnAnterior.setText("<<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnAvancar.setText(">>");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSalaCirurgiaLayout = new javax.swing.GroupLayout(jpSalaCirurgia);
        jpSalaCirurgia.setLayout(jpSalaCirurgiaLayout);
        jpSalaCirurgiaLayout.setHorizontalGroup(
            jpSalaCirurgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSalaCirurgiaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(cbxSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpSalaCirurgiaLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jpSalaCirurgiaLayout.setVerticalGroup(
            jpSalaCirurgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSalaCirurgiaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSalaCirurgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnAvancar))
                .addGap(12, 12, 12))
        );

        cbxExames.setMaximumRowCount(5);
        cbxExames.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Exames", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        cbxExames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxExamesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpSalaCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxExames, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfTipo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(cbxExames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpSalaCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed

        if (cbxSala.getItemCount() != 0) {

            if (cbxSala.getSelectedIndex() + 1 >= cbxSala.getItemCount()) {
                cbxSala.setSelectedIndex(0);
            } else {

                cbxSala.setSelectedIndex(cbxSala.getSelectedIndex() + 1);
            }
        }
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (cbxSala.getItemCount() != 0) {

            if (cbxSala.getSelectedIndex() - 1 < 0) {
                cbxSala.setSelectedIndex(cbxSala.getItemCount() - 1);
            } else {

                cbxSala.setSelectedIndex(cbxSala.getSelectedIndex() - 1);
            }
    }//GEN-LAST:event_btnAnteriorActionPerformed
    }
    private void cbxSalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSalaItemStateChanged

    }//GEN-LAST:event_cbxSalaItemStateChanged

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        int i = 0;
        int e = JOptionPane.showConfirmDialog(this, "Deseja Fechar ?", "", JOptionPane.OK_CANCEL_OPTION);
        if (e == JOptionPane.OK_OPTION) {

            dispose();

        }

    }//GEN-LAST:event_btnFecharActionPerformed

    private void cbxExamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxExamesItemStateChanged
        if (exames != null) {

            if (cbxExames.getItemCount() > 0) {

                if (cbxSala.getItemCount() > 0) {
                    cbxSala.setSelectedIndex(exames.get(cbxExames.getSelectedIndex()).getSalaExame().getNumero());

                }

                ftfValor.setText(String.valueOf(exames.get(cbxExames.getSelectedIndex()).getValor()));
                jsHora.setValue(exames.get(cbxExames.getSelectedIndex()).getHora().getHour());
                jsMinuto.setValue(exames.get(cbxExames.getSelectedIndex()).getHora().getMinute());
                jdcData.setDate(Date.valueOf(exames.get(cbxExames.getSelectedIndex()).getData()));
                tfTipo.setText(exames.get(cbxExames.getSelectedIndex()).getTipo());
                taRelatorio.setText(exames.get(cbxExames.getSelectedIndex()).getRelatorio());
            }

    }//GEN-LAST:event_cbxExamesItemStateChanged

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> cbxExames;
    private javax.swing.JComboBox<String> cbxSala;
    private javax.swing.JFormattedTextField ftfValor;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JPanel jpSalaCirurgia;
    private javax.swing.JSpinner jsHora;
    private javax.swing.JSpinner jsMinuto;
    private javax.swing.JTextArea taRelatorio;
    private javax.swing.JTextField tfTipo;
    // End of variables declaration//GEN-END:variables
}
