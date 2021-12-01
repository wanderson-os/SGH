/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AltaDao;
import model.Alta;
import model.Crud;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaAlta implements Crud<Alta> {

    AltaDao ad = AltaDao.getInstance();
    private static GerenciaAlta gerenciaAlta;

    public static GerenciaAlta getInstance() {
        if (gerenciaAlta == null) {
            gerenciaAlta = new GerenciaAlta();
        }

        return gerenciaAlta;
    }

    private GerenciaAlta() {
    }

    @Override
    public int cadastrar(Alta entidade) {
        int r = ad.cadastrar(entidade);

        return r;
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int alterar(Alta entidade) {
        int r = ad.alterar(entidade);
        return r;
    }

    @Override
    public int excluir(Alta entidade) {
        int r = ad.excluir(entidade);
        return r;
    }

}
