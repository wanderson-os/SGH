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
import javax.swing.JOptionPane;
import model.Endereco;
import model.Paciente;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class PacienteDao {

    Connection conn = null;
    EnderecoDao enderecoDao;

    public PacienteDao() {
        enderecoDao = new EnderecoDao();
    }

    public int cadastrar(Paciente paciente) {
        int r = 0;
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        sql = "insert into pessoa(cpf, nome, sobrenome, telefone, data_nascimento, sexo, peso) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            String sexo = Character.toString(paciente.getSexo());
            Date dataNasc = Date.valueOf(paciente.getDataNasc());
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, paciente.getCpf());
            pStatement.setString(2, paciente.getNome());
            pStatement.setString(3, paciente.getSobrenome());
            pStatement.setString(4, paciente.getTelefone());
            pStatement.setDate(5, dataNasc);
            pStatement.setString(6, sexo);
            pStatement.setFloat(7, paciente.getPeso());
            pStatement.execute();
            pStatement.close();
            System.out.println("Peso i: " + paciente.getPeso());
            r = enderecoDao.cadastrar(paciente.getEndereco(), paciente.getCpf()) + 1;
            System.out.println("CadastrarDaoPE : " + r);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        System.out.println("CadastrarDao : " + r);

        return r;
    }

    public int alterar(Paciente paciente, String cpf) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int r = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.pessoa\n"
                + "	SET cpf=?, nome=?, sobrenome=?, telefone=?, data_nascimento=?, sexo=?, peso=?\n"
                + "	WHERE cpf = ?";
        try {
            Date dataNasc = Date.valueOf(paciente.getDataNasc());
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, paciente.getCpf());
            pStatement.setString(2, paciente.getNome());
            pStatement.setString(3, paciente.getSobrenome());
            pStatement.setString(4, paciente.getTelefone());
            pStatement.setDate(5, dataNasc);
            pStatement.setString(6, String.valueOf(paciente.getSexo()));
            pStatement.setFloat(7, paciente.getPeso());
            pStatement.setString(8, cpf);

            pStatement.execute();
            pStatement.close();
            enderecoDao.alterar(paciente.getEndereco());
            r = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        return r;
    }

    public int excluir(Paciente paciente) {
        int r = 0;
        try {
            r = enderecoDao.excluir(paciente.getEndereco());
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
            pStatement.setString(1, paciente.getCpf());
            pStatement.execute();
            pStatement.close();
            r += 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        return r;

    }

    public ArrayList<Pessoa> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Pessoa> pessoas = null;
        sql = ("SELECT p.cpf, p.nome, p.sobrenome, p.telefone, p.data_nascimento, p.sexo, p.peso, e.logradouro, e.numero, e.complemento, e.uf, e.bairro ,e.cep ,e.id ,e.cpf_pessoa FROM pessoa p join endereco e on p.cpf = e.cpf_pessoa where ctps is null");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    pessoas = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate dataNasc = rs.getDate("data_nascimento").toLocalDate();
                Endereco endereco = new Endereco(rs.getString("bairro"), rs.getInt("numero"),
                        rs.getString("logradouro"), rs.getString("uf"),
                        rs.getString("complemento"), rs.getString("cep"),
                        rs.getInt("id"), rs.getString("cpf_pessoa"));

                Paciente paciente = new Paciente(rs.getFloat("peso"), rs.getString("nome"),
                        rs.getString("sobrenome"), rs.getString("cpf"), rs.getString("telefone"),
                        rs.getString("sexo").charAt(0), dataNasc, endereco);
                pessoas.add(paciente);
            }

        } catch (Exception e) {

        }
        fecharConexao();
        return pessoas;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
