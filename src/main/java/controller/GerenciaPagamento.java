/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PagamentoDao;
import dao.ParcelaDao;
import model.Pagamento;
import model.Parcela;

/**
 *
 * @author Wanderson_M
 */
public class GerenciaPagamento {

    private static GerenciaPagamento gerenciaPagamento;

    public static GerenciaPagamento getInstance() {
        if (gerenciaPagamento == null) {
            gerenciaPagamento = new GerenciaPagamento();
        }

        return gerenciaPagamento;
    }
    ParcelaDao pd = ParcelaDao.getInstance();
    PagamentoDao pagamentoDao = PagamentoDao.getInstance();

    private GerenciaPagamento() {
    }

    public int pagar(Parcela p) {
        int r = pd.pagar(p);
        return r;
    }

    public int gerarPagamento(Pagamento p) {
        int r = pagamentoDao.gerar(p);
        return r;
    }

}
