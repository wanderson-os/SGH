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

    public void cadastrar(Paciente p) {
        pacienteDao.cadastrar(p);

    }

    public void excluir(Paciente p) {
        pacienteDao.excluir(p);

    }

    public void alterar(Paciente p) {
        pacienteDao.alterar(p, p.getCpf());

    }

    public void listar(Paciente p) {

    }
}
