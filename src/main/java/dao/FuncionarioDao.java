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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import model.Endereco;
import model.Funcionario;
import model.Pessoa;

/**
 *
 * @author Wanderson_M
 */
public class FuncionarioDao {

    private Connection conn;
    ArrayList<Pessoa> pessoas = null;
    EnderecoDao enderecoDao;
    private static FuncionarioDao funcionarioDao;

    public static FuncionarioDao getInstance() {
        if (funcionarioDao == null) {
            funcionarioDao = new FuncionarioDao();
        }
        return funcionarioDao;

    }

    private FuncionarioDao() {
    }

    public int cadastrar(Funcionario funcionario) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        int r = 0;
        String sql;
        PreparedStatement pStatement = null;
        sql = "insert into pessoa(cpf, nome, sobrenome, telefone, data_nascimento, sexo, ctps, especialidade, data_inscricao, registro_profissional, funcao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Date dataNasc = Date.valueOf(funcionario.getDataNasc());
            Date dataInscricao = Date.valueOf(funcionario.getDataInscricao());
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, funcionario.getCpf());
            pStatement.setString(2, funcionario.getNome());
            pStatement.setString(3, funcionario.getSobrenome());
            pStatement.setString(4, funcionario.getTelefone());
            pStatement.setDate(5, dataNasc);
            pStatement.setString(6, String.valueOf(funcionario.getSexo()));
            pStatement.setString(7, funcionario.getCtps());
            pStatement.setString(8, funcionario.getEspecialidade());
            pStatement.setDate(9, dataInscricao);
            pStatement.setString(10, funcionario.getRegistroProfissional());
            pStatement.setString(11, funcionario.getFuncao());
            pStatement.execute();
            pStatement.close();
            r = 1;

        } catch (Exception e) {
        }

        fecharConexao();
        return r;
    }

    public int alterar(Funcionario funcionario, String cpf) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int r = 0;
        PreparedStatement pStatement = null;
        sql = "update pessoa SET cpf=?, nome=?, sobrenome=?, telefone=?, data_nascimento=?, "
                + "sexo=?, ctps=?, especialidade=?, data_inscricao=?, registro_profissional=?, funcao=? WHERE cpf = ? ";
        try {
            Date dataNasc = Date.valueOf(funcionario.getDataNasc());
            Date dataInscricao = Date.valueOf(funcionario.getDataInscricao());

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, funcionario.getCpf());
            pStatement.setString(2, funcionario.getNome());
            pStatement.setString(3, funcionario.getSobrenome());
            pStatement.setString(4, funcionario.getTelefone());
            pStatement.setDate(5, dataNasc);
            pStatement.setString(6, String.valueOf(funcionario.getSexo()));
            pStatement.setString(7, funcionario.getCtps());
            pStatement.setString(8, funcionario.getEspecialidade());
            pStatement.setDate(9, dataInscricao);
            pStatement.setString(10, funcionario.getRegistroProfissional());
            pStatement.setString(11, funcionario.getFuncao());
            pStatement.setString(12, cpf);
            pStatement.execute();
            pStatement.close();
            r = 1;

        } catch (Exception e) {
        }

        fecharConexao();
        return r;
    }

    public int excluir(Funcionario funcionario) {
        int r = 0;
        enderecoDao = EnderecoDao.getInstance();
        try {
            r = enderecoDao.excluir(funcionario.getEndereco());
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        sql = "delete from pessoa where cpf = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, funcionario.getCpf());
            pStatement.execute();
            pStatement.close();
            r = r + 1;

        } catch (Exception e) {
            enderecoDao.cadastrar(funcionario.getEndereco(), funcionario.getCpf());
        }

        fecharConexao();
        return r;

    }

    public ArrayList<Pessoa> listarFuncao(String funcao) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        sql = ("SELECT p.cpf, p.nome, p.sobrenome, p.telefone, p.data_nascimento, p.sexo, p.peso, p.ctps, p.especialidade, p.data_inscricao, p.registro_profissional,\n"
                + "                p.funcao, e.logradouro, e.numero, e.complemento, e.uf, e.bairro ,e.cep ,e.id ,e.cpf_pessoa FROM pessoa p join endereco e on p.cpf = e.cpf_pessoa\n"
                + "               where p.funcao = ?");

        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, funcao);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    pessoas = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate dataNasc = rs.getDate("data_nascimento").toLocalDate();
                LocalDate dataInscricao = rs.getDate("data_inscricao").toLocalDate();
                Endereco endereco = new Endereco(rs.getString("bairro"), rs.getInt("numero"),
                        rs.getString("logradouro"), rs.getString("uf"),
                        rs.getString("complemento"), rs.getString("cep"),
                        rs.getInt("id"), rs.getString("cpf_pessoa"));

                Funcionario funcionario = new Funcionario(rs.getString("ctps"), rs.getString("funcao"), rs.getString("especialidade"), rs.getString("registro_profissional"),
                        dataInscricao, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"), rs.getString("telefone"),
                        rs.getString("sexo").charAt(0), dataNasc, endereco);

                pessoas.add(funcionario);

            }

        } catch (Exception e) {

        }
        fecharConexao();
        return pessoas;

    }

    public ArrayList<Pessoa> listarTodosFuncionarios() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        sql = ("SELECT p.cpf, p.nome, p.sobrenome, p.telefone, p.data_nascimento, p.sexo, p.peso, p.ctps, p.especialidade, p.data_inscricao, p.registro_profissional,\n"
                + "                p.funcao, e.logradouro, e.numero, e.complemento, e.uf, e.bairro ,e.cep ,e.id ,e.cpf_pessoa FROM pessoa p join endereco e on p.cpf = e.cpf_pessoa\n"
                + "               where p.peso is null");

        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    pessoas = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate dataNasc = rs.getDate("data_nascimento").toLocalDate();
                LocalDate dataInscricao = rs.getDate("data_inscricao").toLocalDate();
                Endereco endereco = new Endereco(rs.getString("bairro"), rs.getInt("numero"),
                        rs.getString("logradouro"), rs.getString("uf"),
                        rs.getString("complemento"), rs.getString("cep"),
                        rs.getInt("id"), rs.getString("cpf_pessoa"));

                Funcionario funcionario = new Funcionario(rs.getString("ctps"), rs.getString("funcao"), rs.getString("especialidade"), rs.getString("registro_profissional"),
                        dataInscricao, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"), rs.getString("telefone"),
                        rs.getString("sexo").charAt(0), dataNasc, endereco);

                pessoas.add(funcionario);

            }

        } catch (Exception e) {

        }
        fecharConexao();
        return pessoas;

    }

    public ArrayList<Pessoa> listarFuncionarioNCF(String funcao) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        sql = ("SELECT cpf, nome, sobrenome, funcao "
                + "FROM pessoa  where peso is null and funcao = ?");

        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, funcao);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    pessoas = new ArrayList<>();
                    umaVez = false;
                }

                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));
                funcionario.setFuncao(rs.getString("funcao"));

                pessoas.add(funcionario);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause());
        }
        fecharConexao();
        return pessoas;

    }

    public ArrayList<Funcionario> listarFuncionarioNC() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = null;
        boolean umaVez = true;
        sql = ("SELECT cpf, nome, sobrenome, funcao "
                + "FROM pessoa  where peso is null");

        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    funcionarios = new ArrayList<>();
                    umaVez = false;
                }

                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));
                funcionario.setFuncao(rs.getString("funcao"));

                funcionarios.add(funcionario);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause());
        }
        fecharConexao();
        return funcionarios;

    }

    public ArrayList<Funcionario> listarMedicoNC() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        ArrayList<Funcionario> funcionarios = null;
        boolean umaVez = true;
        sql = ("SELECT cpf,nome, sobrenome FROM pessoa  where funcao = 'Medico'");

        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    funcionarios = new ArrayList<>();
                    umaVez = false;
                }

                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setSobrenome(rs.getString("sobrenome"));

                funcionarios.add(funcionario);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getCause());
        }
        fecharConexao();
        return funcionarios;

    }

    public Funcionario BuscarPorCpf(String cpf) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        Funcionario funcionario = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        sql = ("SELECT p.cpf, p.nome, p.sobrenome, p.telefone, p.data_nascimento, p.sexo, p.peso, p.ctps, p.especialidade, p.data_inscricao, p.registro_profissional,\n"
                + "                p.funcao, e.logradouro, e.numero, e.complemento, e.uf, e.bairro ,e.cep ,e.id ,e.cpf_pessoa FROM pessoa p join endereco e on p.cpf = e.cpf_pessoa\n"
                + "               where p.cpf = ?");

        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cpf);
            rs = pStatement.executeQuery();

            while (rs.next()) {

                LocalDate dataNasc = rs.getDate("data_nascimento").toLocalDate();
                LocalDate dataInscricao = rs.getDate("data_inscricao").toLocalDate();
                Endereco endereco = new Endereco(rs.getString("bairro"), rs.getInt("numero"),
                        rs.getString("logradouro"), rs.getString("uf"),
                        rs.getString("complemento"), rs.getString("cep"),
                        rs.getInt("id"), rs.getString("cpf_pessoa"));

                funcionario = new Funcionario(rs.getString("ctps"), rs.getString("funcao"), rs.getString("especialidade"), rs.getString("registro_profissional"),
                        dataInscricao, rs.getString("nome"), rs.getString("sobrenome"), rs.getString("cpf"), rs.getString("telefone"),
                        rs.getString("sexo").charAt(0), dataNasc, endereco);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return funcionario;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
