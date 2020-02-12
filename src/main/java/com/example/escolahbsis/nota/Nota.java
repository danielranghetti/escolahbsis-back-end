package com.example.escolahbsis.nota;

import com.example.escolahbsis.aluno.Aluno;
import com.example.escolahbsis.disciplina.Disciplina;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cod_nota", nullable = true, unique = true)
    private String codNota;
    @Column(name = "nota" , nullable = true)
    private double nota;
    @Column(name = "periodo", nullable = true)
    private String periodo;

    @ManyToOne
    @JoinColumn(name = "aluno" , referencedColumnName = "cod_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "cod_disciplina")
    private Disciplina disciplina;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getCodNota() {
        return codNota;
    }

    public void setCodNota(String codNota) {
        this.codNota = codNota;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", codNota='" + codNota + '\'' +
                ", nota=" + nota +
                ", periodo='" + periodo + '\'' +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                '}';
    }
}
