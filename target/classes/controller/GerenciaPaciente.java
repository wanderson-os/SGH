/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template pile, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import java.util.ArrayList;
import model.Paciente;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaPaciente {

    PacienteDao pacienteDao;
    ArrayList<Pessoa> pacientes;

    public GerenciaPaciente() {
        pacienteDao = new PacienteDao();
        pacientes = pacienteDao.listar();
    }

    public int cadastrar(Paciente p) {
        int r = pacienteDao.cadastrar(p);

        return r;
    }

    public int excluir(Paciente p) {
        int r = pacienteDao.excluir(p);
        if (r == 1) {
            pacientes = pacienteDao.listar();
        }

        return r;
    }

    public int alterar(Paciente p, String cpf) {
        int r = pacienteDao.alterar(p, cpf);

        return r;
    }

    public void listar(Paciente p) {

    }

    public ArrayList<Pessoa> getPacientes() {
        return pacientes;
    }

}
