/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import java.util.ArrayList;
import model.Crud;
import model.Funcionario;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaFuncionario implements Crud<Funcionario> {

    FuncionarioDao funcionarioDao;
    ArrayList<Pessoa> funcionarios;

    public GerenciaFuncionario() {
        funcionarioDao = new FuncionarioDao();
        funcionarios = funcionarioDao.listarTodosFuncionarios();
    }

    @Override
    public int cadastrar(Funcionario entidade) {
        int r = funcionarioDao.cadastrar(entidade);
     
        return r;
    }

    @Override
    public int alterar(Funcionario entidade) {
        int r = funcionarioDao.alterar(entidade, entidade.getCpf());
        if (r == 2) {
            funcionarios = funcionarioDao.listarTodosFuncionarios();
        }
        return r;
    }

    @Override
    public int excluir(Funcionario entidade) {
        int r = funcionarioDao.excluir(entidade);
        if (r == 2) {
            funcionarios = funcionarioDao.listarTodosFuncionarios();
        }
        return r;
    }

    @Override
    public void listar() {
    }

    public ArrayList<Pessoa> getFuncionarios() {
        return funcionarios;
    }
    
    

}
