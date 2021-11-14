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
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class ProntuarioDao {

    private Connection conn;

    public void cadastrar(Prontuario prontuario) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.prontuario(\n"
                + "	cpf_medico, cpf_paciente, data, hora, diagnostico)\n"
                + "	VALUES (?, ?, ?, ?, ?)";
        try {
            Date data = Date.valueOf(prontuario.getData());

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, prontuario.getMedico().getCpf());
            pStatement.setString(2, prontuario.getPaciente().getCpf());
            pStatement.setDate(3, data);
            Time hora = Time.valueOf(prontuario.getHora());
            pStatement.setTime(4, hora);
            pStatement.setString(5, prontuario.getDiagnostico());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
    }

    public int alterar(Prontuario prontuario, String nome) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.prontuario\n"
                + "	SET cpf_medico=?, cpf_paciente=?, data=?, hora=?, diagnostico=?, id=?\n"
                + "	WHERE id = ?";
        try {
            Date data = Date.valueOf(prontuario.getData());

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, prontuario.getMedico().getCpf());
            pStatement.setString(2, prontuario.getPaciente().getCpf());
            pStatement.setDate(3, data);
            Time hora = Time.valueOf(prontuario.getHora());
            pStatement.setTime(4, hora);
            pStatement.setString(5, prontuario.getDiagnostico());
            pStatement.setInt(6, prontuario.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        return ret;
    }

    public int excluir(Prontuario prontuario) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from prontuario where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, prontuario.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<Prontuario> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Prontuario> prontuarios = null;
        sql = ("SELECT nome, preco, quantidade\n"
                + "	FROM prontuario");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }
                
                
                
                Prontuario m = new Prontuario(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("Quantidade"));
                prontuarios.add(m);
            }

        } catch (Exception e) {

        }
        fecharConexao();
        return prontuarios;

    }

    
    
    
    
    
    
        public ArrayList<Cirurgia> Cirurgias() {
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
                + "	FROM prontuario");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    cirurgias = new ArrayList<>();
                    umaVez = false;
                }
                
                
                
                Prontuario m = new Prontuario(rs.getString("nome"), rs.getFloat("preco"), rs.getInt("Quantidade"));
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
