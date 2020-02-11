package com.example.escolahbsis.aluno;

public class AlunoDTO {

    private long id;
    private String codAluno;
    private String nomeAluno;
    private String sobrenomeAluno;
    private String responsavel;
    private String enderecoAluno;
    private String telefoneAluno;
    private int matricula;

    public AlunoDTO() {
    }

    public AlunoDTO(long id, String codAluno, String nomeAluno, String sobrenomeAluno, String responsavel, String enderecoAluno, String telefoneAluno, int matricula) {
        this.id = id;
        this.codAluno = codAluno;
        this.nomeAluno = nomeAluno;
        this.sobrenomeAluno = sobrenomeAluno;
        this.responsavel = responsavel;
        this.enderecoAluno = enderecoAluno;
        this.telefoneAluno = telefoneAluno;
        this.matricula = matricula;
    }

    public static AlunoDTO of(Aluno aluno){
        return new AlunoDTO(
                aluno.getId(),
                aluno.getCodAluno(),
                aluno.getNomeAluno(),
                aluno.getSobrenomeAluno(),
                aluno.getResponsavel(),
                aluno.getEnderecoAluno(),
                aluno.getTelefoneAluno(),
                aluno.getMatricula()
        );


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
                '}';
    }
}
