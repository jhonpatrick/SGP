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
//@Table(name="DisponibilidadeHorario")
public class DisponibilidadeHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    private long idDisponibilidadeHorario;
    private DiaEHora[] diaLivre;
    private DiaEHora[] diasPreferenciais;

    public DisponibilidadeHorario() {
    }

    public DisponibilidadeHorario(long idDisponibilidadeHorario, DiaEHora[] diaLivre, DiaEHora[] diasPreferenciais) {
        super();
        this.idDisponibilidadeHorario = idDisponibilidadeHorario;
        this.diaLivre = diaLivre;
        this.diasPreferenciais = diasPreferenciais;
    }

    public DisponibilidadeHorario(DiaEHora[] diaLivre, DiaEHora[] diasPreferenciais) {
        super();
        this.diaLivre = diaLivre;
        this.diasPreferenciais = diasPreferenciais;
    }

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="idDisponibilidadeHorario")
    public long getIdDisponibilidadeHorario() {
        return idDisponibilidadeHorario;
    }

    public void setIdDisponibilidadeHorario(long idDisponibilidadeHorario) {
        this.idDisponibilidadeHorario = idDisponibilidadeHorario;
    }

//	@Column(name="diaLivre")
    public DiaEHora[] getDiaLivre() {
        return diaLivre;
    }

    public void setDiaLivre(DiaEHora[] diaLivre) {
        this.diaLivre = diaLivre;
    }

//	@Column(name="diasPreferenciais")
    public DiaEHora[] getDiasPreferenciais() {
        return diasPreferenciais;
    }

    public void setDiasPreferenciais(DiaEHora[] diasPreferenciais) {
        this.diasPreferenciais = diasPreferenciais;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idDisponibilidadeHorario ^ (idDisponibilidadeHorario >>> 32));
        return result;
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
        DisponibilidadeHorario other = (DisponibilidadeHorario) obj;
        if (idDisponibilidadeHorario != other.idDisponibilidadeHorario) {
            return false;
        }
        return true;
    }
}
