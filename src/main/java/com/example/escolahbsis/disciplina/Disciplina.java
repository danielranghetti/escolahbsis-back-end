package com.example.escolahbsis.disciplina;

import com.example.escolahbsis.professor.Professor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cod_disciplina", unique = true, length = 10)
    private String codDisciplina;
    @Column(name = "nome_disciplina", nullable = true, length = 50)
    private String nomeDisciplina;

    @ManyToOne
    @JoinColumn(name = "professor", referencedColumnName = "cod_professor")
    private Professor professor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", codDisciplina='" + codDisciplina + '\'' +
                ", momeDisciplina='" + nomeDisciplina + '\'' +
                ", professor=" + professor +
                '}';
    }
}
