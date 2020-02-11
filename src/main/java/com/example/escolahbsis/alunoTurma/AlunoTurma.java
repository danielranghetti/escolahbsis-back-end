package com.example.escolahbsis.alunoTurma;

import com.example.escolahbsis.aluno.Aluno;
import com.example.escolahbsis.turma.Turma;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "aluno_turma")
public class AlunoTurma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "aluno",referencedColumnName = "cod_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "turma", referencedColumnName = "cod_turma")
    private Turma turma;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "AlunoTurma{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", turma=" + turma +
                '}';
    }
}
