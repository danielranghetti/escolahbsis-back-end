package com.example.escolahbsis.alunoTurma;

public class AlunoTurmaDTO {

    long id;
    String aluno;
    String turma;

    public AlunoTurmaDTO() {
    }

    public AlunoTurmaDTO(long id, String aluno, String turma) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
    }
    public static AlunoTurmaDTO of(AlunoTurma alunoTurma){
        return new AlunoTurmaDTO(
                alunoTurma.getId(),
                alunoTurma.getAluno().getCodAluno(),
                alunoTurma.getTurma().getCodTurma()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "AlunoTurmaDTO{" +
                "id=" + id +
                ", aluno='" + aluno + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }
}
