/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciaCirurgia;
import dao.AcomodacaoDao;
import dao.ProntuarioDao;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.System.gc;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Acomodacao;

/**
 *
 * @author Wanderson_M
 */
public class CirurgiaAdd extends javax.swing.JInternalFrame {

    /**
     * Creates new form CirurgiaAdd
     */
    ArrayList<model.EquipeCirurgica> ecs;
    ArrayList<Acomodacao> acomodacaoS;
    ArrayList<model.Prontuario> prontuarios;
    dao.ProntuarioDao pd;
    dao.EquipeCirurgicaDao ecd;
    dao.AcomodacaoDao ad;
    GerenciaCirurgia gc;

    public CirurgiaAdd() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        ecd = new dao.EquipeCirurgicaDao();
        ad = new AcomodacaoDao();
        ecs = ecd.listarE();
        gc = new GerenciaCirurgia();
        pd = new ProntuarioDao();
        prontuarios = pd.listarTodos();
        acomodacaoS = ad.listar("Sala de cirurgia");
        initComponents();

        for (int i = 0; i < ecs.size(); i++) {
            cbxEquipeCirurgica.addItem("Equipe: " + ecs.get(i).getId());
        }
        for (int i = 0; i < prontuarios.size(); i++) {
            cbxConsulta.addItem("Consulta - " + prontuarios.get(i).getId() + "- " + prontuarios.get(i).getData());
        }
        for (int i = 0; i < acomodacaoS.size(); i++) {
            cbxSala.addItem(acomodacaoS.get(i).getTipo() + " - " + acomodacaoS.get(i).getNumero());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        cbxConsulta = new javax.swing.JComboBox<>();
        jpEscolhaEquipeCirurgica = new javax.swing.JPanel();
        cbxEquipeCirurgica = new javax.swing.JComboBox<>();
        btnAnterior = new javax.swing.JButton();
        btnAvancar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlCirculante = new javax.swing.JLabel();
        jlAnestesista = new javax.swing.JLabel();
        jlInstrumentador = new javax.swing.JLabel();
        ljCirurgiaoPrincipal = new javax.swing.JLabel();
        ljEnfermeiroChefe = new javax.swing.JLabel();
        jlCirurgiaoAssistente = new javax.swing.JLabel();
        tfCirculante = new javax.swing.JTextField();
        tfAnestesista = new javax.swing.JTextField();
        tfInstrumentador = new javax.swing.JTextField();
        tfEnfermeiroChefe = new javax.swing.JTextField();
        tfCirurgiaoPrincipal = new javax.swing.JTextField();
        tfCirurgiaoAssistente = new javax.swing.JTextField();
        cbxSala = new javax.swing.JComboBox<>();
        jdcData = new com.toedter.calendar.JDateChooser();
        jsHora = new javax.swing.JSpinner();
        ftfValor = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taRelatorio = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jsMinuto = new javax.swing.JSpinner();

        cbxConsulta.setMaximumRowCount(5);
        cbxConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        cbxConsulta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxConsultaItemStateChanged(evt);
            }
        });

        cbxEquipeCirurgica.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Equipe cirurgica", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        cbxEquipeCirurgica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEquipeCirurgicaItemStateChanged(evt);
            }
        });

        btnAnterior.setText("<<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnAvancar1.setText(">>");
        btnAvancar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpEscolhaEquipeCirurgicaLayout = new javax.swing.GroupLayout(jpEscolhaEquipeCirurgica);
        jpEscolhaEquipeCirurgica.setLayout(jpEscolhaEquipeCirurgicaLayout);
        jpEscolhaEquipeCirurgicaLayout.setHorizontalGroup(
            jpEscolhaEquipeCirurgicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEscolhaEquipeCirurgicaLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(cbxEquipeCirurgica, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnAvancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jpEscolhaEquipeCirurgicaLayout.setVerticalGroup(
            jpEscolhaEquipeCirurgicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscolhaEquipeCirurgicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEscolhaEquipeCirurgicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvancar1)
                    .addComponent(btnAnterior)
                    .addComponent(cbxEquipeCirurgica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlCirculante.setText("Circulante");

        jlAnestesista.setText("Anestesista");

        jlInstrumentador.setText("Instrumentador");

        ljCirurgiaoPrincipal.setText("Cirurgiao principal");

        ljEnfermeiroChefe.setText("Enfermeiro chefe");

        jlCirurgiaoAssistente.setText("Cirurgiao Assistente");

        tfCirculante.setEditable(false);

        tfAnestesista.setEditable(false);

        tfInstrumentador.setEditable(false);

        tfEnfermeiroChefe.setEditable(false);

        tfCirurgiaoPrincipal.setEditable(false);

        tfCirurgiaoAssistente.setEditable(false);
        tfCirurgiaoAssistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCirurgiaoAssistenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCirculante)
                    .addComponent(jlAnestesista)
                    .addComponent(jlInstrumentador)
                    .addComponent(ljEnfermeiroChefe)
                    .addComponent(ljCirurgiaoPrincipal)
                    .addComponent(jlCirurgiaoAssistente))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCirurgiaoAssistente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(tfCirurgiaoPrincipal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfEnfermeiroChefe, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfInstrumentador, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfAnestesista, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCirculante, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(33, 33, 33))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCirculante)
                    .addComponent(tfCirculante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnestesista)
                    .addComponent(tfAnestesista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlInstrumentador)
                    .addComponent(tfInstrumentador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ljEnfermeiroChefe)
                    .addComponent(tfEnfermeiroChefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ljCirurgiaoPrincipal)
                    .addComponent(tfCirurgiaoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCirurgiaoAssistente)
                    .addComponent(tfCirurgiaoAssistente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbxSala.setMaximumRowCount(5);
        cbxSala.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ftfValor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        taRelatorio.setColumns(20);
        taRelatorio.setRows(5);
        jScrollPane2.setViewportView(taRelatorio);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpEscolhaEquipeCirurgica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxSala, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpEscolhaEquipeCirurgica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbxSala, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ftfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(211, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCirurgiaoAssistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCirurgiaoAssistenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCirurgiaoAssistenteActionPerformed

    private void btnAvancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancar1ActionPerformed

        if (cbxEquipeCirurgica.getItemCount() != 0) {

            if (cbxEquipeCirurgica.getSelectedIndex() + 1 >= cbxEquipeCirurgica.getItemCount()) {
                cbxEquipeCirurgica.setSelectedIndex(0);
            } else {

                cbxEquipeCirurgica.setSelectedIndex(cbxEquipeCirurgica.getSelectedIndex() + 1);
            }
        }
    }//GEN-LAST:event_btnAvancar1ActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (cbxEquipeCirurgica.getItemCount() != 0) {

            if (cbxEquipeCirurgica.getSelectedIndex() - 1 < 0) {
                cbxEquipeCirurgica.setSelectedIndex(cbxEquipeCirurgica.getItemCount() - 1);
            } else {

                cbxEquipeCirurgica.setSelectedIndex(cbxEquipeCirurgica.getSelectedIndex() - 1);
            }
    }//GEN-LAST:event_btnAnteriorActionPerformed
    }
    private void cbxEquipeCirurgicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEquipeCirurgicaItemStateChanged

        campos();
    }//GEN-LAST:event_cbxEquipeCirurgicaItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        model.Cirurgia c = new model.Cirurgia();

        try {
            Acomodacao salaCirurgica = acomodacaoS.get(cbxSala.getSelectedIndex());
            c.setSalaCirurgia(salaCirurgica);
            c.setEquipeCirugica(ecs.get(cbxEquipeCirurgica.getSelectedIndex()));
            LocalTime hora = LocalTime.of((int) jsHora.getValue(), (int) jsMinuto.getValue());
            c.setData(jdcData.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            c.setHora(hora);
            c.setValor(Float.valueOf(ftfValor.getText()));
            c.setRelatorio(taRelatorio.getText());

            int re = gc.add(c, prontuarios.get(cbxConsulta.getSelectedIndex()).getId());
            if (re == 1) {
                JOptionPane.showMessageDialog(this, "Adicionado !");
                dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();

    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void cbxConsultaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxConsultaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxConsultaItemStateChanged

    public void campos() {

        model.EquipeCirurgica equipeCirurgica = ecs.get(cbxEquipeCirurgica.getSelectedIndex());
        tfAnestesista.setText(equipeCirurgica.getAnestesista().getNome() + " " + equipeCirurgica.getAnestesista().getSobrenome());

        tfCirculante.setText(equipeCirurgica.getCirculante().getNome() + " " + equipeCirurgica.getCirculante().getSobrenome());

        tfCirurgiaoAssistente.setText(equipeCirurgica.getCirurgiaoAssistente().getNome() + " " + equipeCirurgica.getCirurgiaoAssistente().getSobrenome());
        tfCirurgiaoPrincipal.setText(equipeCirurgica.getCirurgiaoPrincipal().getNome() + " " + equipeCirurgica.getCirurgiaoPrincipal().getSobrenome());

        tfEnfermeiroChefe.setText(equipeCirurgica.getEnfermeiroChefe().getNome() + " " + equipeCirurgica.getEnfermeiroChefe().getSobrenome());

        tfInstrumentador.setText(equipeCirurgica.getInstrumentador().getNome() + " " + equipeCirurgica.getInstrumentador().getSobrenome());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAvancar1;
    private javax.swing.JComboBox<String> cbxConsulta;
    private javax.swing.JComboBox<String> cbxEquipeCirurgica;
    private javax.swing.JComboBox<String> cbxSala;
    private javax.swing.JFormattedTextField ftfValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcData;
    private javax.swing.JLabel jlAnestesista;
    private javax.swing.JLabel jlCirculante;
    private javax.swing.JLabel jlCirurgiaoAssistente;
    private javax.swing.JLabel jlInstrumentador;
    private javax.swing.JPanel jpEscolhaEquipeCirurgica;
    private javax.swing.JSpinner jsHora;
    private javax.swing.JSpinner jsMinuto;
    private javax.swing.JLabel ljCirurgiaoPrincipal;
    private javax.swing.JLabel ljEnfermeiroChefe;
    private javax.swing.JTextArea taRelatorio;
    private javax.swing.JTextField tfAnestesista;
    private javax.swing.JTextField tfCirculante;
    private javax.swing.JTextField tfCirurgiaoAssistente;
    private javax.swing.JTextField tfCirurgiaoPrincipal;
    private javax.swing.JTextField tfEnfermeiroChefe;
    private javax.swing.JTextField tfInstrumentador;
    // End of variables declaration//GEN-END:variables
}
