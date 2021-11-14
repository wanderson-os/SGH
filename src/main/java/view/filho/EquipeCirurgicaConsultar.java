/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filho;

import java.awt.event.ActionEvent;
import view.mae.EquipeCirurgicaCE;

/**
 *
 * @author Wanderson_M
 */
public class EquipeCirurgicaConsultar extends EquipeCirurgicaCE {
    
    public EquipeCirurgicaConsultar() {
        getBtnAcao().setText("Fechar");
        getBtnAcao().setEnabled(true);
    }
    
    @Override
    public void btnAcaoActionPerformed(ActionEvent evt) {
        dispose();
    }
    
}
