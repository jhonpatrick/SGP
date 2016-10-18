/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpi.sgp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Patrick
 */

//@Entity
//@Table(name="Materia")
public class Materia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long idMateria;
    private String nome;
    private int cargaHoraria;
    private Professor professor;

    public Materia(){}
    
    public Materia(String nome, int cargaHoraria, Professor professor) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}

	public Materia(long idMateria, String nome, int cargaHoraria, Professor professor) {
		super();
		this.idMateria = idMateria;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="idMateria")
	public long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(long idMateria) {
        this.idMateria = idMateria;
    }
    
//	@Column(name="nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//	@Column(name="cargaHoraria")
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

//	@Column(name="professor")
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.idMateria ^ (this.idMateria >>> 32));
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
        final Materia other = (Materia) obj;
        if (this.idMateria != other.idMateria) {
            return false;
        }
        return true;
    }
}
