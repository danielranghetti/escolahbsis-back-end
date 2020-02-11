package com.example.escolahbsis.turma;

import org.springframework.beans.factory.annotation.Autowired;

public class TurmaDTO {

    private long id;
    private String codTurma;
    private String periodoTurma;
    private String instituicao;

    public TurmaDTO() {
    }

    @Autowired
    public TurmaDTO(long id, String codTurma, String periodoTurma, String instituicao) {
        this.id = id;
        this.codTurma = codTurma;
        this.periodoTurma = periodoTurma;
        this.instituicao = instituicao;
    }

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

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public TurmaDTO of(Turma turma){
        return new TurmaDTO(
                turma.getId(),
                turma.getCodTurma(),
                turma.getPeriodoTurma(),
                turma.getInstituicao().getCodInstituicao()
        );

    }

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", codTurma='" + codTurma + '\'' +
                ", periodoTurma='" + periodoTurma + '\'' +
                ", instituicao='" + instituicao + '\'' +
                '}';
    }
}
