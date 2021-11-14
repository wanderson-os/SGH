/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filho;

import controller.GerenciaEquipeCirurgica;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.Paciente;
import view.mae.EquipeCirurgicaCE;

/**
 *
 * @author Wanderson_M
 */
public class EquipeCirurgicaExcluir extends EquipeCirurgicaCE {


    public EquipeCirurgicaExcluir() {
        getBtnAcao().setText("Excluir");

    }

    @Override
    public void btnAcaoActionPerformed(ActionEvent evt) {

        int e = JOptionPane.showConfirmDialog(null, "Deseja excluir ?", "", JOptionPane.OK_CANCEL_OPTION);
        if (e == JOptionPane.OK_OPTION) {
            getGec().excluir(getEcs().get(getCbxFuncionarios().getSelectedIndex()));
            JOptionPane.showMessageDialog(null, "Excluido com sucesso !");
            dispose();

        }

    }

}
