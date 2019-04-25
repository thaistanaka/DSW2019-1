/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.ingressos.Promocao;
import br.ufscar.dc.dsw.model.ingressos.Site;
import br.ufscar.dc.dsw.model.ingressos.Teatro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows
 */
public class PromocaoDAO extends GenericDAO{
    
    private final static String LISTAR_PROMOCOES_DE_UM_SITE_SQL = "select"
            + " a.nome, a.endereco_site, a.preco, a.dia, a.hora,"
            + " u.email, u.nome, u.telefone"
            + " from Promocao a inner join Site u on a.endereco_site = u.endereco_site"
            + " where a.endereco = ?";
    
    private final static String LISTAR_PROMOCOES_DE_UM_TEATRO_SQL = "select"
            + " a.nome, a.endereco_site, a.preco, a.dia, a.hora,"
            + " u.cidade, u.email, u.nome"
            + " from Promocao a inner join Teatro u on a.cnpj_teatro = u.cnpj"
            + " where a.cnpj_teatro = ?";
    
    public PromocaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Ingressos", "root", "root");
    }

    public void insert(Promocao promocao) {

        String sql = "INSERT INTO Promocao (endereco_site, cnpj_teatro, nome, preco, dia, hora) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getEndereco());
            statement.setInt(2, promocao.getCnpj());
            statement.setString(3, promocao.getNome());
            statement.setFloat(4, promocao.getPreco());
            statement.setString(5, promocao.getDia());
            statement.setString(6, promocao.getHora());            
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<Promocao> getAll() {

        List<Promocao> listaPromocoes = new ArrayList<>();

        String sql = "SELECT * FROM Promocao";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String dia = resultSet.getString("dia");
                String hora = resultSet.getString("hora");
                String endereco = resultSet.getString("endereco_site");
                String nome = resultSet.getString("nome");
                float preco = resultSet.getFloat("preco");
                int cnpj = resultSet.getInt("cnpj_teatro");

                Promocao promocao = new Promocao(endereco, cnpj, nome, preco, dia, hora);
                listaPromocoes.add(promocao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }
    
    public void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocao where dia = ? and hora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, promocao.getDia());
            statement.setString(2, promocao.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET endereco_site = ?, cnpj_teatro = ?, nome = ?, preco = ?";
        sql += " WHERE dia = ? and hora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, promocao.getEndereco());
            statement.setInt(2, promocao.getCnpj());
            statement.setString(3, promocao.getNome());
            statement.setFloat(4, promocao.getPreco());
            statement.setString(5, promocao.getDia());
            statement.setString(6, promocao.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Promocao get(String dia, String hora) {
        Promocao promocao = null;
        String sql = "SELECT * FROM Promocao WHERE dia = ? and hora = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, dia);
            statement.setString(2, hora);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String endereco = resultSet.getString("endereco_site");
                int cnpj = resultSet.getInt("cnpj_teatro");
                String nome = resultSet.getString("nome");
                float preco = resultSet.getFloat("preco");
                promocao = new Promocao(endereco, cnpj, nome, preco, dia, hora);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
    
    public List<Promocao> listarTodasPromocoesDeUmTeatro(int cnpj) throws SQLException {
        List<Promocao> ret = new ArrayList<>();

        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_PROMOCOES_DE_UM_TEATRO_SQL);
            
            ps.setInt(1, cnpj);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Promocao promocao = new Promocao();
                Teatro teatro = new Teatro();
                teatro.setEmail(rs.getString("email"));
                teatro.setNome(rs.getString("nome"));
                teatro.setCidade(rs.getString("cidade"));
                promocao.setEndereco(rs.getString("endereco_site"));
                promocao.setNome(rs.getString("nome"));
                promocao.setPreco(rs.getFloat("preco"));
                promocao.setDia(rs.getString("dia"));
                promocao.setHora(rs.getString("hora"));
                ret.add(promocao);
            }
        }
        
        return ret;
    }
    
    public List<Promocao> listarTodasPromocoesDeUmSite(String endereco) throws SQLException {

        List<Promocao> ret = new ArrayList<>();

        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_PROMOCOES_DE_UM_SITE_SQL);
            
            ps.setString(1, endereco);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Promocao promocao = new Promocao();
                Site site = new Site();
                site.setEmail(rs.getString("email"));
                site.setNome(rs.getString("nome"));
                site.setTelefone(rs.getInt("telefone"));
                promocao.setEndereco(rs.getString("endereco_site"));
                promocao.setNome(rs.getString("nome"));
                promocao.setPreco(rs.getFloat("preco"));
                promocao.setDia(rs.getString("dia"));
                promocao.setHora(rs.getString("hora"));
                ret.add(promocao);
            }
        }
        return ret;
    }
}
