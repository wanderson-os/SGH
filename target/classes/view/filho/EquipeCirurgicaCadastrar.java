/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filho;

import controller.GerenciaEquipeCirurgica;
import dao.FuncionarioDao;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Pessoa;
import view.mae.EquipeCirurgica;

/**
 *
 * @author Wanderson_M
 */
public class EquipeCirurgicaCadastrar extends EquipeCirurgica {

    GerenciaEquipeCirurgica gec;
    ArrayList<Pessoa> pessoas;
    FuncionarioDao fd;

    public EquipeCirurgicaCadastrar() {
        getBtnAcao().setText("Salvar");
        gec = new GerenciaEquipeCirurgica();
        fd = new FuncionarioDao();
        pessoas = fd.listarFuncionarioNC();
        preencheCampos();

        if (getCbxAnestesista().getItemCount() < 1
                || getCbxCirculante().getItemCount() < 1
                || getCbxEnfermeiroChefe().getItemCount() < 1
                || getCbxCirurgiaoAssistente().getItemCount() < 2
                || getCbxCirurgiaoPrincipal().getItemCount() < 2
                || getCbxInstrumentador().getItemCount() < 1) {
            getBtnAcao().setEnabled(false);

        }

    }

    public void preencheCampos() {
        if (pessoas == null || pessoas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum funcionario cadastrado!");
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
                JOptionPane.showMessageDialog(this, cirurgiaoPrincipal.getCpf() + " " + cirurgiaoPrincipal.getNome());

            } else if ((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome()).equals(CirurgiaoA)) {
                cirurgiaoAssistente = (Funcionario) pessoas.get(i);

            }
        }

        model.EquipeCirurgica ec = new model.EquipeCirurgica(cirurgiaoPrincipal, cirurgiaoAssistente, enfermeiroChefe, anestesista, instrumentador, circulante);

        int r = gec.cadastrar(ec);
        if (r == 1) {
            JOptionPane.showMessageDialog(this, "Dados Cadastrados com sucesso !");
            dispose();
        } else {
            if (r == 3) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar. Cirurgião principal e Cirurgião assistente não podem ser a mesma pessoa !");

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar. Equipe cirurgica existente !");
            }
        }
    }

}
