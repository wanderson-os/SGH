/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template pile, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import model.Paciente;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaPaciente {

    PacienteDao pacienteDao;

    public GerenciaPaciente() {
        pacienteDao = new PacienteDao();
    }

    public int cadastrar(Paciente p) {
        int r = pacienteDao.cadastrar(p);
        System.out.println("Cadastrar : " + r);
        return r;
    }

    public int excluir(Paciente p) {
        int r = pacienteDao.excluir(p);
        return r;
    }

    public int alterar(Paciente p) {
        int r = pacienteDao.alterar(p, p.getCpf());
        return r;
    }

    public void listar(Paciente p) {

    }
}
