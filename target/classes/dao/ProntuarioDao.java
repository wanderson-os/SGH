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
import model.Funcionario;
import model.Paciente;
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class ProntuarioDao {

    private static ProntuarioDao prontuarioDao;

    public static ProntuarioDao getInstance() {
        if (prontuarioDao == null) {
            prontuarioDao = new ProntuarioDao();
        }
        return prontuarioDao;

    }

    private ProntuarioDao() {
    }

    private Connection conn;
    private PacienteDao pd;
    private FuncionarioDao fd;
    private ExameDao ed;
    private MedicamentoDao md;
    private AltaDao ad;
    private CirurgiaDao cd;

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
                + "	cpf_medico, cpf_paciente, data, hora, diagnostico,gerou_pagamento)\n"
                + "	VALUES (?, ?, ?, ?, ?,?)";
        try {
            Date data = Date.valueOf(prontuario.getData());

            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, prontuario.getMedico().getCpf());
            pStatement.setString(2, prontuario.getPaciente().getCpf());
            pStatement.setDate(3, data);
            Time hora = Time.valueOf(prontuario.getHora());
            pStatement.setTime(4, hora);
            pStatement.setString(5, prontuario.getDiagnostico());
            pStatement.setBoolean(6, false);
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
        pd = PacienteDao.getInstance();
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        cd = CirurgiaDao.getInstance();
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

    public ArrayList<Prontuario> listarParaAlta() {

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
        sql = ("select p.nome as paciente, p.sobrenome as sobrenome_p, pr.cpf_paciente, m.nome as medico,m.sobrenome as sobrenome_m, pr.cpf_medico, pr.data, pr.hora, pr.id as id_prontuario\n"
                + "                from pessoa p\n"
                + "                join prontuario pr on pr.cpf_paciente = p.cpf\n"
                + "                join pessoa m on pr.cpf_medico = m.cpf\n"
                + "				join cirurgia_prontuario cp on cp.id_prontuario = pr.id\n"
                + "                where pr.alta_id is null");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }

                Prontuario p = new Prontuario();
                p.setId(rs.getInt("id_prontuario"));
                p.setData(rs.getDate("data").toLocalDate());
                p.setHora(rs.getTime("hora").toLocalTime());
                Funcionario m = new Funcionario();
                m.setNome(rs.getString("medico"));
                m.setSobrenome(rs.getString("sobrenome_m"));
                m.setCpf(rs.getString("cpf_medico"));
                Paciente pa = new Paciente();
                pa.setNome(rs.getString("paciente"));
                pa.setSobrenome(rs.getString("sobrenome_p"));
                pa.setCpf(rs.getString("cpf_paciente"));

                p.setPaciente(pa);
                p.setMedico(m);
                prontuarios.add(p);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return prontuarios;

    }

    public ArrayList<Prontuario> listarParaAltaNaoNulos() {
        ad = AltaDao.getInstance();
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
        sql = ("select p.nome as paciente, p.sobrenome as sobrenome_p, pr.cpf_paciente, m.nome as medico,m.sobrenome as sobrenome_m, pr.cpf_medico, pr.data, pr.hora, pr.id as id_prontuario\n"
                + "                , pr.alta_id\n"
                + "                from pessoa p\n"
                + "                join prontuario pr on pr.cpf_paciente = p.cpf\n"
                + "                join alta a on a.id = pr.alta_id\n"
                + "                join pessoa m on pr.cpf_medico = m.cpf");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    prontuarios = new ArrayList<>();
                    umaVez = false;
                }

                Prontuario p = new Prontuario();
                p.setId(rs.getInt("id_prontuario"));
                p.setData(rs.getDate("data").toLocalDate());
                p.setHora(rs.getTime("hora").toLocalTime());
                Funcionario m = new Funcionario();
                m.setNome(rs.getString("medico"));
                m.setSobrenome(rs.getString("sobrenome_m"));
                m.setCpf(rs.getString("cpf_medico"));
                Paciente pa = new Paciente();
                pa.setNome(rs.getString("paciente"));
                pa.setSobrenome(rs.getString("sobrenome_p"));
                pa.setCpf(rs.getString("cpf_paciente"));
                p.setAlta(ad.buscarPor_id(rs.getInt("alta_id")));
                p.setPaciente(pa);
                p.setMedico(m);
                prontuarios.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return prontuarios;

    }

    public Prontuario buscarPorCirurgia(int id) {
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        cd = CirurgiaDao.getInstance();
        pd = PacienteDao.getInstance();

        Prontuario p = null;
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
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        cd = CirurgiaDao.getInstance();
        pd = PacienteDao.getInstance();

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
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        ad = AltaDao.getInstance();
        cd = CirurgiaDao.getInstance();
        pd = PacienteDao.getInstance();

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
        sql = ("SELECT\n"
                + "p.cpf as \"CPF Paciente\",\n"
                + "                pm.cpf as \"CPF Medico\",\n"
                + "               pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\",\n"
                + "                pr.alta_id\n"
                + "                FROM prontuario pr \n"
                + "                join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "                join pessoa pm on pm.cpf = pr.cpf_medico");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
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
                p.setAlta(ad.buscarPor_id(rs.getInt("alta_id")));
                prontuarios.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        fecharConexao();
        return prontuarios;

    }

    public ArrayList<Prontuario> listarNaoPagos() {
        cd = CirurgiaDao.getInstance();
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        ad = AltaDao.getInstance();
        pd = PacienteDao.getInstance();
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
        sql = ("SELECT p.cpf as \"CPF Paciente\",\n"
                + "pm.cpf as \"CPF Medico\",\n"
                + "pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\",\n"
                + "pr.alta_id\n"
                + "FROM prontuario pr \n"
                + "join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "join pessoa pm on pm.cpf = pr.cpf_medico\n"
                + "where gerou_pagamento = false");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
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
                p.setAlta(ad.buscarPor_id(rs.getInt("alta_id")));
                prontuarios.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        fecharConexao();
        return prontuarios;

    }

    public ArrayList<Prontuario> listarGeradosNaoPagos() {
        cd = CirurgiaDao.getInstance();
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        ad = AltaDao.getInstance();
        pd = PacienteDao.getInstance();
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
        sql = ("SELECT p.cpf as \"CPF Paciente\",\n"
                + "                pm.cpf as \"CPF Medico\",\n"
                + "                pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\",\n"
                + "                pr.alta_id\n"
                + "                FROM prontuario pr \n"
                + "               join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "               join pessoa pm on pm.cpf = pr.cpf_medico\n"
                + "                join pagamento pg on pg.id_prontuario = pr.id\n"
                + "                where pr.gerou_pagamento = true");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
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
                p.setAlta(ad.buscarPor_id(rs.getInt("alta_id")));
                prontuarios.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        fecharConexao();
        return prontuarios;

    }

    public Prontuario buscarPorId(int id) {
        cd = CirurgiaDao.getInstance();
        fd = FuncionarioDao.getInstance();
        ed = ExameDao.getInstance();
        md = MedicamentoDao.getInstance();
        ad = AltaDao.getInstance();
        pd = PacienteDao.getInstance();
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        Prontuario p = null;
        boolean umaVez = true;
        sql = ("SELECT p.cpf as \"CPF Paciente\",\n"
                + "                pm.cpf as \"CPF Medico\",\n"
                + "                pr.data as \"Data prontuario\", pr.hora as \"Hora prontuario\", pr.diagnostico as \"Diagnostico prontuario\", pr.id as \"ID prontuario\",\n"
                + "                pr.alta_id\n"
                + "                FROM prontuario pr \n"
                + "               join pessoa p on p.cpf = pr.cpf_paciente\n"
                + "               join pessoa pm on pm.cpf = pr.cpf_medico\n"
                + "			   join pagamento pg on pg.id_prontuario = pr.id\n"
                + "                where pr.gerou_pagamento = true");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            while (rs.next()) {

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
                p.setAlta(ad.buscarPor_id(rs.getInt("alta_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        fecharConexao();
        return p;

    }

    public ArrayList<Paciente> listarPacientesNaoPagosSemRepetir() {

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Paciente> pacientes = null;
        sql = ("SELECT distinct cpf, nome, sobrenome\n"
                + "FROM pessoa p\n"
                + "join prontuario pr on pr.cpf_paciente = p.cpf\n"
                + "where pr.id not in (select id_prontuario from pagamento)");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                if (umaVez) {
                    pacientes = new ArrayList();
                    umaVez = false;
                }

                Paciente p = new Paciente();
                p.setNome(rs.getString("nome"));
                p.setSobrenome(rs.getString("sobrenome"));
                p.setCpf(rs.getString("cpf"));
                pacientes.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        fecharConexao();
        return pacientes;

    }

    public ArrayList<Paciente> listarPacientesNaoPagosGeradosSemRepetir() {

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Paciente> pacientes = null;
        sql = ("	SELECT distinct cpf, nome, sobrenome\n"
                + "                FROM pessoa p\n"
                + "                join prontuario pr on pr.cpf_paciente = p.cpf\n"
                + "				where  pr.gerou_pagamento = true");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();
            while (rs.next()) {
                if (umaVez) {
                    pacientes = new ArrayList();
                    umaVez = false;
                }

                Paciente p = new Paciente();
                p.setNome(rs.getString("nome"));
                p.setSobrenome(rs.getString("sobrenome"));
                p.setCpf(rs.getString("cpf"));
                pacientes.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        fecharConexao();
        return pacientes;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
