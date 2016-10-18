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
//@Table(name="Sala")
public class Sala implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long idSala;
    private int numero;

    public Sala() {
    }

    public Sala(int numero) {
		super();
		this.numero = numero;
	}

	public Sala(long idSala, int numero) {
		super();
		this.idSala = idSala;
		this.numero = numero;
	}

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="idSala")
	public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }
    
//    @Column(name="numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.idSala ^ (this.idSala >>> 32));
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
        final Sala other = (Sala) obj;
        if (this.idSala != other.idSala) {
            return false;
        }
        return true;
    }
}
