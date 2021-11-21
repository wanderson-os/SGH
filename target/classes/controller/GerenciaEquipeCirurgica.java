/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EquipeCirurgicaDao;
import model.Crud;
import model.EquipeCirurgica;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaEquipeCirurgica implements Crud<EquipeCirurgica> {

    EquipeCirurgicaDao ecd;

    public GerenciaEquipeCirurgica() {
        ecd = new EquipeCirurgicaDao();
    }

    @Override
    public int cadastrar(EquipeCirurgica entidade) {
        int r = ecd.cadastrar(entidade);
       
        return r;
    }

    @Override
    public void listar() {

    }

    @Override
    public int alterar(EquipeCirurgica entidade) {
        int r = ecd.alterar(entidade);
       
        return r;
    }

    @Override
    public int excluir(EquipeCirurgica entidade) {
        int r = ecd.excluir(entidade);
      

        return r;
    }

   

    public EquipeCirurgicaDao getEcd() {
        return ecd;
    }

}
