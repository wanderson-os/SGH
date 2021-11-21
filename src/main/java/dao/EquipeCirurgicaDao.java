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
            System.out.println("ID: " + equipeCirurgica.getId());
            pStatement.execute();
            pStatement.close();
            ret = 1;

        } catch (Exception e) {
            e.printStackTrace();
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

        }

        fecharConexao();
        return ret;

    }

    public ArrayList<EquipeCirurgica> listarE() {
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;
        boolean umaVez = true;
        ArrayList<EquipeCirurgica> equipeCirurgicas = null;

        sql = ("select * from equipe_cirurgica_completa");
        try {

            pStatement = conn.prepareStatement(sql);
            rs = pStatement.executeQuery();

            while (rs.next()) {
                if (umaVez) {
                    equipeCirurgicas = new ArrayList<>();
                    umaVez = false;
                }
                Funcionario circulante = new Funcionario();
                circulante.setCpf(rs.getString("cpf_circulante"));
                circulante.setNome(rs.getString("nome_circulante"));
                circulante.setSobrenome(rs.getString("sobrenome_circulante"));

                Funcionario enfermeiro = new Funcionario();
                enfermeiro.setCpf(rs.getString("cpf_enfermeiro"));
                enfermeiro.setNome(rs.getString("nome_enfermeiro"));
                enfermeiro.setSobrenome(rs.getString("sobrenome_enfermeiro"));

                Funcionario instrumentador = new Funcionario();
                instrumentador.setCpf(rs.getString("cpf_instrumentador"));
                instrumentador.setNome(rs.getString("nome_instrumentador"));
                instrumentador.setSobrenome(rs.getString("sobrenome_instrumentador"));

                Funcionario cirurgiaoP = new Funcionario();
                cirurgiaoP.setCpf(rs.getString("cpf_cirurgiao_p"));
                cirurgiaoP.setNome(rs.getString("nome_cirurgiao_p"));
                cirurgiaoP.setSobrenome(rs.getString("sobrenome_cirurgiao_p"));

                Funcionario cirurgiaoA = new Funcionario();
                cirurgiaoA.setCpf(rs.getString("cpf_cirurgiao_a"));
                cirurgiaoA.setNome(rs.getString("nome_cirurgiao_a"));
                cirurgiaoA.setSobrenome(rs.getString("sobrenome_cirurgiao_a"));

                Funcionario anestesista = new Funcionario();
                anestesista.setCpf(rs.getString("cpf_anestesista"));
                anestesista.setNome(rs.getString("nome_anestesista"));
                anestesista.setSobrenome(rs.getString("sobrenome_anestesista"));
                EquipeCirurgica equipeCirurgica = new EquipeCirurgica();
                equipeCirurgica.setAnestesista(anestesista);
                equipeCirurgica.setCirculante(circulante);
                equipeCirurgica.setCirurgiaoAssistente(cirurgiaoA);
                equipeCirurgica.setCirurgiaoPrincipal(cirurgiaoP);
                equipeCirurgica.setEnfermeiroChefe(enfermeiro);
                equipeCirurgica.setInstrumentador(instrumentador);
                equipeCirurgica.setId(rs.getInt("id"));

                equipeCirurgicas.add(equipeCirurgica);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return equipeCirurgicas;

    }

    public EquipeCirurgica listarUnica(int id) {
        EquipeCirurgica equipeCirurgica = null;
        try {
            conn = Conexao.getConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        sql = (" SELECT ec.id,\n"
                + "    cp.cpf AS cpf_cirurgiao_p,\n"
                + "    cp.nome AS nome_cirurgiao_p,\n"
                + "    cp.sobrenome AS sobrenome_cirurgiao_p,\n"
                + "    ca.cpf AS cpf_cirurgiao_a,\n"
                + "    ca.nome AS nome_cirurgiao_a,\n"
                + "    ca.sobrenome AS sobrenome_cirurgiao_a,\n"
                + "    a.cpf AS cpf_anestesista,\n"
                + "    a.nome AS nome_anestesista,\n"
                + "    a.sobrenome AS sobrenome_anestesista,\n"
                + "    c.cpf AS cpf_circulante,\n"
                + "    c.nome AS nome_circulante,\n"
                + "    c.sobrenome AS sobrenome_circulante,\n"
                + "    i.cpf AS cpf_instrumentador,\n"
                + "    i.nome AS nome_instrumentador,\n"
                + "    i.sobrenome AS sobrenome_instrumentador,\n"
                + "    e.cpf AS cpf_enfermeiro,\n"
                + "    e.nome AS nome_enfermeiro,\n"
                + "    e.sobrenome AS sobrenome_enfermeiro\n"
                + "   FROM pessoa cp\n"
                + "     JOIN equipe_cirurgica ec ON cp.cpf::text = ec.cpf_cirurgiao_p\n"
                + "     JOIN pessoa ca ON ca.cpf::text = ec.cpf_cirurgiao_a\n"
                + "     JOIN pessoa a ON a.cpf::text = ec.cpf_anestesista\n"
                + "     JOIN pessoa c ON c.cpf::text = ec.cpf_circulante\n"
                + "     JOIN pessoa i ON i.cpf::text = ec.cpf_instrumentador\n"
                + "     JOIN pessoa e ON e.cpf::text = ec.cpf_enfermeiro\n"
                + "	  join cirurgia cr on cr.id_equipe_cirurgica = ec.id\n"
                + "	  join cirurgia_prontuario cpr on cpr.id_cirurgia = cr.id\n"
                + "		where cpr.id_cirurgia = ?");
        try {

            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            rs = pStatement.executeQuery();

            while (rs.next()) {

                Funcionario circulante = new Funcionario();
                circulante.setCpf(rs.getString("cpf_circulante"));
                circulante.setNome(rs.getString("nome_circulante"));
                circulante.setSobrenome(rs.getString("sobrenome_circulante"));

                Funcionario enfermeiro = new Funcionario();
                enfermeiro.setCpf(rs.getString("cpf_enfermeiro"));
                enfermeiro.setNome(rs.getString("nome_enfermeiro"));
                enfermeiro.setSobrenome(rs.getString("sobrenome_enfermeiro"));

                Funcionario instrumentador = new Funcionario();
                instrumentador.setCpf(rs.getString("cpf_instrumentador"));
                instrumentador.setNome(rs.getString("nome_instrumentador"));
                instrumentador.setSobrenome(rs.getString("sobrenome_instrumentador"));

                Funcionario cirurgiaoP = new Funcionario();
                cirurgiaoP.setCpf(rs.getString("cpf_cirurgiao_p"));
                cirurgiaoP.setNome(rs.getString("nome_cirurgiao_p"));
                cirurgiaoP.setSobrenome(rs.getString("sobrenome_cirurgiao_p"));

                Funcionario cirurgiaoA = new Funcionario();
                cirurgiaoA.setCpf(rs.getString("cpf_cirurgiao_a"));
                cirurgiaoA.setNome(rs.getString("nome_cirurgiao_a"));
                cirurgiaoA.setSobrenome(rs.getString("sobrenome_cirurgiao_a"));

                Funcionario anestesista = new Funcionario();
                anestesista.setCpf(rs.getString("cpf_anestesista"));
                anestesista.setNome(rs.getString("nome_anestesista"));
                anestesista.setSobrenome(rs.getString("sobrenome_anestesista"));
                equipeCirurgica = new EquipeCirurgica(cirurgiaoP, cirurgiaoA, enfermeiro, anestesista, instrumentador, circulante);
            
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        fecharConexao();
        return equipeCirurgica;

    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
        }
    }

}
