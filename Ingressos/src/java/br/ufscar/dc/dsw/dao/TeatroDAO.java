package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.ingressos.Teatro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeatroDAO extends GenericDAO{
            
    private final static String LISTAR_TEATROS_POR_CIDADES_SQL = "select"
            + " a.cidade, a.cnpj, a.email, a.nome"
            + " from Teatro a"
            + " where a.cidade = ?";


    public TeatroDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Ingressos", "root", "root");
    }

    public void insert(Teatro teatro) {

        String sql = "INSERT INTO Teatro (email, senha, cnpj, nome, cidade) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setInt(3, teatro.getCnpj());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<Teatro> getAll() {

        List<Teatro> listaTeatros = new ArrayList<>();

        String sql = "SELECT * FROM Teatro";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                int cnpj = resultSet.getInt("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");

                Teatro teatro = new Teatro(email, senha, cnpj, nome, cidade);
                listaTeatros.add(teatro);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatros;
    }

    public void delete(Teatro teatro) {
        String sql = "DELETE FROM Teatro where cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, teatro.getCnpj());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Teatro teatro) {
        String sql = "UPDATE Teatro SET email = ?, senha = ?, cnpj = ?, nome = ?, cidade = ?";
        sql += " WHERE cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setInt(3, teatro.getCnpj());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Teatro getN(String nome) {
        Teatro teatro = null;
        String sql = "SELECT * FROM Teatro WHERE nome = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, nome);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha  = resultSet.getString("senha");
                int cnpj  = resultSet.getInt("cnpj");
                String cidade = resultSet.getString("cidade");
                teatro = new Teatro(email, senha, cnpj, nome, cidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }
    
    public List<Teatro> listarTodosTeatrosPorCidade(String st) throws SQLException {

        List<Teatro> ret = new ArrayList<>();

        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_TEATROS_POR_CIDADES_SQL);
            
            ps.setString(1, st);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cidade = rs.getString(1);
                int cnpj = rs.getInt(2);
                String email = rs.getString(3);
                String nome = rs.getString(4);
                Teatro teatro = new Teatro(cidade, cnpj, email, nome);
                ret.add(teatro);
            }
        }

        return ret;
    }
    
    public Teatro get(int cnpj) {
        Teatro teatro = null;
        String sql = "SELECT * FROM Teatro WHERE cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha  = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                teatro = new Teatro(email, senha, cnpj, nome, cidade);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teatro;
    }
   
}
