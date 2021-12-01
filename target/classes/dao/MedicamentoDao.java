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

    private static MedicamentoDao medicamentoDao;

    public static MedicamentoDao getInstance() {
        if (medicamentoDao == null) {
            medicamentoDao = new MedicamentoDao();
        }
        return medicamentoDao;

    }

    private MedicamentoDao() {
    }

    public int cadastrar(Medicamento medicamento) {
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
            e.printStackTrace();
        }
        fecharConexao();
        return ret;
    }

    public int cadastrarMeCon(Medicamento medicamento) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.medicamento_prontuario(\n"
                + "	nome, quantidade_medicamento, preco, medicamento_id)\n"
                + "	VALUES (?, ?, ?, ?);";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, medicamento.getNome());
            pStatement.setInt(2, medicamento.getQuantidade());
            pStatement.setFloat(3, medicamento.getPreco());
            pStatement.setInt(4, medicamento.getId());

            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return ret;
    }

    public int cadastrarAlterados(Medicamento medicamento, int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.medicamento_prontuario(\n"
                + "	nome, quantidade_medicamento, preco, medicamento_id, prontuario_id)\n"
                + "	VALUES (?, ?, ?, ?, ?);";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, medicamento.getNome());
            pStatement.setInt(2, medicamento.getQuantidade());
            pStatement.setFloat(3, medicamento.getPreco());
            pStatement.setInt(4, medicamento.getId());
            pStatement.setInt(5, id);

            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return ret;
    }

    public int alterar(Medicamento medicamento) {
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
                + "	WHERE id = ?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, medicamento.getNome());
            pStatement.setFloat(2, medicamento.getPreco());
            pStatement.setInt(3, medicamento.getQuantidade());
            pStatement.setInt(4, medicamento.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
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
        sql = "delete from medicamento where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, medicamento.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {

        }

        fecharConexao();
        return ret;

    }

    public int excluirMP(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from medicamento_prontuario where prontuario_id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        fecharConexao();
        return ret;

    }

    public int excluirMPNulo() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from medicamento_prontuario where prontuario_id is null";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.execute();
            pStatement.close();

        } catch (Exception e) {
            ret = 1;
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
        sql = ("SELECT nome, preco, quantidade, id\n"
                + "	FROM medicamento");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    medicamentos = new ArrayList<>();
                    umaVez = false;
                }
                Medicamento m = new Medicamento(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("Quantidade"), rs.getInt("id"));

                medicamentos.add(m);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();

        return medicamentos;

    }

    public ArrayList<Medicamento> listarPorProntuario(int id) {
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
        sql = ("SELECT medicamento_id, prontuario_id, id, nome, quantidade_medicamento, preco\n"
                + "	FROM public.medicamento_prontuario where prontuario_id = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    medicamentos = new ArrayList<>();
                    umaVez = false;
                }
                Medicamento m = new Medicamento(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("quantidade_medicamento"), rs.getInt("medicamento_id"));

                medicamentos.add(m);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
