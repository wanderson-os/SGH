/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MedicamentoDao;
import model.Medicamento;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaMedicamento {

    MedicamentoDao md;

    public GerenciaMedicamento() {
        md = new MedicamentoDao();
    }

    public void cadastrar(Medicamento m) {
        md.cadastrar(m);
    }

    public void excluir(Medicamento m) {
        md.excluir(m);
    }

    public int alterar(Medicamento m, String nome) {
        String nomeVelho = nome;
        int r = md.alterar(m, nomeVelho);
        return r;
    }

    public void listar(Medicamento m) {

    }

}
