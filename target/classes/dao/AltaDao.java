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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Alta;
import model.Alta;
import model.Funcionario;
import model.Paciente;

/**
 *
 * @author Wanderson_M
 */
public class AltaDao {

    private Connection conn;

    public int cadastrar(Alta alta) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.alta(\n"
                + "	data, hora, cpf_paciente, cpf_medico)\n"
                + "	VALUES (?, ?, ?, ?);";
        try {

            pStatement = conn.prepareStatement(sql);
            Date data = Date.valueOf(alta.getData());
            pStatement.setDate(1, data);
            Time hora = Time.valueOf(alta.getHora());
            pStatement.setTime(2, hora);
            pStatement.setString(3, alta.getPaciente().getCpf());
            pStatement.setString(4, alta.getMedico().getCpf());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return ret;
    }

    public int alterar(Alta alta) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.alta\n"
                + "	SET data=?, hora=?, cpf_paciente=?, cpf_medico=?\n"
                + "	WHERE id = ?;";
        try {
            pStatement = conn.prepareStatement(sql);
            Date data = Date.valueOf(alta.getData());
            pStatement.setDate(1, data);
            Time hora = Time.valueOf(alta.getHora());
            pStatement.setTime(2, hora);
            pStatement.setString(3, alta.getPaciente().getCpf());
            pStatement.setString(4, alta.getMedico().getCpf());
            pStatement.setInt(5, alta.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
        }

        fecharConexao();
        return ret;
    }

    public int excluir(Alta alta) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from alta where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, alta.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<Alta> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Alta> altas = null;
        sql = ("select pa.nome as paciente , pa.sobrenome as sobrenome_p \n"
                + ",m.nome as medico , m.sobrenome as sobrenome_M,\n"
                + "a.data, a.hora, a.id\n"
                + "from alta a \n"
                + "join prontuario p on p.cpf_paciente = a.cpf_paciente\n"
                + "and p.alta_id = a.id\n"
                + "join pessoa pa on pa.cpf = a.cpf_paciente\n"
                + "join pessoa m on m.cpf = a.cpf_medico");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    altas = new ArrayList<>();
                    umaVez = false;
                }
                Alta a = new Alta();
                Paciente p = new Paciente();
                Funcionario m = new Funcionario();
                p.setNome(rs.getString("paciente"));
                p.setSobrenome(rs.getString("sobrenome_p"));
                m.setNome(rs.getString("medico"));
                m.setSobrenome(rs.getString("sobrenome_m"));
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                a.setData(data);
                a.setHora(hora);
                a.setId(rs.getInt("id"));
                a.setMedico(m);
                a.setPaciente(p);
                altas.add(a);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();

        return altas;

    }

    public Alta buscarPor_id(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        Alta a = null;
        ArrayList<Alta> altas = null;
        sql = ("select m.nome as medico , m.sobrenome as sobrenome_M,\n"
                + "                a.data, a.hora, a.id\n"
                + "                from alta a \n"
                + "                join prontuario p on p.cpf_paciente = a.cpf_paciente\n"
                + "                and p.alta_id = a.id\n"
                + "                join pessoa pa on pa.cpf = a.cpf_paciente\n"
                + "                join pessoa m on m.cpf = a.cpf_medico\n"
                + "               where a.id = p.alta_id\n"
                + "			   and a.id = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    altas = new ArrayList<>();
                    umaVez = false;
                }
                a = new Alta();
                Funcionario m = new Funcionario();
                m.setNome(rs.getString("medico"));
                m.setSobrenome(rs.getString("sobrenome_m"));
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                a.setData(data);
                a.setHora(hora);
                a.setId(rs.getInt("id"));
                a.setMedico(m);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        fecharConexao();

        return a;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
