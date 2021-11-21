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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class EnderecoDao {

    private Connection conn;

    public int id() {
        try {
            conn = Conexao.getConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        int id = -1;
        sql = "select max (id) from endereco";

        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                id++;
            }
            pStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return id;
    }

    public int cadastrar(Endereco endereco, String cpf) {
        int r = 0;

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO endereco(numero,logradouro, complemento, uf, bairro, cep,id,cpf_pessoa)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, endereco.getNumero());
            pStatement.setString(2, endereco.getLogradouro());
            pStatement.setString(3, endereco.getComplemento());
            pStatement.setString(4, endereco.getUf());
            pStatement.setString(5, endereco.getBairro());
            pStatement.setString(6, endereco.getCep());
            pStatement.setInt(7, endereco.getId());
            pStatement.setString(8, endereco.getCpf_pessoa());

            pStatement.execute();
            pStatement.close();
            r = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            excluirPessoa(cpf);

            fecharConexao();

        }
        System.out.println("CadastrarDaoE : " + r);

        return r;
    }

    public int alterar(Endereco endereco) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.endereco\n"
                + "	SET complemento=?, numero=?, logradouro=?, uf=?, bairro=?, cep=?\n"
                + "	WHERE id = ?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, endereco.getComplemento());
            pStatement.setInt(2, endereco.getNumero());
            pStatement.setString(3, endereco.getLogradouro());
            pStatement.setString(4, endereco.getUf());
            pStatement.setString(5, endereco.getBairro());
            pStatement.setString(6, endereco.getCep());

            pStatement.setInt(7, endereco.getId());
            System.out.println("ID ENDERECO :" + endereco.getId());
            System.out.println("CPF ENDERECO :" + endereco.getCpf_pessoa());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        fecharConexao();
        return ret;
    }

    public int excluir(Endereco endereco) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int r = 0;
        PreparedStatement pStatement = null;
        sql = "delete from endereco where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, endereco.getId());
            pStatement.execute();
            pStatement.close();
            r = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir endereco: " + e.getMessage());

        }

        fecharConexao();
        return r;

    }

    public int excluirPessoa(String cpf) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from pessoa where cpf = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cpf);
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        return ret;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
