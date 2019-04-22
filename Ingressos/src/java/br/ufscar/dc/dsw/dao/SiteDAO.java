/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.ingressos.Site;
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
public class SiteDAO extends GenericDAO{

    public SiteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Ingressos", "root", "root");
    }

    public void insert(Site site) {

        String sql = "INSERT INTO Site (email, nome, endereco, senha, telefone) VALUES (?, ?, ?, ?, ?)";

        try {
            try (Connection conn = this.getConnection()) {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                statement = conn.prepareStatement(sql);
                statement.setString(1, site.getEmail());
                statement.setString(2, site.getNome());
                statement.setString(3, site.getEndereco());
                statement.setInt(4, site.getSenha());
                statement.setInt(5, site.getTelefone());
                statement.executeUpdate();
                
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<Site> getAll() {

        List<Site> listaSites = new ArrayList<>();

        String sql = "SELECT * FROM Site";

        try {
            try (Connection conn = this.getConnection()) {
                Statement statement = conn.createStatement();
                
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String nome = resultSet.getString("nome");
                    String endereco = resultSet.getString("endereco");
                    int senha = resultSet.getInt("senha");
                    int telefone = resultSet.getInt("telefone");
                    
                    Site site = new Site(email, senha, nome, endereco, telefone);
                    listaSites.add(site);
                }
                
                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }

    public void delete(Site site) {
        String sql = "DELETE FROM Site where endereco = ?";

        try {
            try (Connection conn = this.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
                
                statement.setString(1, site.getEndereco());
                statement.executeUpdate();
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Site site) {
        String sql = "UPDATE Site SET email = ?, nome = ?, endereco = ?, senha = ?, telefone = ?";
        sql += " WHERE endereco = ?";

        try {
            try (Connection conn = this.getConnection()) {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                statement.setString(1, site.getEmail());
                statement.setString(2, site.getNome());
                statement.setString(3, site.getEndereco());
                statement.setInt(4, site.getSenha());
                statement.setInt(5, site.getTelefone());
                statement.executeUpdate();
                
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Site get(String endereco) {
        Site site = null;
        String sql = "SELECT * FROM Site WHERE endereco = ?";

        try {
            try (Connection conn = this.getConnection()) {
                PreparedStatement statement = conn.prepareStatement(sql);
                
                statement.setString(1, endereco);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String email = resultSet.getString("email");
                    String nome = resultSet.getString("nome");
                    int senha  = resultSet.getInt("senha");
                    int telefone = resultSet.getInt("telefone");
                    site = new Site(email, senha, nome, endereco, telefone);
                }
                
                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
}
