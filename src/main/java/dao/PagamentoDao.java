/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pagamento;
import model.Parcela;
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class PagamentoDao {

    private Connection conn;

    private static PagamentoDao pagamentoDao;

    public static PagamentoDao getInstance() {
        if (pagamentoDao == null) {
            pagamentoDao = new PagamentoDao();
        }
        return pagamentoDao;

    }

    private PagamentoDao() {
    }

    public int gerar(Pagamento pagamento) {
        try {
            conn = Conexao.getConexao();
            conn.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.pagamento(\n"
                + "	tipo, id_prontuario)\n"
                + "	VALUES (?, ?);";
        try {

            pStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, pagamento.getTipo());
            pStatement.setFloat(2, pagamento.getProntuario().getId());
            pStatement.execute();
            ResultSet rs = pStatement.getGeneratedKeys();
            if (rs.next()) {
                System.out.println(rs.getInt("id"));
                pagamento.setId(rs.getInt("id"));
            }

        } catch (Exception ePag) {
            System.out.println("Pagamento: " + ePag.getMessage());
            ePag.printStackTrace();
           

        }

        sql = ("INSERT INTO public.parcela(\n"
                + "	numero, valor, data_vencimento, juros, desconto, data_pagamento)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?)");
        for (Parcela parcela : pagamento.getParcelas()) {
            try {
                pStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pStatement.setInt(1, parcela.getNumero());
                pStatement.setFloat(2, parcela.getValor());
                pStatement.setDate(3, Date.valueOf(parcela.getDataVencimento()));
                pStatement.setFloat(4, parcela.getJuros());
                pStatement.setFloat(5, parcela.getDesconto());
                if (parcela.getDataPagamento() == null) {
                    pStatement.setDate(6, null);
                } else {
                    pStatement.setDate(6, Date.valueOf(parcela.getDataPagamento()));
                }
                pStatement.execute();
                ResultSet rsParcela = pStatement.getGeneratedKeys();
                if (rsParcela.next()) {
                    parcela.setId(rsParcela.getInt("id"));
                }
            } catch (Exception ePar) {
                System.out.println("Parcela: " + ePar.getMessage());
                
            }

        }

        sql = ("INSERT INTO public.parcela_pagamento(\n"
                + "	id_parcela, id_pagamento)\n"
                + "	VALUES (?, ?);");

        for (Parcela parcela : pagamento.getParcelas()) {

            try {
                pStatement = conn.prepareStatement(sql);
                pStatement.setInt(1, parcela.getId());
                pStatement.setInt(2, pagamento.getId());
                pStatement.execute();

            } catch (Exception e) {
            
                System.out.println("Pagamento_parcela: " + e.getMessage());
                e.printStackTrace();
            }
        }

        sql = "UPDATE public.prontuario\n"
                + "	SET gerou_pagamento= true\n"
                + "	WHERE id = ?;";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, pagamento.getProntuario().getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception ePro) {
            System.out.println("Prontuario: " + ePro.getMessage());
            ePro.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception ex) {
            }

        }

        fecharConexao();
        return ret;
    }

    public ArrayList<model.Pagamento> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Pagamento> pagamentos = null;
        sql = ("SELECT pg.tipo, pg.id_prontuario, pg.id\n"
                + "FROM public.pagamento pg\n"
                + "join prontuario p on p.id = pg.id_prontuario\n"
                + "join parcela_pagamento parpa on parpa.id_pagamento = pg.id\n"
                + "join parcela par on parpa.id_parcela = par.id\n"
                + "where p.gerou_pagamento = true\n"
                + "and par.data_pagamento is null ");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    pagamentos = new ArrayList<>();
                    umaVez = false;
                }
                ProntuarioDao prd = ProntuarioDao.getInstance();

                Prontuario prontuario = prd.buscarPorId((rs.getInt("id_prontuario")));
                Pagamento p = new model.Pagamento();
                p.setId(rs.getInt("id"));
                p.setProntuario(prontuario);
                ParcelaDao pd = ParcelaDao.getInstance();
                p.setParcelas(pd.listarNaoPagas(p.getId()));
                pagamentos.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();

        return pagamentos;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }
}
