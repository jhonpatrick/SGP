/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Agustin
 */
//@Entity
//@Table(name="Professor")
public class Professor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long idProfessor ;
    private String nome;
    private DisponibilidadeHorario disponibilidade;
    private List<Materia> materias;

    public Professor() {}

    public Professor(String nome, List<Materia> materias, DisponibilidadeHorario disponibilidade) {
		this.nome = nome;
		this.disponibilidade = disponibilidade;
		this.materias = materias;
	}

	public Professor(long idProfessor, String nome, DisponibilidadeHorario disponibilidade, List<Materia> materias) {
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.disponibilidade = disponibilidade;
	}

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="idProfessor")
	public long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

//	@Column(name="nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//	@Column(name="disponibilidade")
    public DisponibilidadeHorario getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(DisponibilidadeHorario disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

//	@Column(name="materias")
    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.idProfessor ^ (this.idProfessor >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.idProfessor != other.idProfessor) {
            return false;
        }
        return true;
    }
}
