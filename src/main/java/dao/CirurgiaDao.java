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
import model.Cirurgia;
import model.Prontuario;

/**
 *
 * @author Wanderson_M
 */
public class CirurgiaDao {

    private Connection conn;
    private ProntuarioDao pd;

    public int cadastrar(Cirurgia cirurgia) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "INSERT INTO public.cirurgia(\n"
                + "	id_equipe_cirurgica, data, hora, valor, relatorio, sala_cirurgica_id)\n"
                + "	VALUES (?, ?, ?, ?, ?, ?);";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, cirurgia.getEquipeCirugica().getId());
            Date data = Date.valueOf(cirurgia.getData());
            pStatement.setDate(2, data);
            Time hora = Time.valueOf(cirurgia.getHora());
            pStatement.setTime(3, hora);
            pStatement.setDouble(4, cirurgia.getValor());
            pStatement.setString(5, cirurgia.getRelatorio());
            pStatement.setInt(6, cirurgia.getSalaCirurgia().getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return ret;
    }

    public int addCirurgiaP(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.cirurgia_prontuario\n"
                + "               SET id_prontuario = ? WHERE id_prontuario is null";
        try {

            pStatement = conn.prepareStatement(sql);

            pStatement.setInt(1, id);
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return ret;
    }

    public int alterar(Cirurgia cirurgia) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "UPDATE public.cirurgia\n"
                + "	SET id_equipe_cirurgica=?, data=?, hora=?, valor=?, relatorio=?, sala_cirurgica_id=?\n"
                + "	WHERE id = ?";
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, cirurgia.getEquipeCirugica().getId());
            Date data = Date.valueOf(cirurgia.getData());
            pStatement.setDate(2, data);
            Time hora = Time.valueOf(cirurgia.getHora());
            pStatement.setTime(3, hora);
            pStatement.setDouble(4, cirurgia.getValor());
            pStatement.setString(5, cirurgia.getRelatorio());
            pStatement.setInt(6, cirurgia.getSalaCirurgia().getId());
            pStatement.setInt(7, cirurgia.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        fecharConexao();
        return ret;
    }

    public int excluir(Cirurgia cirurgia) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from cirurgia where id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, cirurgia.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir cirurgia: " + e.getMessage());

        }

        fecharConexao();
        return ret;

    }

    public int excluirCP(Prontuario p) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from cirurgia where cirurgia_id = ?";
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, p.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Excluir cirurgia_prontuario: " + e.getMessage());

        }

        fecharConexao();
        return ret;

    }

    private int excluirCPNulo(int id) {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        int ret = 0;
        PreparedStatement pStatement = null;
        sql = "delete from cirurgia where id = ?";
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

    public ArrayList<Cirurgia> listar() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        EquipeCirurgicaDao ecd = new EquipeCirurgicaDao();
        ArrayList<Cirurgia> cirurgias = null;
        pd = new ProntuarioDao();
        sql = ("SELECT c.id_equipe_cirurgica, c.data, c.hora, c.valor, c.relatorio, c.sala_cirurgica_id, c.id\n"
                + "	,ac.id, ac.tipo, ac.numero FROM cirurgia c \n"
                + "	join acomodacao ac on ac.id = c.sala_cirurgica_id");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    cirurgias = new ArrayList<>();
                    umaVez = false;
                }
                Cirurgia c = new Cirurgia();
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                c.setEquipeCirurgicaId(rs.getInt("id_equipe_cirurgica"));
                c.setData(data);
                c.setHora(hora);
                c.setId(rs.getInt("id"));
                c.setRelatorio(rs.getString("relatorio"));
                c.setValor(rs.getFloat("valor"));
                c.setSalaCirurgicaId(rs.getInt("id"));
                Acomodacao salaCirurgica = new Acomodacao(rs.getInt("numero"), rs.getString("tipo"), rs.getInt("id"));
                c.setSalaCirurgia(salaCirurgica);
                c.setEquipeCirugica(ecd.listarUnica(c.getEquipeCirurgicaId()));
                cirurgias.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return cirurgias;

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
        sql = ("select id_cirurgia from cirurgia_prontuario where id_prontuario is null");
        try {
            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    ids = new ArrayList<>();
                    umaVez = false;
                }
                int id = rs.getInt("id_cirurgia");
                ids.add(id);
            }
            if (ids != null) {
                for (int i = 0; i < ids.size(); i++) {
                    excluirCPNulo(ids.get(i));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        fecharConexao();
        return r;
    }

    public ArrayList<Cirurgia> listarPorProntuario(int id) {
        int r = 0;
        pd = new ProntuarioDao();

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        EquipeCirurgicaDao ecd = new EquipeCirurgicaDao();
        ArrayList<Cirurgia> cirurgias = null;
        sql = ("	SELECT c.id_equipe_cirurgica, c.data, c.hora, c.valor, c.relatorio, c.sala_cirurgica_id, c.id\n"
                + "                ,ac.id, ac.tipo, ac.numero FROM cirurgia c\n"
                + "                join acomodacao ac on ac.id = c.sala_cirurgica_id\n"
                + "				join cirurgia_prontuario pr on pr.id_cirurgia = c.id\n"
                + "				where pr.id_prontuario = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    cirurgias = new ArrayList<>();
                    umaVez = false;
                }
                Cirurgia c = new Cirurgia();
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                c.setData(data);
                c.setHora(hora);
                c.setId(rs.getInt("id"));
                c.setRelatorio(rs.getString("relatorio"));
                c.setValor(rs.getFloat("valor"));
                c.setSalaCirurgicaId(rs.getInt("id"));
                Acomodacao salaCirurgica = new Acomodacao(rs.getInt("numero"), rs.getString("tipo"), rs.getInt("id"));
                c.setSalaCirurgia(salaCirurgica);
                c.setEquipeCirugica(ecd.listarUnica(c.getId()));
                cirurgias.add(c);
                r = 1;
            }

        } catch (Exception e) {

        }
        fecharConexao();
        return cirurgias;

    }

    public ArrayList<Cirurgia> listarPorPaciente(String cpf) {
        int r = 0;
        pd = new ProntuarioDao();

        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        EquipeCirurgicaDao ecd = new EquipeCirurgicaDao();
        ArrayList<Cirurgia> cirurgias = null;
        sql = ("SELECT c.id_equipe_cirurgica, c.data, c.hora, c.valor, c.relatorio, c.sala_cirurgica_id, c.id, p.id as \"prontuario_id\"\n"
                + ", a.numero, a.tipo, a.id as id_a "
                + "FROM cirurgia c\n"
                + "join acomodacao a on a.id = c.sala_cirurgica_id"
                + "	join cirurgia_prontuario pr on pr.id_cirurgia = c.id\n"
                + "	join prontuario p on  p.id = pr.id_prontuario "
                + "where p.cpf_paciente = ?");
        try {
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, cpf);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    cirurgias = new ArrayList<>();
                    umaVez = false;
                }
                Cirurgia c = new Cirurgia();
                LocalDate data = rs.getDate("data").toLocalDate();
                LocalTime hora = rs.getTime("hora").toLocalTime();
                c.setData(data);
                c.setHora(hora);
                c.setId(rs.getInt("id"));
                c.setRelatorio(rs.getString("relatorio"));
                c.setValor(rs.getFloat("valor"));
                c.setSalaCirurgicaId(rs.getInt("id"));
                Acomodacao salaCirurgica = new Acomodacao(rs.getInt("numero"), rs.getString("tipo"), rs.getInt("id_a"));
                c.setSalaCirurgia(salaCirurgica);
                c.setEquipeCirugica(ecd.listarUnica(rs.getInt("id_equipe_cirurgica")));
                cirurgias.add(c);
                r = 1;

            }

        } catch (Exception e) {
            e.printStackTrace();
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
