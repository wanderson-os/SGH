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
import model.Medicamento;
import model.Paciente;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class MedicamentoDao {

    private Connection conn;

    public void cadastrar(Medicamento medicamento) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO medicamento(\n"
                + "	nome, preco, quantidade)\n"
                + "	VALUES (?, ?, ?)";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, medicamento.getNome());
            pStatement.setFloat(2, medicamento.getPreco());
            pStatement.setInt(3, medicamento.getQuantidade());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
    }

    public int alterar(Medicamento medicamento, String nome) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE medicamento\n"
                + "	SET nome=?, preco=?, quantidade=?\n"
                + "	WHERE nome = ?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, medicamento.getNome());
            pStatement.setFloat(2, medicamento.getPreco());
            pStatement.setInt(3, medicamento.getQuantidade());
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

    public int excluir(Medicamento medicamento) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from medicamento where nome = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, medicamento.getNome());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir medicamento: " + e.getMessage());

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<Medicamento> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Medicamento> medicamentos = null;
        sql = ("SELECT nome, preco, quantidade\n"
                + "	FROM medicamento");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    medicamentos = new ArrayList<>();
                    umaVez = false;
                }
                Medicamento m = new Medicamento(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("Quantidade"));
                medicamentos.add(m);
            }

        } catch (Exception e) {

        }
        fecharConexao();
        return medicamentos;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
