/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Site;
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
public class SiteDAO extends GenericDAO {

    public SiteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Ingressos", "root", "root");
    }

    public void insert(Site site) {

        String sql = "INSERT INTO Site (email, nome, endereco, senha, telefone) VALUES (?, ?, ?, ?, ?)";

        try {
            if (get(site.getEndereco()) == null) {
                Connection conn = this.getConnection();
                PreparedStatement statement = conn.prepareStatement(sql);

                statement = conn.prepareStatement(sql);
                statement.setString(1, site.getEmail());
                statement.setString(2, site.getNome());
                statement.setString(3, site.getEndereco());
                statement.setString(4, site.getSenha());
                statement.setInt(5, site.getTelefone());
                statement.executeUpdate();

                statement.close();
                conn.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Site> getAll() {

        List<Site> listaSites = new ArrayList<>();

        String sql = "SELECT * FROM Site";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String senha = resultSet.getString("senha");
                int telefone = resultSet.getInt("telefone");

                Site site = new Site(email, nome, endereco, senha, telefone);
                listaSites.add(site);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }

    public void delete(Site site) {
        String sql = "DELETE FROM Site where endereco = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, site.getEndereco());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Site site) {
        String sql = "UPDATE Site SET email = ?, nome = ?, senha = ?, telefone = ?";
        sql += " WHERE endereco = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, site.getEmail());
            statement.setString(2, site.getNome());
            statement.setString(5, site.getEndereco());
            statement.setString(3, site.getSenha());
            statement.setInt(4, site.getTelefone());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Site getN(String email, String senha) {
        Site site = null;
        String sql = "SELECT * FROM Site WHERE email = ? and senha = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                int telefone = resultSet.getInt("telefone");
                site = new Site(email, nome, endereco, senha, telefone);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    public Site get(String endereco) {
        Site site = null;
        String sql = "SELECT * FROM Site WHERE endereco = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, endereco);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                int telefone = resultSet.getInt("telefone");
                site = new Site(email, nome, endereco, senha, telefone);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    public boolean Verifica(String email, String senha) {
        String sql1 = "select * from Site where email = ? or senha = ?";
        String sql2 = "select * from Teatro where email = ? or senha = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql1);
            statement.setString(1, email);
            statement.setString(2, senha);
            PreparedStatement st = conn.prepareStatement(sql2);
            st.setString(1, email);
            st.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();
            ResultSet rs = st.executeQuery();
            if (resultSet.next() || rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void save(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void delete(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
