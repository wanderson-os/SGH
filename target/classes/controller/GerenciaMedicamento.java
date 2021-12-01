/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MedicamentoDao;
import java.util.ArrayList;
import model.Crud;
import model.Medicamento;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaMedicamento implements Crud<Medicamento> {

    MedicamentoDao md;

    private static GerenciaMedicamento gerenciaMedicamento;

    public static GerenciaMedicamento getInstance() {
        if (gerenciaMedicamento == null) {
            gerenciaMedicamento = new GerenciaMedicamento();
        }

        return gerenciaMedicamento;
    }

    private GerenciaMedicamento() {
        md = MedicamentoDao.getInstance();
    }

    @Override
    public int cadastrar(Medicamento entidade) {

        int r = md.cadastrar(entidade);

        return r;
    }

    public int cadastrar(ArrayList<Medicamento> medicamentos) {
        int r = 0;
        for (int i = 0; i < medicamentos.size(); i++) {
            r = md.cadastrarMeCon(medicamentos.get(i));
        }
        return r;
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int alterar(ArrayList<Medicamento> medicamentos, int id) {

        int r = md.excluirMP(id);
        if (r == 1) {
            System.out.println("ID::: " + id);
            System.out.println("Tamanho " + medicamentos.size());
            for (int i = 0; i < medicamentos.size(); i++) {
                md.cadastrarAlterados(medicamentos.get(i), id);
            }
        }

        return r;
    }

    @Override
    public int excluir(Medicamento entidade) {
        int r = md.excluir(entidade);
        return r;
    }

    public int excluirMP(Medicamento entidade) {
        int r = md.excluir(entidade);
        return r;
    }

    public int excluirMPNulo() {
        int r = md.excluirMPNulo();
        return r;
    }

    @Override
    public int alterar(Medicamento entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
