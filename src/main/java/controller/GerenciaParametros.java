/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ParametrosDao;
import model.Parametro;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaParametros {

    private static GerenciaParametros gerenciaParametros;
    ParametrosDao p;

    private GerenciaParametros() {
        p = ParametrosDao.getInstance();
    }

    public static GerenciaParametros getInstance() {
        if (gerenciaParametros == null) {
            gerenciaParametros = new GerenciaParametros();
        }
        return gerenciaParametros;
    }

    public int alterar(Parametro parametro) {
        int r = p.alterar(parametro);
        return r;
    }

    public Parametro recuperar() {

        return p.recuperar();
    }

}
