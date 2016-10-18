package br.edu.ifpi.sgp.dao;

import java.util.List;

import br.edu.ifpi.sgp.model.Equipamento;

public interface EquipamentoDAO {
	
	public void adicionarEquipamento(Equipamento e);
    
	public List<Equipamento> listarEquipamentos();
	
	public void removerEquipamento(Equipamento e);
	
}
