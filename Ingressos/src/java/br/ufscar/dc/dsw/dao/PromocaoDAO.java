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
            + " a.nome, a.endereco, a.preco, a.dia, a.hora,"
            + " u.email, u.nome, u.telefone"
            + " from Promocao a inner join Site u on a.endereco = u.endereco";
    
    private final static String LISTAR_PROMOCOES_DE_UM_TEATRO_SQL = "select"
            + " a.nome, a.endereco, a.preco, a.dia, a.hora,"
            + " u.cidade, u.email, u.nome"
            + " from Promocao a inner join Teatro u on a.cnpj = u.cnpj";
    
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

        String sql = "INSERT INTO Promocao (id, endereco, cnpj, nome, preco, dia, hora) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setInt(1, promocao.getId());
            statement.setString(2, promocao.getEndereco());
            statement.setInt(3, promocao.getCnpj());
            statement.setString(4, promocao.getNome());
            statement.setFloat(5, promocao.getPreco());
            statement.setString(6, promocao.getDia());
            statement.setString(7, promocao.getHora());            
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
                String endereco = resultSet.getString("endereco");
                String nome = resultSet.getString("nome");
                float preco = resultSet.getFloat("preco");
                int cnpj = resultSet.getInt("cnpj");
                int id = resultSet.getInt("id");

                Promocao promocao = new Promocao(id, endereco, cnpj, nome, preco, dia, hora);
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
        String sql = "DELETE FROM Promocao where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, promocao.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET id = ?, endereco = ?, cnpj = ?, nome = ?, preco = ?, dia = ?, hora = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(2, promocao.getEndereco());
            statement.setInt(1, promocao.getId());
            statement.setInt(3, promocao.getCnpj());
            statement.setString(4, promocao.getNome());
            statement.setFloat(5, promocao.getPreco());
            statement.setString(6, promocao.getDia());
            statement.setString(7, promocao.getHora());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Promocao get(int id) {
        Promocao promocao = null;
        String sql = "SELECT * FROM Promocao WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String endereco = resultSet.getString("endereco");
                int cnpj = resultSet.getInt("cnpj");
                String nome = resultSet.getString("nome");
                float preco = resultSet.getFloat("preco");
                String dia = resultSet.getString("dia");
                String hora = resultSet.getString("hora");
                promocao = new Promocao(id, endereco, cnpj, nome, preco, dia, hora);
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
                teatro.setSenha(rs.getString("senha"));
                teatro.setEmail(rs.getString("email"));
                teatro.setCnpj(rs.getInt("cnpj"));
                teatro.setNome(rs.getString("nome"));
                teatro.setCidade(rs.getString("cidade"));
                promocao.setId(rs.getInt("id"));
                promocao.setEndereco(rs.getString("endereco"));
                promocao.setCnpj(rs.getInt("cnpj"));
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
                site.setEndereco(rs.getString("endereco"));
                site.setNome(rs.getString("nome"));
                site.setSenha(rs.getString("senha"));
                site.setTelefone(rs.getInt("telefone"));
                promocao.setId(rs.getInt("id"));
                promocao.setEndereco(rs.getString("endereco"));
                promocao.setCnpj(rs.getInt("cnpj"));
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
