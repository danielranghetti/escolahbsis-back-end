package com.example.escolahbsis.turma;

import com.example.escolahbsis.instituicao.Instituicao;

import javax.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cod_turma", nullable = true, length = 10)
    private String codTurma;
    @Column(name = "periodo_turma", nullable = true)
    private String periodoTurma;

    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "cod_instituicao")
    private Instituicao instituicao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }

    public String getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(String periodoTurma) {
        this.periodoTurma = periodoTurma;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", codTurma='" + codTurma + '\'' +
                ", periodoTurma='" + periodoTurma + '\'' +
                ", instituicao=" + instituicao +
                '}';
    }
}
