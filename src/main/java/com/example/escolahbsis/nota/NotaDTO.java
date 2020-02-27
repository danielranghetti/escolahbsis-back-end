package com.example.escolahbsis.nota;



public class NotaDTO {

    private long id;
    private double notaPrimeira;
    private double notaSegunda;
    private String periodo;
    private String aluno;
    private String disciplina;
    private String codNota;
    private double media;

    public NotaDTO() {
    }

    public NotaDTO(long id, double notaPrimeira, double notaSegunda, String periodo, String aluno, String disciplina, String codNota, double media) {
        this.id = id;
        this.notaPrimeira = notaPrimeira;
        this.notaSegunda = notaSegunda;
        this.periodo = periodo;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.codNota = codNota;
        this.media = media;
    }

    public static NotaDTO of(Nota nota){
        return new NotaDTO(
                nota.getId(),
                nota.getNotaPrimeira(),
                nota.getNotaSegunda(),
                nota.getPeriodo(),
                nota.getAluno().getCodAluno(),
                nota.getDisciplina().getCodDisciplina(),
                nota.getCodNota(),
                nota.getMedia()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "NotaDTO{" +
                "id=" + id +
                ", notaPrimeira=" + notaPrimeira +
                ", notaSegunda=" + notaSegunda +
                ", periodo='" + periodo + '\'' +
                ", aluno='" + aluno + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", codNota='" + codNota + '\'' +
                ", media=" + media +
                '}';
    }
}