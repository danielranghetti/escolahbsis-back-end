package com.example.escolahbsis.aluno;

import com.example.escolahbsis.alunoTurma.AlunoTurmaDTO;
import com.example.escolahbsis.disciplina.Disciplina;
import com.example.escolahbsis.nota.Nota;
import com.example.escolahbsis.professor.Professor;
import com.example.escolahbsis.turma.Turma;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {

    private long id;
    private String codAluno;
    private String nomeAluno;
    private String sobrenomeAluno;
    private String responsavel;
    private String enderecoAluno;
    private String telefoneAluno;
    private int matricula;
    private List<AlunoTurmaDTO> alunoTurmaDTOS;


    public AlunoDTO() {
    }

    public AlunoDTO(long id, String codAluno, String nomeAluno, String sobrenomeAluno, String responsavel, String enderecoAluno, String telefoneAluno, int matricula, List<AlunoTurmaDTO> alunoTurmaDTOS) {
        this.id = id;
        this.codAluno = codAluno;
        this.nomeAluno = nomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.responsavel = responsavel;
        this.enderecoAluno = enderecoAluno;
        this.telefoneAluno = telefoneAluno;
        this.matricula = matricula;
        this.alunoTurmaDTOS = alunoTurmaDTOS;
    }

    public AlunoDTO(long id, String codAluno, String nomeAluno, String sobrenomeAluno, String responsavel, String enderecoAluno,
                    String telefoneAluno, int matricula, List<AlunoTurmaDTO> alunoTurmaDTOS, Disciplina disciplina, Turma turma, Professor professor, Nota nota) {
        this.id = id;
        this.codAluno = codAluno;
        this.nomeAluno = nomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.responsavel = responsavel;
        this.enderecoAluno = enderecoAluno;
        this.telefoneAluno = telefoneAluno;
        this.matricula = matricula;
        this.alunoTurmaDTOS = alunoTurmaDTOS;

    }

    public static AlunoDTO of(Aluno aluno) {
        List<AlunoTurmaDTO> alunoTurmaDTOList = new ArrayList<>();
        aluno.getAlunoTurmaList().forEach(alunoTurma -> alunoTurmaDTOList.add(AlunoTurmaDTO.of(alunoTurma)));
        return new AlunoDTO(
                aluno.getId(),
                aluno.getCodAluno(),
                aluno.getNomeAluno(),
                aluno.getSobrenomeAluno(),
                aluno.getResponsavel(),
                aluno.getEnderecoAluno(),
                aluno.getTelefoneAluno(),
                aluno.getMatricula(),
                alunoTurmaDTOList
        );


    }


    public List<AlunoTurmaDTO> getAlunoTurmaDTOS() {
        return alunoTurmaDTOS;
    }

    public void setAlunoTurmaDTOS(List<AlunoTurmaDTO> alunoTurmaDTOS) {
        this.alunoTurmaDTOS = alunoTurmaDTOS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(String codAluno) {
        this.codAluno = codAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getSobrenomeAluno() {
        return sobrenomeAluno;
    }

    public void setSobrenomeAluno(String sobrenomeAluno) {
        this.sobrenomeAluno = sobrenomeAluno;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEnderecoAluno() {
        return enderecoAluno;
    }

    public void setEnderecoAluno(String enderecoAluno) {
        this.enderecoAluno = enderecoAluno;
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }

    public void setTelefoneAluno(String telefoneAluno) {
        this.telefoneAluno = telefoneAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "id=" + id +
                ", codAluno='" + codAluno + '\'' +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", sobrenomeAluno='" + sobrenomeAluno + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", enderecoAluno='" + enderecoAluno + '\'' +
                ", telefoneAluno='" + telefoneAluno + '\'' +
                ", matricula=" + matricula +
                ", alunoTurmaDTOS=" + alunoTurmaDTOS +
                '}';
    }
}
