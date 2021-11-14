/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Acomodacao;
import model.Medicamento;

/**
 *
 * @author Wanderson_M
 */
public class AcomodacaoDao {

    private Connection conn;

    public ArrayList<Acomodacao> listar(String tipo) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<model.Acomodacao> acomodacaoS = null;
        sql = ("SELECT numero, tipo, id\n"
                + "	FROM public.acomodacao where tipo = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, tipo);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    acomodacaoS = new ArrayList<>();
                    umaVez = false;
                }
                model.Acomodacao acomodacao = new model.Acomodacao(rs.getInt("numero"), rs.getString("tipo"));
                acomodacaoS.add(acomodacao);
            }

        } catch (Exception e) {

        }
        fecharConexao();
        return acomodacaoS;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
