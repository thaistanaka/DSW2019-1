package br.ufscar.dc.dsw.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T> {
    //Classe abstrata usada como basse para os outros DAO
    private final EntityManagerFactory emf;
    public GenericDAO() {
        emf = Persistence.createEntityManagerFactory("IngressosPU");
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    abstract List<T> getAll();
    abstract void save(T t);
    abstract void update(T t);     
    abstract void delete(T t);
}
