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
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Juros;
import model.Pagamento;
import model.Parcela;
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class ParcelaDao {

    private Connection conn;

    private static ParcelaDao pagamentoDao;

    public static ParcelaDao getInstance() {
        if (pagamentoDao == null) {
            pagamentoDao = new ParcelaDao();
        }
        return pagamentoDao;

    }

    private ParcelaDao() {
    }

    public int pagar(Parcela p) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int r = 0;
        PreparedStatement pStatement = null;
        
        sql = "UPDATE public.parcela\n"
                + "	SET numero=?, valor=?,data_pagamento=?\n"
                + "	WHERE id = ?;";
        try {
            pStatement = conn.prepareStatement(sql);
            Date dataPagamento = Date.valueOf(p.getDataPagamento());
            pStatement.setInt(1, p.getNumero());
            pStatement.setFloat(2, p.getValor());
            pStatement.setDate(3, dataPagamento);
            pStatement.setInt(4, p.getId());
            pStatement.execute();
            pStatement.close();
            r = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        fecharConexao();
        return r;
    }

    
    public ArrayList<model.Parcela> listarNaoPagas(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Parcela> parcelas = null;
        sql = ("SELECT par.numero,  par.valor,  par.data_vencimento,  par.juros,  par.desconto,  par.data_pagamento,  par.id\n"
                + "                FROM public.parcela par\n"
                + "				join parcela_pagamento pp on pp.id_parcela = par.id\n"
                + "				where pp.id_pagamento = ?"
                + "and par.data_pagamento is null");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    parcelas = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate dataVencimento = rs.getDate("data_vencimento").toLocalDate();
                ParametrosDao jd = ParametrosDao.getInstance();

                Parcela p = new Parcela(rs.getInt("numero"), rs.getFloat("valor"), dataVencimento, rs.getFloat("juros"), rs.getFloat("desconto"), null, rs.getInt("id"));
                parcelas.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();

        return parcelas;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }
}
