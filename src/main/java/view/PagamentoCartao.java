/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GerenciaParametros;
import dao.ParametrosDao;
import dao.ProntuarioDao;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pagamento;
import model.Parametro;
import model.Parcela;

/**
 *
 * @author Wanderson_M
 */
public class PagamentoCartao extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pagamento
     */
    ArrayList<model.Prontuario> prontuarios;
    ArrayList<model.Prontuario> prontuariosNaoPagos;
    ArrayList<model.Paciente> pacientes;
    ProntuarioDao pd;
    private Parametro parametros;
    private GerenciaParametros gp;
    private float descontoMaximo;
    ArrayList<Float> somas = new ArrayList();
    float soma;
    float juros;
    float descontoAplicado = 0;
    DecimalFormat df;
    private boolean novoValor = false;
    private int indCBX = 0;

    public PagamentoCartao() {
        pd = ProntuarioDao.getInstance();
        prontuarios = pd.listarNaoPagos();
        pacientes = pd.listarPacientesNaoPagosSemRepetir();
        df = new DecimalFormat("#,###.00");
        initComponents();

        ftfDesconto.setText("0");
        rbJurosSimples.setSelected(true);
        if (pacientes == null) {
            JOptionPane.showMessageDialog(this, "Nenhuma consulta pendendte !");
            btnSalvar.setEnabled(false);
            dispose();
        } else {
            preencheCampos();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPacientes = new javax.swing.JTable();
        tfValorTotal = new javax.swing.JTextField();
        cbxParcelas = new javax.swing.JComboBox<>();
        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtProntuarios = new javax.swing.JTable();
        tfValorFinal = new javax.swing.JTextField();
        rbJurosSimples = new javax.swing.JRadioButton();
        rbJurosComposto = new javax.swing.JRadioButton();
        ftfDesconto = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        tfDescontoMaximo = new javax.swing.JTextField();
        tfParcelas = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Pagamento juros simples"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pacientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jtPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtPacientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tfValorTotal.setEditable(false);
        tfValorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor total", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        cbxParcelas.setMaximumRowCount(6);
        cbxParcelas.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade de parcelas"));
        cbxParcelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxParcelasItemStateChanged(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prontuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

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
        jScrollPane3.setViewportView(jtProntuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tfValorFinal.setEditable(false);
        tfValorFinal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor final", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buttonGroup1.add(rbJurosSimples);
        rbJurosSimples.setText("Juros simples");
        rbJurosSimples.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbJurosSimplesMouseClicked(evt);
            }
        });
        rbJurosSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJurosSimplesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbJurosComposto);
        rbJurosComposto.setText("Juros composto");
        rbJurosComposto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbJurosCompostoMouseClicked(evt);
            }
        });

        ftfDesconto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desconto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        ftfDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jButton1.setText("Aplicar desconto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfDescontoMaximo.setEditable(false);
        tfDescontoMaximo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Desconto máximo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tfParcelas.setEditable(false);
        tfParcelas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parcelas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jMenu1.setText("File");

        jMenuItem1.setText("Alterar juros padrão");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Alterar quantidade de parcelas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Alterar porcentagem do desconto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbJurosSimples, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbJurosComposto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfDescontoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ftfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfValorFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(16, 16, 16))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDescontoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbJurosSimples)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ftfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(rbJurosComposto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFechar))
                        .addContainerGap(62, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void aplicarDesconto() {

    }
    private void jtPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPacientesMouseClicked
        if (jtPacientes.getSelectedRow() != -1) {
            prontuariosNaoPagos = new ArrayList();

            for (int j = 0; j < prontuarios.size(); j++) {
                if (pacientes.get(jtPacientes.getSelectedRow()).getNome().equals(prontuarios.get(j).getPaciente().getNome())) {
                    prontuariosNaoPagos.add(prontuarios.get(j));
                }
            }
            System.out.println("Tamanho p: " + prontuariosNaoPagos.size());

            Object[][] valores = new Object[prontuariosNaoPagos.size()][3];
            for (int i = 0; i < prontuariosNaoPagos.size(); i++) {

                valores[i][0] = prontuariosNaoPagos.get(i).getData();
                valores[i][1] = prontuariosNaoPagos.get(i).getHora();
                valores[i][2] = prontuariosNaoPagos.get(i).getMedico().getNome() + " " + prontuariosNaoPagos.get(i).getMedico().getSobrenome();

            }
            DefaultTableModel model = new DefaultTableModel(valores, new String[]{"Data", "Hora", "Médico"});
            jtProntuarios.setModel(model);

        }     }//GEN-LAST:event_jtPacientesMouseClicked

    private void jtProntuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProntuariosMouseClicked

        campos();

    }//GEN-LAST:event_jtProntuariosMouseClicked

    public void campos() {

        somas.clear();
        gp = GerenciaParametros.getInstance();
        parametros = gp.recuperar();

        if (jtProntuarios.getSelectedRow() != -1) {
            soma = 0;
            cbxParcelas.removeAllItems();
            model.Prontuario p = prontuariosNaoPagos.get(jtProntuarios.getSelectedRow());
            if (p.getCirurgias() != null) {
                for (int i = 0; i < p.getCirurgias().size(); i++) {
                    soma += p.getCirurgias().get(i).getValor();

                }

            }
            if (p.getExames() != null) {
                for (int i = 0; i < p.getExames().size(); i++) {
                    soma += p.getExames().get(i).getValor();
                }

            }
            if (p.getMedicamentos() != null) {
                for (int i = 0; i < p.getMedicamentos().size(); i++) {
                    soma += p.getMedicamentos().get(i).getPreco();
                }

            }
            tfValorTotal.setText("" + soma);

            if (novoValor) {
                soma -= descontoAplicado;
            }
            if (rbJurosSimples.isSelected()) {
                for (int i = 0; i < parametros.getQuantidadeDeParcelas(); i++) {
                    somas.add(((soma * (1 + parametros.getJurosPorcentagem() / 100 * (i + 1)))));
                }
            } else {
                switch (parametros.getQuantidadeDeParcelas()) {
                    case 1:
                        somas.add((((soma * parametros.getJurosPorcentagem()) / 100) + soma));
                        break;
                    case 2:
                        somas.add((((soma * parametros.getJurosPorcentagem()) / 100) + soma) / 2);
                        break;

                    default:
                        for (int i = 0; i < parametros.getQuantidadeDeParcelas(); i++) {
                            if (i == 0) {
                                somas.add((((soma * parametros.getJurosPorcentagem()) / 100) + soma));
                            } else {
                                somas.add((((somas.get(i - 1) * parametros.getJurosPorcentagem()) / 100) + somas.get(i - 1)));
                            }
                        }
                        break;

                }
            }

            for (int i = 0; i < somas.size(); i++) {
                cbxParcelas.addItem(i + 1 + "x de R$ " + df.format(somas.get(i) / (i + 1)));
            }
            cbxParcelas.setSelectedIndex(indCBX);
        }

    }
    private void cbxParcelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxParcelasItemStateChanged

        if (cbxParcelas.getSelectedIndex() != -1) {
            descontoMaximo = somas.get(cbxParcelas.getSelectedIndex()) * (parametros.getDescontoPorcentagem() / 100);
            if (descontoAplicado <= descontoMaximo) {
                tfValorFinal.setText("R$ " + df.format(somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado));
                tfParcelas.setText(+cbxParcelas.getSelectedIndex() + 1 + "x de R$ " + df.format((somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado) / (cbxParcelas.getSelectedIndex() + 1)));
            } else {
                tfValorFinal.setText("R$ " + df.format(somas.get(cbxParcelas.getSelectedIndex())));
                tfParcelas.setText(+cbxParcelas.getSelectedIndex() + 1 + "x de R$ " + df.format(somas.get(cbxParcelas.getSelectedIndex()) / (cbxParcelas.getSelectedIndex() + 1)));

            }
            juros = ((somas.get(cbxParcelas.getSelectedIndex()) / (cbxParcelas.getSelectedIndex() + 1)) - (soma / (cbxParcelas.getSelectedIndex() + 1)));
            tfDescontoMaximo.setText("R$ " + df.format(descontoMaximo));
            descontoAplicado = 0;
        }


    }//GEN-LAST:event_cbxParcelasItemStateChanged

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        int e = JOptionPane.showConfirmDialog(this, "Deseja Fechar ?", "", JOptionPane.OK_CANCEL_OPTION);
        if (e == JOptionPane.OK_OPTION) {
            dispose();

        }     }//GEN-LAST:event_btnFecharActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JurosPadrao jp = new JurosPadrao(new JFrame(), true, this);
        jp.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AlterarQuantidadeParcelas alterarQuantidadeParcelas = new AlterarQuantidadeParcelas(new JFrame(), true, this);
        alterarQuantidadeParcelas.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void rbJurosSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJurosSimplesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbJurosSimplesActionPerformed

    private void rbJurosSimplesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbJurosSimplesMouseClicked
        indCBX = cbxParcelas.getSelectedIndex();
        jtProntuariosMouseClicked(evt);

    }//GEN-LAST:event_rbJurosSimplesMouseClicked

    private void rbJurosCompostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbJurosCompostoMouseClicked
        indCBX = cbxParcelas.getSelectedIndex();
        jtProntuariosMouseClicked(evt);
    }//GEN-LAST:event_rbJurosCompostoMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {

            Pagamento p = new Pagamento();
            p.setProntuario(prontuariosNaoPagos.get(jtProntuarios.getSelectedRow()));
            p.setTipo("Cartão de crédito");
            for (int i = 0; i <= cbxParcelas.getSelectedIndex(); i++) {
                Parcela parcela = new Parcela();
                parcela.setDataVencimento(LocalDate.now().plusMonths((i + 1)));
                System.out.println("Juros: " + juros);
                parcela.setJuros(juros);
                parcela.setNumero(i + 1);
                System.out.println("Parcela n: " + parcela.getNumero());
                if (novoValor) {
                    parcela.setValor(((somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado) / (cbxParcelas.getSelectedIndex() + 1)));
                } else {
                    parcela.setValor((somas.get(cbxParcelas.getSelectedIndex()) / (cbxParcelas.getSelectedIndex() + 1)));
                }
                System.out.println("Valor da parcela" + parcela.getValor());
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jtProntuarios.getSelectedRow() != -1) {

            try {
                float desconto = Float.valueOf(ftfDesconto.getText());
                if (desconto > descontoMaximo) {
                    JOptionPane.showMessageDialog(this, "Erro ! Valor maximo de desconto : R$ " + df.format(descontoMaximo));
                    tfValorFinal.setText("R$ " + df.format(somas.get(cbxParcelas.getSelectedIndex())));
                    tfParcelas.setText(+cbxParcelas.getSelectedIndex() + 1 + "x de R$ " + df.format((somas.get(cbxParcelas.getSelectedIndex())) / (cbxParcelas.getSelectedIndex() + 1)));
                    juros = (somas.get(cbxParcelas.getSelectedIndex()) / (cbxParcelas.getSelectedIndex() + 1) - (soma / (cbxParcelas.getSelectedIndex() + 1)));

                    descontoAplicado = 0;
                } else {
                    if (descontoAplicado > descontoMaximo) {
                        JOptionPane.showMessageDialog(this, "Valor maximo para desconto atingido !");
                        descontoAplicado = 0;
                        tfValorFinal.setText("R$ " + df.format(somas.get(cbxParcelas.getSelectedIndex())));
                        tfParcelas.setText(+cbxParcelas.getSelectedIndex() + 1 + "x de R$ " + df.format((somas.get(cbxParcelas.getSelectedIndex())) / (cbxParcelas.getSelectedIndex() + 1)));
                        juros = (somas.get(cbxParcelas.getSelectedIndex()) / (cbxParcelas.getSelectedIndex() + 1) - (soma / (cbxParcelas.getSelectedIndex() + 1)));

                    } else {
                        descontoAplicado = desconto;
//                if (desconto > somas.get(cbxParcelas.getSelectedIndex()) * 1.10) {
                        System.out.println("Valor to: " + somas.get(cbxParcelas.getSelectedIndex()) * (parametros.getDescontoPorcentagem() / 100));
                        System.out.println("Desconto aplicado: " + descontoAplicado);

//                }
                        novoValor = true;
                        juros = (somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado / (cbxParcelas.getSelectedIndex() + 1) - (soma / (cbxParcelas.getSelectedIndex() + 1)));
                        float jurosNovo = ((somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado) - soma) / (cbxParcelas.getSelectedIndex() + 1);
                        juros = jurosNovo;
                        tfValorFinal.setText("R$ " + df.format(somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado));
                        tfParcelas.setText(+cbxParcelas.getSelectedIndex() + 1 + "x de R$ " + df.format((somas.get(cbxParcelas.getSelectedIndex()) - descontoAplicado) / (cbxParcelas.getSelectedIndex() + 1)));

                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Informe o valor corretamente !");
                System.out.println("Desconto: " + ftfDesconto.getText());

            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum prontuario selecionado !");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        DescontoPorcentagem descontoPorcentagem = new DescontoPorcentagem(new JFrame(), true, this);
        descontoPorcentagem.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void recarrega(java.awt.event.MouseEvent evt) {

        jtProntuarios.getMouseListeners();
    }

    public MouseListener[] recuperaMouseL() {

        return jtProntuarios.getMouseListeners();
    }

    public void preencheCampos() {

        Object[][] valores = new Object[pacientes.size()][2];
        for (int i = 0; i < pacientes.size(); i++) {
            valores[i][0] = pacientes.get(i).getNome();
            valores[i][1] = pacientes.get(i).getSobrenome();

        }

        DefaultTableModel model = new DefaultTableModel(valores, new String[]{"Nome", "Sobrenome"});
        jtPacientes.setModel(model);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxParcelas;
    private javax.swing.JFormattedTextField ftfDesconto;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtPacientes;
    private javax.swing.JTable jtProntuarios;
    private javax.swing.JRadioButton rbJurosComposto;
    private javax.swing.JRadioButton rbJurosSimples;
    private javax.swing.JTextField tfDescontoMaximo;
    private javax.swing.JTextField tfParcelas;
    private javax.swing.JTextField tfValorFinal;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables
}