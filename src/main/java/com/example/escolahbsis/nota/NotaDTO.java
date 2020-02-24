package com.example.escolahbsis.nota;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotBlank;


public class NotaDTO {

    private long id;
    @NotBlank
    private double nota;
    @NotEmpty(message = "periodo deve ser informado")
    private String periodo;
    private String aluno;
    private String disciplina;
    private String codNota;
    private double mediaPrimeira;
    private double mediaSegunda;


    public NotaDTO() {
    }

    public NotaDTO(long id, @NotBlank double nota, @NotEmpty(message = "periodo deve ser informado") String periodo, String aluno, String disciplina, String codNota) {
        this.id = id;
        this.nota = nota;
        this.periodo = periodo;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.codNota = codNota;
    }

    public NotaDTO(long id, @NotBlank double nota, @NotEmpty(message = "periodo deve ser informado") String periodo, String aluno, String disciplina, String codNota, double mediaPrimeira, double mediaSegunda) {
        this.id = id;
        this.nota = nota;
        this.periodo = periodo;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.codNota = codNota;
        this.mediaPrimeira = mediaPrimeira;
        this.mediaSegunda = mediaSegunda;
    }

    public static NotaDTO of(Nota nota) {
        return new NotaDTO(
                nota.getId(),
                nota.getNota(),
                nota.getPeriodo().getDescricao(),
                nota.getAluno().getCodAluno(),
                nota.getDisciplina().getCodDisciplina(),
                nota.getCodNota()
        );
    }

    public double getMediaPrimeira() {
        return mediaPrimeira;
    }

    public double setMediaPrimeira(double mediaPrimeira) {
        this.mediaPrimeira = mediaPrimeira;
        return mediaPrimeira;
    }

    public double getMediaSegunda() {
        return mediaSegunda;
    }

    public void setMediaSegunda(double mediaSegunda) {
        this.mediaSegunda = mediaSegunda;
    }

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

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
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
        return "NotaDTO{" +
                "id=" + id +
                ", nota=" + nota +
                ", periodo='" + periodo + '\'' +
                ", aluno='" + aluno + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", codNota='" + codNota + '\'' +
                ", mediaPrimeira=" + mediaPrimeira +
                ", mediaSegunda=" + mediaSegunda +
                '}';
    }
}
