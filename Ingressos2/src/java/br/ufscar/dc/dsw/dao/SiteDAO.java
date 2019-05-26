/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Site;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Windows
 */
public class SiteDAO extends GenericDAO<Site>{

    @Override
    public List<Site> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Site e", Site.class);
        List<Site> sites = q.getResultList();
        em.close();
        return sites;
    }
    
    @Override
    public void delete(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site = em.getReference(Site.class, site.getEndereco());
        tx.begin();
        em.remove(site);
        tx.commit();
    }

    @Override
    public void update(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site);
        tx.commit();
        em.close();
    }

    
    @Override
    public void save(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site);
        tx.commit();
        em.close();
    }
    
    public Site get(String endereco) {
        EntityManager em = this.getEntityManager();
        Site site = em.find(Site.class, endereco);
        em.close();
        return site;
    }
    
    public boolean verifica(String email, String senha) {
        EntityManager em = this.getEntityManager();
        String s1 = "select s from Site s where s.email = :nome1 and s.senha = :senha1";
        TypedQuery<Site> q1 = em.createQuery(s1, Site.class);
        q1.setParameter("nome1", email);
        q1.setParameter("senha1", senha);
        if (q1.getResultList() == null){
            return true;
        }
        else{
            return false;
        }
        
    }
}
