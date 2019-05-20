package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Site;
import br.ufscar.dc.dsw.pojo.Teatro;
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

public class TeatroDAO extends GenericDAO<Teatro>{

    private final static String LISTAR_TEATROS_SQL = "select"
            + " a.cnpj, a.email, a.nome, a.cidade from Teatro a";

    private final static String LISTAR_TEATROS_POR_CIDADES_SQL = "select"
            + " a.cidade, a.cnpj, a.email, a.nome"
            + " from Teatro a"
            + " where a.cidade = ?";

    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Promocao e", Teatro.class);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }

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
    
    @Override
    public void save(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }
    
    public Teatro getN(String email, String senha) {
        EntityManager em = this.getEntityManager();
        String []vetor  = new String[2];
        vetor [0] = email;
        vetor [1] = senha;
        Teatro teatro = em.find(Teatro.class, vetor);
        em.close();
        return teatro;
    }
        
    public List<Teatro> listarTodosTeatros() throws SQLException {
        EntityManager em = this.getEntityManager();
        String s = "select p from Teatro p";
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);
        return q.getResultList();
    }

    public Teatro get(int cnpj) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, cnpj);
        em.close();
        return teatro;
    }

    public boolean Verifica(String email, String senha) {
        EntityManager em = this.getEntityManager();
        String s1 = "select * from Site where email = :nomeS1 or senha = :nomeS2";
        String s2 = "select * from Teatro where email = :nomeT1 or senha = :nomeT2";
        TypedQuery<Site> q1 = em.createQuery(s1, Site.class);
        q1.setParameter("nomeS1", email);
        q1.setParameter("nomeS2", senha);
        TypedQuery<Teatro> q2 = em.createQuery(s1, Teatro.class);
        q2.setParameter("nomeT1", email);
        q2.setParameter("nomeT2", senha);
        return !((q1.getResultList() != null) || (q2.getResultList() != null));
    }
}
