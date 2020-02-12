package com.example.escolahbsis.nota;

public class NotaDTO {

    private long id;
    private double nota;
    private String periodo;
    private String aluno;
    private String disciplina;
    private String codNota;


    public NotaDTO() {
    }

    public NotaDTO(long id, double nota, String periodo, String aluno, String disciplina, String codNota) {
        this.id = id;
        this.nota = nota;
        this.periodo = periodo;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.codNota = codNota;
    }
    public static  NotaDTO of(Nota nota){
        return new NotaDTO(
                nota.getId(),
                nota.getNota(),
                nota.getPeriodo(),
                nota.getAluno().getCodAluno(),
                nota.getDisciplina().getCodDisciplina(),
                nota.getCodNota()
        );
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
                '}';
    }
}
