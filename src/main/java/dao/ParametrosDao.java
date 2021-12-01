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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Juros;
import model.Juros;
import model.Paciente;
import model.Parametro;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class ParametrosDao {

    private Connection conn;
    private static ParametrosDao jurosDao;

    public static ParametrosDao getInstance() {
        if (jurosDao == null) {
            jurosDao = new ParametrosDao();
        }
        return jurosDao;

    }

    private ParametrosDao() {
    }

    public int alterar(Parametro parametro) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.parametros\n"
                + "	SET quantidade_de_parcelas=?, juros_porcentagem=?, desconto_porcentagem=?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, parametro.getQuantidadeDeParcelas());
            pStatement.setFloat(2, parametro.getJurosPorcentagem());
            pStatement.setFloat(3, parametro.getDescontoPorcentagem());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        fecharConexao();
        return ret;
    }

    public Parametro recuperar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        Parametro p = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        sql = ("SELECT quantidade_de_parcelas, juros_porcentagem, desconto_porcentagem\n"
                + "	FROM public.parametros;");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                p = new Parametro(rs.getInt("quantidade_de_parcelas"), rs.getFloat("juros_porcentagem"), rs.getFloat("desconto_porcentagem"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();

        return p;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
