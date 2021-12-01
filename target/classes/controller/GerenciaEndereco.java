/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnderecoDao;
import model.Crud;
import model.Endereco;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaEndereco implements Crud<Endereco> {

    EnderecoDao ed;

    private static GerenciaEndereco gerenciaEndereco;

    public static GerenciaEndereco getInstance() {
        if (gerenciaEndereco == null) {
            gerenciaEndereco = new GerenciaEndereco();
        }

        return gerenciaEndereco;
    }

    private GerenciaEndereco() {
        ed = EnderecoDao.getInstance();
    }

    @Override
    public int cadastrar(Endereco entidade) {
        int r = ed.cadastrar(entidade, entidade.getCpf_pessoa());
        return r;
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int alterar(Endereco entidade) {
        int r = ed.alterar(entidade);
        return r;
    }

    @Override
    public int excluir(Endereco entidade) {

        int r = ed.excluir(entidade);
        return r;

    }

}
