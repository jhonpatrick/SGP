package br.edu.ifpi.sgp.model;

import java.util.Objects;

/**
 *
 * @author Agustin
 */
public class Horario {
    private Materia materia;
    private Professor professor;
    private Turma turma;
    private DiaEHora diaHora;

    public Horario() {}

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public DiaEHora getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(DiaEHora diaHora) {
        this.diaHora = diaHora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.diaHora);
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
        final Horario other = (Horario) obj;
        if (this.diaHora != other.diaHora) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "materia=" + materia + ", professor=" + professor + ", turma=" + turma + ", diaHora=" + diaHora + '}';
    }
    
    
    
}