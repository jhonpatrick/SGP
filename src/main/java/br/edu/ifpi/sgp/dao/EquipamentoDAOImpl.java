package br.edu.ifpi.sgp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifpi.sgp.model.Equipamento;

public class EquipamentoDAOImpl implements EquipamentoDAO {

    EntityManager entityManager;

    @Override
    public void adicionarEquipamento(Equipamento e) {
        // TODO Auto-generated method stub
        try {
            entityManager = JPAUtil.getManager();
            entityManager.getTransaction().begin();
            entityManager.persist(e);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Equipamento> listarEquipamentos() {
        return (List<Equipamento>) entityManager.createQuery("from Equipamento e").getResultList();
    }

    @Override
    public void removerEquipamento(Equipamento e) {
        try {
            entityManager = JPAUtil.getManager();
            entityManager.getTransaction().begin();
            Equipamento aSerApagado = entityManager.find(Equipamento.class, e.getIdEquipamento());
            entityManager.remove(aSerApagado);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtil.close();
        }
    }

}
