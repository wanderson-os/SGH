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
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cirurgia;

/**
 *
 * @author Wanderson_M
 */
public class CirurgiaDao {

    private Connection conn;

    public void cadastrar(Cirurgia cirurgia) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.cirurgia(\n"
                + "	id_equipe_cirurgica, data, hora, valor, relatorio, sala_cirurgica_id)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?);";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, cirurgia.getEquipeCirugica().getId());
            Date data = Date.valueOf(cirurgia.getData());
            pStatement.setDate(2, data);
            Time hora = Time.valueOf(cirurgia.getHora());
            pStatement.setTime(3, hora);
            pStatement.setDouble(4, cirurgia.getValor());
            pStatement.setString(5, cirurgia.getRelatorio());
            pStatement.setInt(6, cirurgia.getSalaCirurgia().getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
    }

    public int alterar(Cirurgia cirurgia, String nome) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE cirurgia\n"
                + "	SET nome=?, preco=?, quantidade=?\n"
                + "	WHERE nome = ?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cirurgia.getNome());
            pStatement.setFloat(2, cirurgia.getPreco());
            pStatement.setInt(3, cirurgia.getQuantidade());
            pStatement.setString(4, nome);
            pStatement.execute();
            pStatement.close();
            JOptionPane.showMessageDialog(null, nome);
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        return ret;
    }

    public int excluir(Cirurgia cirurgia) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from cirurgia where nome = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cirurgia.getNome());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir cirurgia: " + e.getMessage());

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<Cirurgia> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Cirurgia> cirurgias = null;
        sql = ("SELECT nome, preco, quantidade\n"
                + "	FROM cirurgia");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    cirurgias = new ArrayList<>();
                    umaVez = false;
                }
                Cirurgia m = new Cirurgia(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("Quantidade"));
                cirurgias.add(m);
            }

        } catch (Exception e) {

        }
        fecharConexao();
        return cirurgias;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
