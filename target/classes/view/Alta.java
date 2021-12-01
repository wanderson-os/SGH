/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciaAlta;
import dao.FuncionarioDao;
import dao.ProntuarioDao;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wanderson_M
 */
public class Alta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Alta
     */
    ArrayList<model.Prontuario> prontuarios;
    dao.ProntuarioDao pd;
    ArrayList<model.Funcionario> medicos;
    dao.FuncionarioDao fd;
    int liberarBotao = 0;
    controller.GerenciaAlta ga;

    public Alta() {
        initComponents();
        pd = ProntuarioDao.getInstance();
        fd = FuncionarioDao.getInstance();
        btnAlta.setEnabled(false);
        prontuarios = pd.listarParaAlta();
        medicos = fd.listarMedicoNC();
        ga = GerenciaAlta.getInstance();
        preencheCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlMedicos = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProntuarios = new javax.swing.JTable();
        jdcData = new com.toedter.calendar.JDateChooser();
        jsHora = new javax.swing.JSpinner();
        jsMinuto = new javax.swing.JSpinner();
        btnFechar = new javax.swing.JButton();

        setClosable(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        btnAlta.setText("Alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        jlMedicos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecione o medico para alta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jlMedicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMedicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jlMedicos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prontuarios disponíveis para alta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jtProntuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtProntuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProntuariosMouseClicked(evt);
            }
        });
        jtProntuarios.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jtProntuariosVetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(jtProntuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jsHora.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        jsHora.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jsMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jsMinuto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minuto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAlta))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnFechar)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlta)
                            .addComponent(btnFechar))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed

        try {
            model.Alta alta = new model.Alta();
            LocalTime hora = LocalTime.of((int) jsHora.getValue(), (int) jsMinuto.getValue());
            alta.setData(jdcData.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            alta.setHora(hora);
            alta.setPaciente(prontuarios.get(jtProntuarios.getSelectedRow()).getPaciente());
            alta.setMedico(medicos.get(jlMedicos.getSelectedIndex()));
            int r = ga.cadastrar(alta);
            if (r == 1) {
                JOptionPane.showMessageDialog(this, "Cadastrado com sucesso !");
                dispose();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar !");

        }


    }//GEN-LAST:event_btnAltaActionPerformed

    private void jtProntuariosVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jtProntuariosVetoableChange
    }//GEN-LAST:event_jtProntuariosVetoableChange

    private void jtProntuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProntuariosMouseClicked
        if (jtProntuarios.getSelectedRow() == -1) {
            liberarBotao = 0;

        } else {
            liberarBotao = 1;
        }


    }//GEN-LAST:event_jtProntuariosMouseClicked

    private void jlMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMedicosMouseClicked
        if (jlMedicos.getSelectedIndex() == -1) {
            liberarBotao = 0;

        } else {
            liberarBotao += 1;
        }

    }//GEN-LAST:event_jlMedicosMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (liberarBotao == 2) {
            btnAlta.setEnabled(true);

        }    }//GEN-LAST:event_formMouseMoved

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        int e = JOptionPane.showConfirmDialog(this, "Deseja Fechar ?", "", JOptionPane.OK_CANCEL_OPTION);
        if (e == JOptionPane.OK_OPTION) {
            dispose();

        }     }//GEN-LAST:event_btnFecharActionPerformed

    public void preencheCampos() {

        if (prontuarios != null) {

            Object[][] valores = new Object[prontuarios.size()][4];
            for (int i = 0; i < prontuarios.size(); i++) {
                valores[i][0] = prontuarios.get(i).getPaciente().getNome() + " " + prontuarios.get(i).getPaciente().getSobrenome();
                valores[i][1] = prontuarios.get(i).getMedico().getNome() + " " + prontuarios.get(i).getMedico().getSobrenome();
                valores[i][2] = prontuarios.get(i).getData();
                valores[i][3] = prontuarios.get(i).getHora();

            }
            DefaultTableModel model = new DefaultTableModel(valores, new String[]{"Paciente", "Médico", "Data", "Horário"});
            jtProntuarios.setModel(model);

            if (medicos != null) {
                DefaultListModel medx = new DefaultListModel();
                for (model.Funcionario f : medicos) {
                    medx.addElement(f.getNome() + " " + f.getSobrenome());
                }
                jlMedicos.setModel(medx);

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JList<String> jlMedicos;
    private javax.swing.JSpinner jsHora;
    private javax.swing.JSpinner jsMinuto;
    private javax.swing.JTable jtProntuarios;
    // End of variables declaration//GEN-END:variables
}
