/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
import br.ufscar.dc.dsw.pojo.Promocao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Windows
 */
public class PromocaoDAO extends GenericDAO<Promocao>{
    
    @Override
    public List<Promocao> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Promocao e", Promocao.class);
        List<Promocao> promocoes = q.getResultList();
        em.close();
        return promocoes;
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
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(promocao);
        tx.commit();
        em.close();
    }

    public Promocao get(String dia, String hora, String endereco) {
        EntityManager em = this.getEntityManager();
        String []vetor  = new String[3];
        vetor [0] = endereco;
        vetor [1] = dia;
        vetor [2] = hora;
        Promocao promocao = em.find(Promocao.class, vetor);
        em.close();
        return promocao;
    }
    
    public List<Promocao> listarTodasPromocoesDeUmTeatro(String st) throws SQLException {
        
        List<Promocao> ret = new ArrayList<>();
        EntityManager em = this.getEntityManager();
        String s = "select a.nome, a.endereco_site, a.preco, a.dia, a.hora, a.cnpj_teatro,"
            + " u.cidade, u.email, u.nome"
            + " from Promocao a inner join Teatro u on a.cnpj_teatro = u.cnpj"
            + " where a.cnpj_teatro = :nome";
        
        TypedQuery<Object[]> q = em.createQuery(s, Object[].class);
        q.setParameter("nome", st);
        List<Object[]> results = q.getResultList();
        
        results.stream().map((result) -> {
            Promocao promocao = new Promocao();
            Teatro teatro = new Teatro();
            promocao.setEndereco(result[1].toString());
            promocao.setCnpj(Integer.parseInt(result[5].toString()));
            promocao.setNome(result[0].toString());
            promocao.setPreco(Float.parseFloat(result[2].toString()));
            promocao.setDia(result[3].toString());
            promocao.setHora(result[4].toString());
            teatro.setEmail(result[7].toString());
            teatro.setNome(result[8].toString());
            teatro.setCidade(result[6].toString());
            return promocao;
        }).forEachOrdered(ret::add);
        
        return ret;
    }
    
    public List<Promocao> listarTodasPromocoesDeUmSite(String endereco) throws SQLException {
        List<Promocao> ret = new ArrayList<>();
        EntityManager em = this.getEntityManager();
        String s = "select"
            + " a.nome, a.endereco_site, a.preco, a.dia, a.hora, a.cnpj_teatro,"
            + " u.email, u.nome, u.telefone"
            + " from Promocao a inner join Site u on a.endereco_site = u.endereco"
            + " where a.endereco_site = ?";
        
        TypedQuery<Object[]> q = em.createQuery(s, Object[].class);
        q.setParameter("nome", endereco);
        List<Object[]> results = q.getResultList();
        
        results.stream().map((result) -> {
            Promocao promocao = new Promocao();
            Site site = new Site();
            promocao.setEndereco(result[1].toString());
            promocao.setCnpj(Integer.parseInt(result[5].toString()));
            promocao.setNome(result[0].toString());
            promocao.setPreco(Float.parseFloat(result[2].toString()));
            promocao.setDia(result[3].toString());
            promocao.setHora(result[4].toString());
            site.setEmail(result[6].toString());
            site.setNome(result[7].toString());
            site.setTelefone(Integer.parseInt(result[8].toString()));
            return promocao;
        }).forEachOrdered(ret::add);
        
        return ret;
        
    }
    
    public boolean Verifica(String endereco,int cnpj,String hora, String dia) throws SQLException{
        EntityManager em = this.getEntityManager();
        String s = "select * from Promocao where ((endereco_site = :nome1 and dia = :nome4) and hora = :nome3) or (cnpj_teatro = :nome2 and (hora = :nome3 and dia = :nome4))";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("nome1", endereco);
        q.setParameter("nome2", cnpj);
        q.setParameter("nome3", hora);
        q.setParameter("nome4", dia);
        return q.getResultList() == null;
    }
    
    @Override
    public void save(Promocao promocao) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(promocao);
        tx.commit();
        em.close();
    }

}
