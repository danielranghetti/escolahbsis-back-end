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
    @Column(name = "nota_primeira", nullable = true)
    private double notaPrimeira;
    @Column(name = "nota_segunda", nullable = true)
    private double notaSegunda;
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "media")
    private double media;


    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "cod_aluno")
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

    public String getCodNota() {
        return codNota;
    }

    public void setCodNota(String codNota) {
        this.codNota = codNota;
    }

    public double getNotaPrimeira() {
        return notaPrimeira;
    }

    public void setNotaPrimeira(double notaPrimeira) {
        this.notaPrimeira = notaPrimeira;
    }

    public double getNotaSegunda() {
        return notaSegunda;
    }

    public void setNotaSegunda(double notaSegunda) {
        this.notaSegunda = notaSegunda;
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", codNota='" + codNota + '\'' +
                ", notaPrimeira=" + notaPrimeira +
                ", notaSegunda=" + notaSegunda +
                ", periodo='" + periodo + '\'' +
                ", media='" + media + '\'' +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                '}';
    }
}