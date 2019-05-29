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
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Windows
 */
public class SiteDAO extends GenericDAO<Site>{

    @Override//Retorna todos os sites do banco de dados
    public List<Site> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Site e", Site.class);
        List<Site> sites = q.getResultList();
        em.close();
        return sites;
    }
    
    @Override//Deleta um site do banco de dados
    public void delete(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        site = em.getReference(Site.class, site.getId());
        tx.begin();
        em.remove(site);
        tx.commit();
    }

    @Override//Atualiza um site do banco de dados com modificações feitas
    public void update(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(site);
        tx.commit();
        em.close();
    }

    
    @Override//Guarda no banco de dados um site
    public void save(Site site) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(site);
        tx.commit();
        em.close();
    }
    //Retorna uma promoção identificada pelo id
    public Site get(Long id) {
        EntityManager em = this.getEntityManager();
        Site site = em.find(Site.class, id);
        em.close();
        return site;
    }
    //Retorna uma promoção identificada pelo endereco
    public Site getEndereco(String endereco) {
        try{
        EntityManager em = this.getEntityManager();
        Site site = (Site) em.createQuery("select t from Site t where t.endereco = :nome")
                   .setParameter("nome", endereco).getSingleResult();
        return site;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Site> getEnderecoList(String endereco) {
        try{
        EntityManager em = this.getEntityManager();
        List<Site> site = (List<Site>) em.createQuery("select t from Site t where t.endereco = :nome")
                   .setParameter("nome", endereco).getResultList();
        return site;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Site getEnderecoId(String endereco, Long id) {
        try{
        EntityManager em = this.getEntityManager();
        Site site = (Site) em.createQuery("select t from Site t where t.endereco = :nome and t.id = :id1")
                   .setParameter("nome", endereco)
                .setParameter("id1", id).getSingleResult();
        return site;
        } catch (NoResultException e) {
            return null;
        }
    }
    //Verifica se o email e a senha coincidem com algum site já cadastrado
    public Site verifica(String email, String senha) {
        EntityManager em = this.getEntityManager();
        try {
           Site site = (Site) em.createQuery("select t from Site t where t.email = :nome2 and t.senha = :senha2")
                   .setParameter("nome2", email)
                   .setParameter("senha2", senha).getSingleResult();
           return site;
        } catch (NoResultException e) {
            return null;
        }
    }
}
