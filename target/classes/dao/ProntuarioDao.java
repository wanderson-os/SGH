/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import controller.GerenciaFuncionario;
import controller.GerenciaPaciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cirurgia;
import model.Paciente;
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class ProntuarioDao {

    private Connection conn;
    private CirurgiaDao cd;
    private PacienteDao pd;
    private FuncionarioDao fd = new FuncionarioDao();
    private ExameDao ed;
    private MedicamentoDao md;

    public int cadastrar(Prontuario prontuario) {
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
            System.out.println("Nome: " + prontuario.getDiagnostico());
        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return ret;
    }

    public int alterar(Prontuario prontuario, int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.prontuario\n"
                + "	SET cpf_medico=?, cpf_paciente=?, data=?, hora=?, diagnostico=? \n"
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
            System.out.println("IDP: " + prontuario.getId());
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

    public ArrayList<Prontuario> listarPorPaciente(String cpf) {

        try {
            conn = Conexao.getConexao();
            pd = new PacienteDao();
            ed = new ExameDao();
            md = new MedicamentoDao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Prontuario> prontuarios = null;
        sql = ("SELECT \n"
                + "p. cpf as \"CPF Paciente\",\n"
                + "pm. cpf as \"CPF Medico\",\n"
                + "pm.ctps, pm.especialidade, pm.data_inscricao, pm.registro_profissional, pm.funcao,\n"
                + "pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\"\n"
                + "FROM prontuario pr \n"
                + "join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "join pessoa pm on pm.cpf = pr.cpf_medico \n"
                + "where pr.cpf_paciente = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cpf);
            rs = pStatement.executeQuery();
            cd = new CirurgiaDao();
            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }

                Prontuario p = new Prontuario();
                p.setId(rs.getInt("ID prontuario"));
                p.setData(rs.getDate("Data prontuario").toLocalDate());
                p.setHora(rs.getTime("Hora prontuario").toLocalTime());
                p.setMedico(fd.BuscarPorCpf(rs.getString("CPF Medico")));
                p.setPaciente(pd.BuscarPorCpf(rs.getString("CPF Paciente")));
                p.setDiagnostico(rs.getString("Diagnostico prontuario"));
                p.setExames(ed.listarPorProntuario(p.getId()));
                p.setMedicamentos(md.listarPorProntuario(p.getId()));
                p.setCirurgias(cd.listarPorProntuario(p.getId()));

                prontuarios.add(p);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return prontuarios;

    }

    public Prontuario buscarPorCirurgia(int id) {

        Prontuario p = null;
        try {
            conn = Conexao.getConexao();
            pd = new PacienteDao();
            ed = new ExameDao();
            md = new MedicamentoDao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Prontuario> prontuarios = null;
        sql = (" SELECT \n"
                + " p. cpf as \"CPF Paciente\",\n"
                + " pm. cpf as \"CPF Medico\",\n"
                + " pm.ctps, pm.especialidade, pm.data_inscricao, pm.registro_profissional, pm.funcao,\n"
                + " pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\"\n"
                + " FROM prontuario pr \n"
                + " join pessoa p on p.cpf = pr.cpf_paciente\n"
                + " join pessoa pm on pm.cpf = pr.cpf_medico \n"
                + " join cirurgia_prontuario cp ON cp.id_prontuario = pr.id\n"
                + " join cirurgia c on c.id = cp.id_cirurgia\n"
                + " where cp.id_cirurgia = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            cd = new CirurgiaDao();
            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }

                p = new Prontuario();
                p.setId(rs.getInt("ID prontuario"));
                p.setData(rs.getDate("Data prontuario").toLocalDate());
                p.setHora(rs.getTime("Hora prontuario").toLocalTime());
                p.setMedico(fd.BuscarPorCpf(rs.getString("CPF Medico")));
                p.setPaciente(pd.BuscarPorCpf(rs.getString("CPF Paciente")));
                p.setDiagnostico(rs.getString("Diagnostico prontuario"));
                p.setExames(ed.listarPorProntuario(p.getId()));
                p.setMedicamentos(md.listarPorProntuario(p.getId()));
                p.setCirurgias(cd.listarPorProntuario(p.getId()));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prontuario_Buacar_Cirurgia" + e.getMessage());

        }
        fecharConexao();
        return p;

    }

    public Prontuario buscarPorExame(int id) {

        Prontuario p = null;
        pd = new PacienteDao();
        ed = new ExameDao();
        md = new MedicamentoDao();
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
        sql = (" SELECT p. cpf as \"CPF Paciente\",\n"
                + "pm. cpf as \"CPF Medico\",\n"
                + "pm.ctps, pm.especialidade, pm.data_inscricao, pm.registro_profissional, pm.funcao,\n"
                + "pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\"\n"
                + "FROM prontuario pr \n"
                + "join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "join pessoa pm on pm.cpf = pr.cpf_medico \n"
                + "join exame_prontuario ep ON ep.prontuario_id = pr.id\n"
                + "join exame ex on ex.id = ep.exame_id\n"
                + "where ep.exame_id = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();
            cd = new CirurgiaDao();
            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }

                p = new Prontuario();
                p.setId(rs.getInt("ID prontuario"));
                p.setData(rs.getDate("Data prontuario").toLocalDate());
                p.setHora(rs.getTime("Hora prontuario").toLocalTime());
                p.setMedico(fd.BuscarPorCpf(rs.getString("CPF Medico")));
                p.setPaciente(pd.BuscarPorCpf(rs.getString("CPF Paciente")));
                p.setDiagnostico(rs.getString("Diagnostico prontuario"));
                p.setExames(ed.listarPorProntuario(p.getId()));
                p.setMedicamentos(md.listarPorProntuario(p.getId()));
                p.setCirurgias(cd.listarPorProntuario(p.getId()));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return p;

    }

    public ArrayList<Prontuario> listarTodos() {

        try {
            conn = Conexao.getConexao();
            pd = new PacienteDao();
            ed = new ExameDao();
            md = new MedicamentoDao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Prontuario> prontuarios = null;
        sql = ("SELECT\n"
                + "p.cpf as \"CPF Paciente\",\n"
                + "pm.cpf as \"CPF Medico\",\n"
                + "pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\"\n"
                + "FROM prontuario pr \n"
                + "join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "join pessoa pm on pm.cpf = pr.cpf_medico");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            cd = new CirurgiaDao();
            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }

                Prontuario p = new Prontuario();
                p.setId(rs.getInt("ID prontuario"));
                p.setData(rs.getDate("Data prontuario").toLocalDate());
                p.setHora(rs.getTime("Hora prontuario").toLocalTime());
                p.setMedico(fd.BuscarPorCpf(rs.getString("CPF Medico")));
                p.setPaciente(pd.BuscarPorCpf(rs.getString("CPF Paciente")));
                p.setDiagnostico(rs.getString("Diagnostico prontuario"));
                p.setExames(ed.listarPorProntuario(p.getId()));
                p.setMedicamentos(md.listarPorProntuario(p.getId()));
                p.setCirurgias(cd.listarPorProntuario(p.getId()));
                prontuarios.add(p);
            }
        } catch (Exception e) {

        }
        fecharConexao();
        return prontuarios;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
