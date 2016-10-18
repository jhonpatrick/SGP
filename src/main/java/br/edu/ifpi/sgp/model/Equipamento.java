package br.edu.ifpi.sgp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Equipamento
 *
 */
@Entity
@Table(name="Equipamento")
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idEquipamento;
	private String nome;
	private Boolean disponivel;

	public Equipamento() {
	}

	public Equipamento(String nome, Boolean disponivel) {
		super();
		this.nome = nome;
		this.disponivel = disponivel;
	}

	public Equipamento(Integer idEquipamento, String nome, Boolean disponivel) {
		super();
		this.idEquipamento = idEquipamento;
		this.nome = nome;
		this.disponivel = disponivel;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEquipamento")
	public Integer getIdEquipamento() {
		return idEquipamento;
	}
	
	public void setIdEquipamento(Integer idEquipamento) {
		this.idEquipamento = idEquipamento;
	}

	@Column(name="nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="disponivel")
	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
   
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEquipamento == null) ? 0 : idEquipamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		if (idEquipamento == null) {
			if (other.idEquipamento != null)
				return false;
		} else if (!idEquipamento.equals(other.idEquipamento))
			return false;
		return true;
	}
}
