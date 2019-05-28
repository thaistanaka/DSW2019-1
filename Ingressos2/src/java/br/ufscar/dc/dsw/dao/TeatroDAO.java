package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Teatro;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class TeatroDAO extends GenericDAO<Teatro> {

    @Override//Guarda um teatro do banco de dados
    public void save(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teatro);
        tx.commit();
        em.close();
    }

    @Override//Lista todos os teatros do banco de dados
    public List<Teatro> getAll() {
        EntityManager em = this.getEntityManager();
        Query q = em.createQuery("select e from Teatro e", Teatro.class);
        List<Teatro> teatros = q.getResultList();
        em.close();
        return teatros;
    }

    @Override//Deleta um teatro do banco de dados
    public void delete(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        teatro = em.getReference(Teatro.class, teatro.getId());
        tx.begin();
        em.remove(teatro);
        tx.commit();
    }

    @Override//Atualiza um teatro do banco de dados com modificações feitas
    public void update(Teatro teatro) {
        EntityManager em = this.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(teatro);
        tx.commit();
        em.close();
    }
    //Retorna uma lista com todos os teatros do banco de dados
    public List<Teatro> listarTodosTeatros() throws SQLException {
        EntityManager em = this.getEntityManager();
        String s = "select a from Teatro a";
        TypedQuery<Teatro> q = em.createQuery(s, Teatro.class);

        return q.getResultList();
    }
    //Retorna uma lista com todos os teatros de uma cidade st 
    public List<Teatro> listarTeatrosPorCidade(String st) throws SQLException {
        EntityManager em = this.getEntityManager();
        try {
            List<Teatro> teatros = (List<Teatro>) em.createQuery("select a from Teatro a where a.cidade = :nome")
                    .setParameter("nome", st).getResultList();
            return teatros;
        } catch (NoResultException e) {
            return null;
        }
    }
    //Retorna uma promoção identificada pelo cnpj
    public Teatro get(Long id) {
        EntityManager em = this.getEntityManager();
        Teatro teatro = em.find(Teatro.class, id);
        em.close();
        return teatro;
    }
    //Verifica se o email e a senha coincidem com algum teatro já cadastrado
    public Teatro getCnpj(String cnpj) {
        EntityManager em = this.getEntityManager();
        try {

            Teatro teatro = (Teatro) em.createQuery("select t from Teatro t where t.cnpj = :nome")
                    .setParameter("nome", cnpj).getSingleResult();
            return teatro;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Teatro getCnpjId(String cnpj, Long id) {
        EntityManager em = this.getEntityManager();
        try {

            Teatro teatro = (Teatro) em.createQuery("select t from Teatro t where t.cnpj = :nome and t.id = :id1")
                    .setParameter("nome", cnpj)
                    .setParameter("id1", id).getSingleResult();
            return teatro;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<Teatro> getCnpjList(String cnpj) {
        EntityManager em = this.getEntityManager();
        try {

            List<Teatro> teatro = (List<Teatro>) em.createQuery("select t from Teatro t where t.cnpj = :nome")
                    .setParameter("nome", cnpj).getResultList();
            return teatro;
        } catch (NoResultException e) {
            return null;
        }
    }

    public Teatro verifica(String email, String senha) {
        EntityManager em = this.getEntityManager();
        try {
            Teatro teatro = (Teatro) em.createQuery("select t from Teatro t where t.email = :nome2 and t.senha = :senha2")
                    .setParameter("nome2", email)
                    .setParameter("senha2", senha).getSingleResult();
            return teatro;
        } catch (NoResultException e) {
            return null;
        }
    }

}
