/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FuncionarioDao;
import model.Funcionario;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaFuncionario {

    FuncionarioDao funcionarioDao;

    public GerenciaFuncionario() {
        funcionarioDao = new FuncionarioDao();
    }

    public void cadastrar(Funcionario f) {
        
        
        
        funcionarioDao.cadastrar(f);

    }

    public void excluir(Funcionario f) {
        funcionarioDao.excluir(f);

    }

    public void alterar(Funcionario f) {
        funcionarioDao.alterar(f, f.getCpf());

    }

    public void listar(Funcionario f) {
        

    }

  
}
