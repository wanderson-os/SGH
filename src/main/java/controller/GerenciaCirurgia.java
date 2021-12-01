/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import dao.CirurgiaDao;
import dao.CirurgiaDao;
import java.util.ArrayList;
import model.Cirurgia;
import model.Crud;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaCirurgia implements Crud<Cirurgia> {

    ArrayList<Cirurgia> cirurgias;
    CirurgiaDao cd;

    private static GerenciaCirurgia gerenciaCirurgia;

    public static GerenciaCirurgia getInstance() {
        if (gerenciaCirurgia == null) {
            gerenciaCirurgia = new GerenciaCirurgia();
        }

        return gerenciaCirurgia;
    }

    private GerenciaCirurgia() {
        cd = CirurgiaDao.getInstance();
    }

    @Override
    public int cadastrar(Cirurgia entidade) {
        int r = cd.cadastrar(entidade);
        return r;
    }

    @Override
    public void listar() {
//        cd.listar();
    }

    public int listarPorProntuario(int id) {
//        cd.listarPorProntuario(id);
        return 0;
    }

    @Override
    public int alterar(Cirurgia entidade) {

        int r = cd.alterar(entidade);
        return r;

    }

    @Override
    public int excluir(Cirurgia entidade) {
        int r = cd.excluir(entidade);
        return r;

    }

    public int excluirNulos() {

        int r = cd.excluriNulos();
        return r;

    }

    public int add(Cirurgia cirurgia, int id) {

        int r = cd.cadastrar(cirurgia);
        if (r == 1) {
            cd.addCirurgiaP(id);
        }
        return r;

    }

}
