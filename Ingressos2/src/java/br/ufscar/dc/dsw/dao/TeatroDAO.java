package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TeatroDAO extends GenericDAO<Teatro>{

    @Override
    public void save(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }
    
    @Override
    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Teatro e", Teatro.class);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }

    @Override
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getCnpj());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }
    
    @Override
    public void update(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }
        
    public List<Teatro> listarTodosTeatros() throws SQLException {
        EntityManager em = this.getEntityManager();
        String s = "select a from Teatro a";
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);
        
        return q.getResultList();
    }
    
    public List<Teatro> listarTeatrosPorCidade(String st) throws SQLException {
        EntityManager em = this.getEntityManager();
        String s = "select a from Teatro a where a.cidade = :nome";
        
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);
        q.setParameter("nome", st);
        return q.getResultList();
    }

    public Teatro get(Long cnpj) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, cnpj);
        em.close();
        return teatro;
    }

    public boolean verifica(String email, String senha) {
        EntityManager em = this.getEntityManager();
        String s2 = "select t from Teatro t where t.email = :nome2 and t.senha = :senha2";
        TypedQuery<Teatro> q2 = em.createQuery(s2, Teatro.class);
        q2.setParameter("nome2", email);
        q2.setParameter("senha2", senha);
        return q2.getResultList() == null;
        
    }

}
