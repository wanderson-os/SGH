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
import model.Acomodacao;
import model.Exame;

/**
 *
 * @author Wanderson_M
 */
public class ExameDao {

    private Connection conn;
    private static ExameDao exameDao;

    private ExameDao() {

    }

    public static ExameDao getInstance() {
        if (exameDao == null) {
            exameDao = new ExameDao();
        }
        return exameDao;

    }

    public int cadastrar(Exame exame) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.exame(\n"
                + "	tipo, data, hora, valor, relatorio, sala_exame_id)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?);";
        try {
            Date data = Date.valueOf(exame.getData());
            Time hora = Time.valueOf(exame.getHora());
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, exame.getTipo());
            pStatement.setDate(2, data);
            pStatement.setTime(3, hora);
            pStatement.setDouble(4, exame.getValor());
            pStatement.setString(5, exame.getRelatorio());
            pStatement.setInt(6, exame.getSalaExame().getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return ret;
    }

    public int alterar(Exame exame) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.exame\n"
                + "	SET tipo=?, data=?, hora=?, valor=?, relatorio=?, sala_exame_id=?\n"
                + "	WHERE id = ?";
        try {
            Date data = Date.valueOf(exame.getData());
            Time hora = Time.valueOf(exame.getHora());
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, exame.getTipo());
            pStatement.setDate(2, data);
            pStatement.setTime(3, hora);
            pStatement.setDouble(4, exame.getValor());
            pStatement.setString(5, exame.getRelatorio());
            pStatement.setInt(6, exame.getSalaExame().getId());
            pStatement.setInt(7, exame.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        fecharConexao();
        return ret;
    }

    public int add(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.exame_prontuario\n"
                + "	SET prontuario_id =? \n"
                + "	WHERE prontuario_id is null;";
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

    public int excluir(Exame exame) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from exame where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, exame.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        fecharConexao();
        return ret;

    }

    public ArrayList<Exame> listar() {

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Exame> exames = null;
        sql = ("SELECT e.tipo, e.data, e.hora, e.valor, e.relatorio, e.sala_exame_id, e.id as id_exame, "
                + "a.numero, a.tipo, a.id as id_sala\n"
                + "	FROM public.exame e "
                + "join acomodacao a on a.id = e.sala_exame_id");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    exames = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                Acomodacao salaExame = new Acomodacao(rs.getInt("numero"), rs.getString("tipo"), rs.getInt("id_sala"));

                Exame e = new Exame();
                e.setTipo(rs.getString("tipo"));
                e.setData(data);
                e.setHora(hora);
                e.setRelatorio(rs.getString("relatorio"));
                e.setValor(rs.getFloat("valor"));
                e.setSalaExameId(rs.getInt("sala_exame_id"));
                e.setId(rs.getInt("id_exame"));
                e.setSalaExame(salaExame);
                exames.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();

        return exames;

    }

    public ArrayList<Exame> listarPorProntuario(int id) {

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Exame> exames = null;
        sql = ("SELECT e.tipo, e.data, e.hora, e.valor, e.relatorio, e.sala_exame_id, e.id as id_exame, a.numero, a.tipo, a.id as id_sala\n"
                + "	FROM public.exame e join acomodacao a on a.id = e.sala_exame_id \n"
                + "	join exame_prontuario as ep on ep.exame_id = e.id \n"
                + "	where ep.prontuario_id = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    exames = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                Acomodacao salaExame = new Acomodacao(rs.getInt("numero"), rs.getString("tipo"), rs.getInt("id_sala"));

                Exame e = new Exame();
                e.setTipo(rs.getString("tipo"));
                e.setData(data);
                e.setHora(hora);
                e.setRelatorio(rs.getString("relatorio"));
                e.setValor(rs.getFloat("valor"));
                e.setSalaExameId(rs.getInt("sala_exame_id"));
                e.setId(rs.getInt("id_exame"));
                e.setSalaExame(salaExame);

                exames.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();

        return exames;

    }

    public ArrayList<Exame> listarPorPaciente(String cpf) {

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Exame> exames = null;
        sql = ("SELECT e.tipo, e.data, e.hora, e.valor, e.relatorio, e.sala_exame_id, e.id as id_exame, a.numero, a.tipo, a.id as id_sala\n"
                + "              	FROM public.exame e join acomodacao a on a.id = e.sala_exame_id \n"
                + "               	join exame_prontuario as ep on ep.exame_id = e.id\n"
                + "				join prontuario p on p.id = ep.prontuario_id\n"
                + "               	where p.cpf_paciente = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cpf);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    exames = new ArrayList<>();
                    umaVez = false;
                }
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                Acomodacao salaExame = new Acomodacao(rs.getInt("numero"), rs.getString("tipo"), rs.getInt("id_sala"));

                Exame e = new Exame();
                e.setTipo(rs.getString("tipo"));
                e.setData(data);
                e.setHora(hora);
                e.setRelatorio(rs.getString("relatorio"));
                e.setValor(rs.getFloat("valor"));
                e.setSalaExameId(rs.getInt("sala_exame_id"));
                e.setId(rs.getInt("id_exame"));
                e.setSalaExame(salaExame);

                exames.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();

        return exames;

    }

    public int excluriNulos() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        int r = 0;
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Integer> ids = null;
        sql = ("select exame_id from exame_prontuario where prontuario_id is null");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    ids = new ArrayList<>();
                    umaVez = false;
                }
                int id = rs.getInt("exame_id");
                ids.add(id);
            }
            r = 1;
            if (ids != null) {
                for (int i = 0; i < ids.size(); i++) {
                    excluirEPNulo(ids.get(i));
                }

            }

        } catch (Exception e) {

        }
        fecharConexao();
        return r;
    }

    private int excluirEPNulo(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from exame where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir cirurgia nula: " + e.getMessage());

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<Integer> fechou() {

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<Integer> ids = null;
        sql = ("select exame_id from exame_prontuario where prontuario+id is null");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    ids = new ArrayList<>();
                    umaVez = false;
                }
                int id = rs.getInt("exame_id");

                ids.add(id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();

        return ids;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
