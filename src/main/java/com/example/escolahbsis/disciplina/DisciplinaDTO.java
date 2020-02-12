package com.example.escolahbsis.disciplina;

public class DisciplinaDTO {

    private long id;
    private String codDisciplina;
    private String nomeDisciplina;
    private String professor;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(long id, String codDisciplina, String nomeDisciplina, String professor) {
        this.id = id;
        this.codDisciplina = codDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.professor = professor;
    }
    public  static DisciplinaDTO of(Disciplina disciplina){
        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getCodDisciplina(),
                disciplina.getNomeDisciplina(),
                disciplina.getProfessor().getCodProfessor()
        );
    }

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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "DisciplinaDTO{" +
                "id=" + id +
                ", codDisciplina='" + codDisciplina + '\'' +
                ", momeDisciplina='" + nomeDisciplina + '\'' +
                ", professor='" + professor + '\'' +
                '}';
    }
}
