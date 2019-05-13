/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
import br.ufscar.dc.dsw.pojo.Promocao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Windows
 */
public class PromocaoDAO extends GenericDAO<Promocao>{
    
    private final static String LISTAR_PROMOCOES_DE_UM_SITE_SQL = "select"
            + " a.nome as nomePromocao, a.endereco_site, a.preco, a.dia, a.hora, a.cnpj_teatro,"
            + " u.email, u.nome as nomeSite, u.telefone"
            + " from Promocao a inner join Site u on a.endereco_site = u.endereco"
            + " where a.endereco_site = ?";
    
    private final static String LISTAR_PROMOCOES_DE_UM_TEATRO_SQL = "select"
            + " a.nome as nomePromocao, a.endereco_site, a.preco, a.dia, a.hora, a.cnpj_teatro,"
            + " u.cidade, u.email, u.nome as nomeTeatro"
            + " from Promocao a inner join Teatro u on a.cnpj_teatro = u.cnpj"
            + " where a.cnpj_teatro = ?";
    
    public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Promocao e", Promocao.class);
        List<Promocao> editoras = q.getResultList();
        em.close();
        return editoras;
    }
    
    @Override
    public void delete(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        promocao = em.getReference(Promocao.class, promocao.get());
        tx.begin();
        em.remove(promocao);
        tx.commit();
    }

    @Override
    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET endereco_site = ?, cnpj_teatro = ?, nome = ?, preco = ?";
        sql += " WHERE ((endereco_site = ? and dia = ?) and hora = ?)";

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

    public Promocao get(String dia, String hora, String endereco) {
        Promocao promocao = null;
        String sql = "SELECT * FROM Promocao WHERE ((dia = ? and hora = ?) and endereco_site = ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, dia);
            statement.setString(2, hora);
            statement.setString(3, endereco);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
    
    public List<Promocao> listarTodasPromocoesDeUmTeatro(String st) throws SQLException {
        List<Promocao> ret = new ArrayList<>();

        try (Connection con = this.getConnection()) {
            PreparedStatement ps = con.prepareStatement(LISTAR_PROMOCOES_DE_UM_TEATRO_SQL);
            
            int cnpj = Integer.parseInt(st);
            ps.setInt(1, cnpj);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Promocao promocao = new Promocao();
                Teatro teatro = new Teatro();
                teatro.setEmail(rs.getString("email"));
                teatro.setNome(rs.getString("nomeTeatro"));
                teatro.setCidade(rs.getString("cidade"));
                promocao.setEndereco(rs.getString("endereco_site"));
                promocao.setCnpj(rs.getInt("cnpj_teatro"));
                promocao.setNome(rs.getString("nomePromocao"));
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
                site.setNome(rs.getString("nomeSite"));
                site.setTelefone(rs.getInt("telefone"));
                promocao.setEndereco(rs.getString("endereco_site"));
                promocao.setCnpj(rs.getInt("cnpj_teatro"));                
                promocao.setNome(rs.getString("nomePromocao"));
                promocao.setPreco(rs.getFloat("preco"));
                promocao.setDia(rs.getString("dia"));
                promocao.setHora(rs.getString("hora"));
                ret.add(promocao);
            }
        }
        return ret;
    }
    
    public boolean Verifica(String endereco,int cnpj,String hora, String dia) throws SQLException{
        String sql = "select * from Promocao where ((endereco_site = ? and dia = ?) and hora = ?) or (cnpj_teatro = ? and (hora = ? and dia = ?))";
        try{
        Connection conn = this.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,endereco);
        statement.setString(2,dia);
        statement.setString(3, hora);
        statement.setInt(4,cnpj);
        statement.setString(5,hora);
        statement.setString(6, dia);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return false;
            }
        else{
            return true;
        }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }

}
