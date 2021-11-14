/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filho;

import controller.GerenciaEquipeCirurgica;
import dao.EquipeCirurgicaDao;
import dao.FuncionarioDao;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pessoa;
import view.mae.EquipeCirurgica;

/**
 *
 * @author Wanderson_M
 */
public class EquipeCirurgicaEditar extends EquipeCirurgica {

    EquipeCirurgicaDao ecd;
    ArrayList<model.EquipeCirurgica> ecs;
    GerenciaEquipeCirurgica gec;
    ArrayList<Pessoa> pessoas;
    FuncionarioDao fd;
    JComboBox cbxEquipeCirugica;
    JButton btnp, btna;

    public EquipeCirurgicaEditar() {
        ecd = new EquipeCirurgicaDao();
        getBtnAcao().setText("Alterar");
        gec = new GerenciaEquipeCirurgica();
        fd = new FuncionarioDao();
        cbxEquipeCirugica = new JComboBox();
        cbxEquipeCirugica.addItemListener(this::cbxEquipeCirurgicaItemStateChanged);
        btnp = new JButton();
        btna = new JButton();
        btna.addActionListener(this::btnAnteriorActionPerformed);
        btnp.addActionListener(this::btnProximoActionPerformed);
        pessoas = fd.listarTodosFuncionarios();
        preencheCampos();
        this.setSize(496, 360);
        this.setLayout(null);
        getBtnAcao().setBounds(30, 280, 80, 25);
        getJpCampos().setBounds(0, 70, 473, 211);
        cbxEquipeCirugica.setBounds(165, 10, 182, 25);
        btna.setText("<<");
        btna.setBounds(367, 10, 48, 25);
        btnp.setText(">>");
        btnp.setBounds(427, 10, 48, 25);
        this.add(btnp);
        this.add(btna);
        this.add(cbxEquipeCirugica);

    }

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {
        if (cbxEquipeCirugica.getItemCount() != 0) {

            if (cbxEquipeCirugica.getSelectedIndex() - 1 < 0) {
                cbxEquipeCirugica.setSelectedIndex(cbxEquipeCirugica.getItemCount() - 1);
            } else {

                cbxEquipeCirugica.setSelectedIndex(cbxEquipeCirugica.getSelectedIndex() - 1);
            }
        }
    }

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {

        if (cbxEquipeCirugica.getItemCount() != 0) {

            if (cbxEquipeCirugica.getSelectedIndex() + 1 >= cbxEquipeCirugica.getItemCount()) {
                cbxEquipeCirugica.setSelectedIndex(0);
            } else {

                cbxEquipeCirugica.setSelectedIndex(cbxEquipeCirugica.getSelectedIndex() + 1);
            }
        }
    }

