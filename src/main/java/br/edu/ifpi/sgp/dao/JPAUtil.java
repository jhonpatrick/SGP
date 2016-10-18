package br.edu.ifpi.sgp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    public static EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("sgp");

    public static EntityManager getManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        getManager().close();
        emf.close();
    }
}
