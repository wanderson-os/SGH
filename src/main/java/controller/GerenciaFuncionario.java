/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import model.Crud;
import model.Funcionario;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaFuncionario implements Crud<Funcionario> {

    FuncionarioDao funcionarioDao;

    public GerenciaFuncionario() {
        funcionarioDao = new FuncionarioDao();
    }

    @Override
    public int cadastrar(Funcionario entidade) {
        int r = funcionarioDao.cadastrar(entidade);
        return r;
    }

    @Override
    public int listar() {
        int r = 0;
        return r;
    }

    @Override
    public int alterar(Funcionario entidade) {
        int r = funcionarioDao.alterar(entidade, entidade.getCpf());
        return r;
    }

    @Override
    public int excluir(Funcionario entidade) {
        int r = funcionarioDao.excluir(entidade);
        return r;
    }

}
