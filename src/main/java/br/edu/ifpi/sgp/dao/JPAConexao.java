/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Visitante
 */
public class JPAConexao {

    static final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("sgp");

    static EntityManager ems = emf.createEntityManager();

    /*
		 * Obtém o EntityManager vinculado à  Thread atual. Se ele ainda não
		 * existir, é criado e depois, vinculado à Thread atual.
     */
    public static EntityManager getEntityManager() {
        if (!ems.isOpen()) {
            ems = emf.createEntityManager();
        }
        return ems;
    }

    /*
		 *  Fecha o EntityManager atrelado à  Thread atual e retira-o da ThreadLocal.
     */
    public static void closeEntityManager() {
        ems.close();
    }

    public static boolean isEntityManagerOpen() {
        return ems.isOpen();
    }
}