    public void preencheCampos() {
        if (pessoas == null || pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionario cadastrado!");
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                Funcionario f = (Funcionario) pessoas.get(i);
                switch (f.getFuncao()) {
                    case "Anestesista":
                        getCbxAnestesista().addItem(f.getNome() + " " + f.getSobrenome());
                        break;
                    case "Circulante":
                        getCbxCirculante().addItem(f.getNome() + " " + f.getSobrenome());
                        break;
                    case "Cirurgiã(ão)":
                        getCbxCirurgiaoAssistente().addItem(f.getNome() + " " + f.getSobrenome());
                        getCbxCirurgiaoPrincipal().addItem(f.getNome() + " " + f.getSobrenome());
                        break;
                    case "Enfermeiro(a)":
                        getCbxEnfermeiroChefe().addItem(f.getNome() + " " + f.getSobrenome());

                        break;
                    case "Instrumentador(a)":
                        getCbxInstrumentador().addItem(f.getNome() + " " + f.getSobrenome());
                        break;
                }

            }
            CarregaComboBox();
        }

    }

    private void cbxEquipeCirurgicaItemStateChanged(java.awt.event.ItemEvent evt) {
        CarregaCampos(cbxEquipeCirugica.getSelectedIndex());
    }

    public void CarregaComboBox() {
        ecs = ecd.listarE();
        if (ecs == null || ecs.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionario cadastrado!");
            getBtnAcao().setEnabled(false);
        } else {
            for (int i = 0; i < ecs.size(); i++) {
                cbxEquipeCirugica.addItem("Equipe " + (i + 1));

            }

        }
    }

    public void CarregaCampos(int index) {
        for (int j = 0; j < getCbxAnestesista().getItemCount(); j++) {
            if ((ecs.get(index).getAnestesista().getNome() + " " + ecs.get(index).getAnestesista().getSobrenome()).equals(getCbxAnestesista().getItemAt(j))) {
                getCbxAnestesista().setSelectedIndex(j);
            }
        }
        for (int j = 0; j < getCbxCirculante().getItemCount(); j++) {
            if ((ecs.get(index).getCirculante().getNome() + " " + ecs.get(index).getCirculante().getSobrenome()).equals(getCbxCirculante().getItemAt(j))) {
                getCbxCirculante().setSelectedIndex(j);
            }

        }
        for (int j = 0; j < getCbxEnfermeiroChefe().getItemCount(); j++) {
            if ((ecs.get(index).getEnfermeiroChefe().getNome() + " " + ecs.get(index).getEnfermeiroChefe().getSobrenome()).equals(getCbxEnfermeiroChefe().getItemAt(j))) {
                getCbxEnfermeiroChefe().setSelectedIndex(j);
            }

        }
        for (int j = 0; j < getCbxCirurgiaoAssistente().getItemCount(); j++) {
            if ((ecs.get(index).getCirurgiaoAssistente().getNome() + " " + ecs.get(index).getCirurgiaoAssistente().getSobrenome()).equals(getCbxCirurgiaoAssistente().getItemAt(j))) {
                getCbxCirurgiaoAssistente().setSelectedIndex(j);
            }

        }
        for (int j = 0; j < getCbxCirurgiaoPrincipal().getItemCount(); j++) {
            if ((ecs.get(index).getCirurgiaoPrincipal().getNome() + " " + ecs.get(index).getCirurgiaoPrincipal().getSobrenome()).equals(getCbxCirurgiaoPrincipal().getItemAt(j))) {
                getCbxCirurgiaoPrincipal().setSelectedIndex(j);
            }

        }
        for (int j = 0; j < getCbxInstrumentador().getItemCount(); j++) {
            if ((ecs.get(index).getInstrumentador().getNome() + " " + ecs.get(index).getInstrumentador().getSobrenome()) == getCbxInstrumentador().getItemAt(j)) {
                getCbxInstrumentador().setSelectedIndex(j);
            }

        }

    }

    @Override
    public void btnAcaoActionPerformed(ActionEvent evt) {

        Funcionario cirurgiaoPrincipal = null,
                cirurgiaoAssistente = null,
                enfermeiroChefe = null,
                anestesista = null,
                instrumentador = null,
                circulante = null;

        String Circulante = getCbxCirculante().getSelectedItem().toString(),
                Instrumentador = getCbxInstrumentador().getSelectedItem().toString(),
                Anestesista = getCbxAnestesista().getSelectedItem().toString(),
                Enfermeiro = getCbxEnfermeiroChefe().getSelectedItem().toString(),
                CirurgiaoP = getCbxCirurgiaoPrincipal().getSelectedItem().toString(),
                CirurgiaoA = getCbxCirurgiaoAssistente().getSelectedItem().toString();

        for (int i = 0; i < pessoas.size(); i++) {

            if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(Circulante)) {
                circulante = (Funcionario) pessoas.get(i);
            } else if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(Instrumentador)) {
                instrumentador = (Funcionario) pessoas.get(i);

            } else if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(Anestesista)) {
                anestesista = (Funcionario) pessoas.get(i);

            } else if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(Enfermeiro)) {
                enfermeiroChefe = (Funcionario) pessoas.get(i);

            } else if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(CirurgiaoP)) {
                cirurgiaoPrincipal = (Funcionario) pessoas.get(i);
                JOptionPane.showMessageDialog(null, cirurgiaoPrincipal.getCpf() + " " + cirurgiaoPrincipal.getNome());

            } else if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(CirurgiaoA)) {
                cirurgiaoAssistente = (Funcionario) pessoas.get(i);

            }
        }

        model.EquipeCirurgica ec = new model.EquipeCirurgica(cirurgiaoPrincipal, cirurgiaoAssistente, enfermeiroChefe, anestesista, instrumentador, circulante);
        ec.setId(ecs.get(cbxEquipeCirugica.getSelectedIndex()).getId());
        int r = gec.alterar(ec);

        if (r == 1) {
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso !");
            dispose();
        } else if (r == 2) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar. Equipe cirurgica existente !");

        } else if (r == 3) {

            JOptionPane.showMessageDialog(null, "Erro ao alterar dados. Cirurgiao principal não pode ser o mesmo que o cirurgião assistente !");
        }

    }

}
