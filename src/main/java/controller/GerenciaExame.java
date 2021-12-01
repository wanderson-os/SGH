/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ExameDao;
import model.Crud;
import model.Exame;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaExame implements Crud<Exame> {

    ExameDao ed;
    private static GerenciaExame gerenciaExame;

    public static GerenciaExame getInstance() {
        if (gerenciaExame == null) {
            gerenciaExame = new GerenciaExame();
        }

        return gerenciaExame;
    }

    private GerenciaExame() {
        ed = ExameDao.getInstance();
    }

    @Override
    public int cadastrar(Exame entidade) {
        int r = ed.cadastrar(entidade);
        return r;
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int alterar(Exame entidade) {
        int r = ed.alterar(entidade);
        return r;
    }

    @Override
    public int excluir(Exame entidade) {
        int r = ed.excluir(entidade);
        return r;
    }

    public void fechou() {

    }

    public int excluirNulos() {
        int r = ed.excluriNulos();
        return r;

    }

    public int add(Exame e, int id) {
        int r = ed.cadastrar(e);
        if (r == 1) {
            r = ed.add(id);
        }
        return r;

    }

}
