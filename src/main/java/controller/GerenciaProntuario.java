/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProntuarioDao;
import java.util.ArrayList;
import model.Crud;
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaProntuario implements Crud<Prontuario> {

    ProntuarioDao pd = new ProntuarioDao();
    ArrayList<Prontuario> prontuarios = new ArrayList();

    @Override
    public int cadastrar(Prontuario entidade) {

        int r = pd.cadastrar(entidade);
        return r;
    }

    @Override
    public void listar() {
        prontuarios = pd.listarTodos();

    }

    public void listarPorPaciente(String cpf) {
        prontuarios = pd.listarPorPaciente(cpf);

    }

    @Override
    public int alterar(Prontuario entidade) {
        int r = pd.alterar(entidade, entidade.getId());
        return r;
    }

    @Override
    public int excluir(Prontuario entidade) {
        int r = pd.excluir(entidade);
        return r;
    }

}
