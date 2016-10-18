package br.edu.ifpi.sgp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifpi.sgp.model.Equipamento;

public class EquipamentoDAOImpl implements EquipamentoDAO {

	EntityManager entityManager;
	
	@Override
	public void adicionarEquipamento(Equipamento e) {
		// TODO Auto-generated method stub
		try{
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			if (JPAConexao.isEntityManagerOpen())
				JPAConexao.closeEntityManager();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipamento> listarEquipamentos() {
		return (List<Equipamento>)entityManager.createQuery("from Equipamento e").getResultList();
	}
	
	public void removerEquipamento(Equipamento e){
		try{
			entityManager = JPAConexao.getEntityManager();
			entityManager.getTransaction().begin();
			Equipamento aSerApagado = entityManager.find(Equipamento.class,e.getIdEquipamento());
			entityManager.remove(aSerApagado);
			entityManager.getTransaction().commit();
		} catch(Exception ex){
			entityManager.getTransaction().rollback();
		}finally {
			if (JPAConexao.isEntityManagerOpen())
				JPAConexao.closeEntityManager();
		}
	}

}
