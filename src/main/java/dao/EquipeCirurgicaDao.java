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
import javax.swing.JOptionPane;
import model.CpfF;
import model.Endereco;
import model.EquipeCirurgica;
import model.Funcionario;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Wanderson_M
 */
public class EquipeCirurgicaDao {

    private Connection conn;

    public int cadastrar(EquipeCirurgica equipeCirurgica) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.equipe_cirurgica(\n"
                + "	cpf_cirurgiao_p, cpf_cirurgiao_a, cpf_anestesista, cpf_instrumentador, cpf_circulante, cpf_enfermeiro)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?);";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, equipeCirurgica.getCirurgiaoPrincipal().getCpf());
            pStatement.setString(2, equipeCirurgica.getCirurgiaoAssistente().getCpf());
            pStatement.setString(3, equipeCirurgica.getAnestesista().getCpf());
            pStatement.setString(4, equipeCirurgica.getInstrumentador().getCpf());
            pStatement.setString(5, equipeCirurgica.getCirculante().getCpf());
            pStatement.setString(6, equipeCirurgica.getEnfermeiroChefe().getCpf());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (SQLException sqle) {

        } catch (NullPointerException npe) {
            ret = 3;
        }
        fecharConexao();
        return ret;
    }

    public int alterar(EquipeCirurgica equipeCirurgica) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.equipe_cirurgica\n"
                + "	SET cpf_cirurgiao_p=?, cpf_cirurgiao_a=?, cpf_anestesista=?, cpf_instrumentador=?, cpf_circulante=?, cpf_enfermeiro=?\n"
                + "	WHERE id = ?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, equipeCirurgica.getCirurgiaoPrincipal().getCpf());
            pStatement.setString(2, equipeCirurgica.getCirurgiaoAssistente().getCpf());
            pStatement.setString(3, equipeCirurgica.getAnestesista().getCpf());
            pStatement.setString(4, equipeCirurgica.getInstrumentador().getCpf());
            pStatement.setString(5, equipeCirurgica.getCirculante().getCpf());
            pStatement.setString(6, equipeCirurgica.getEnfermeiroChefe().getCpf());
            pStatement.setInt(7, equipeCirurgica.getId());

            pStatement.execute();
            pStatement.close();
            ret = 1;
            JOptionPane.showMessageDialog(null, equipeCirurgica.getId());

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage());
            ret = 2;
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage() + " Null");
            ret = 3;
        }

        fecharConexao();
        return ret;
    }

    public int excluir(EquipeCirurgica equipeCirurgica) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "DELETE FROM public.equipe_cirurgica\n"
                + "	WHERE id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, equipeCirurgica.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir equipeCirurgica: " + e.getMessage());

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<EquipeCirurgica> listarE() {
        ArrayList<EquipeCirurgica> equipeCirurgicas = new ArrayList();
        EquipeCirurgica ec;
        ArrayList<CpfF> cpfs = listar();
        if (cpfs == null || cpfs.isEmpty()) {
        } else {
            for (int i = 0; i < cpfs.size(); i++) {
                ec = new EquipeCirurgica();
                ec.setAnestesista(funcionario(cpfs.get(i).getAnestesista()));
                ec.setCirculante(funcionario(cpfs.get(i).getCirculante()));
                ec.setCirurgiaoAssistente(funcionario(cpfs.get(i).getCirurgiaoAssistente()));
                ec.setCirurgiaoPrincipal(funcionario(cpfs.get(i).getCirurgiaoPrincipal()));
                ec.setEnfermeiroChefe(funcionario(cpfs.get(i).getEnfermeiroChefe()));
                ec.setInstrumentador(funcionario(cpfs.get(i).getInstrumentador()));
                ec.setId(cpfs.get(i).getId());
                equipeCirurgicas.add(ec);
            }
        }

        return equipeCirurgicas;
    }

    public ArrayList<CpfF> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<CpfF> cpfs = null;
        CpfF cpf = null;

        sql = ("SELECT cpf_cirurgiao_p, cpf_cirurgiao_a, cpf_anestesista, cpf_instrumentador, cpf_circulante, cpf_enfermeiro, id\n"
                + "	FROM public.equipe_cirurgica");
        try {

            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    cpfs = new ArrayList<>();
                    umaVez = false;
                }
                cpf = new CpfF(rs.getString("cpf_cirurgiao_p"),
                        rs.getString("cpf_cirurgiao_a"),
                        rs.getString("cpf_enfermeiro"),
                        rs.getString("cpf_anestesista"),
                        rs.getString("cpf_instrumentador"),
                        rs.getString("cpf_circulante"),
                        rs.getInt("id")
                );

                cpfs.add(cpf);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        fecharConexao();
        return cpfs;

    }

    public Funcionario funcionario(String Cpf) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        boolean umaVez = true;

        sql = ("SELECT p.cpf, p.nome, p.sobrenome, p.telefone, p.data_nascimento, p.sexo, p.ctps, p.especialidade, p.data_inscricao, p.registro_profissional,\n"
                + "                p.funcao, e.logradouro, e.numero, e.complemento, e.uf, e.bairro ,e.cep ,e.id ,e.cpf_pessoa FROM pessoa p join endereco e on p.cpf = e.cpf_pessoa\n"
                + "               where p.cpf = ?");

        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, Cpf);
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
