package com.example.escolahbsis.aluno;

import com.example.escolahbsis.alunoTurma.AlunoTurma;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cod_aluno", nullable = true, length = 10)
    private String codAluno;
    @Column(name = "nome_aluno", nullable = true, length = 255)
    private String nomeAluno;
    @Column(name = "sobrenome_aluno", nullable = true, length = 255)
    private String sobrenomeAluno;
    @Column(name = "responsavel", nullable = true, length = 255)
    private String responsavel;
    @Column(name = "endereco_aluno", nullable = true, length = 255)
    private String enderecoAluno;
    @Column(name = "telefone_aluno", nullable = true, length = 255)
    private String telefoneAluno;
    @Column(name = "matricula", nullable = true, length = 255)
    private int matricula;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<AlunoTurma> alunoTurmaList;

    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
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
        return "Aluno{" +
                "id=" + id +
                ", codAluno='" + codAluno + '\'' +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", sobrenomeAluno='" + sobrenomeAluno + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", enderecoAluno='" + enderecoAluno + '\'' +
                ", telefoneAluno='" + telefoneAluno + '\'' +
                ", matricula=" + matricula +
                ", alunoTurmaList=" + alunoTurmaList +
                '}';
    }


}
