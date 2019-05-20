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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        EntityManager em = this.getEntityManager();
        String s = "select p from Promocao p where p.cnpj = :nome";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("nome", st);
        return q.getResultList();
    }
    
    public List<Promocao> listarTodasPromocoesDeUmSite(String endereco) throws SQLException {
        EntityManager em = this.getEntityManager();
        String s = "select p from Promocao p where p.endereco = :nome";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("nome", endereco);
        return q.getResultList();
    }
    
    public boolean Verifica(String endereco,int cnpj,String hora, String dia) throws SQLException{
        EntityManager em = this.getEntityManager();
        String s = "select * from Promocao where ((endereco_site = :nome1 and dia = :nome4) and hora = :nome3) or (cnpj_teatro = :nome2 and (hora = :nome3 and dia = :nome4))";
        TypedQuery<Promocao> q = em.createQuery(s, Promocao.class);
        q.setParameter("nome1", endereco);
        q.setParameter("nome2", cnpj);
        q.setParameter("nome3", hora);
        q.setParameter("nome4", dia);
        if(q.getResultList() != null){
            return false;
            }
        else{
            return true;
        }
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
