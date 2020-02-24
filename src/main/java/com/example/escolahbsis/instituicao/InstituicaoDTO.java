package com.example.escolahbsis.instituicao;

public class InstituicaoDTO {

    private long id;
    private String codInstituicao;
    private String nomeInstituicao;
    private String telefoneInstituicao;
    private String enderecoInstituicao;

    public InstituicaoDTO() {
    }

    public InstituicaoDTO(long id, String codInstituicao, String nomeInstituicao, String telefoneInstituicao, String enderecoInstituicao) {
        this.id = id;
        this.codInstituicao = codInstituicao;
        this.nomeInstituicao = nomeInstituicao;
        this.telefoneInstituicao = telefoneInstituicao;
        this.enderecoInstituicao = enderecoInstituicao;
    }

    public static InstituicaoDTO of(Instituicao instituicao) {
        return new InstituicaoDTO(
                instituicao.getId(),
                instituicao.getCodInstituicao(),
                instituicao.getNomeInstituicao(),
                instituicao.getTelefoneInstituicao(),
                instituicao.getEnderecoInstituicao()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodInstituicao() {
        return codInstituicao;
    }

    public void setCodInstituicao(String codInstituicao) {
        this.codInstituicao = codInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getTelefoneInstituicao() {
        return telefoneInstituicao;
    }

    public void setTelefoneInstituicao(String telefoneInstituicao) {
        this.telefoneInstituicao = telefoneInstituicao;
    }

    public String getEnderecoInstituicao() {
        return enderecoInstituicao;
    }

    public void setEnderecoInstituicao(String enderecoInstituicao) {
        this.enderecoInstituicao = enderecoInstituicao;
    }

    @Override
    public String toString() {
        return "InstituicaoDTO{" +
                "id=" + id +
                ", codInstituicao='" + codInstituicao + '\'' +
                ", nomeInstituicao='" + nomeInstituicao + '\'' +
                ", telefoneInstituicao=" + telefoneInstituicao +
                ", enderecoInstituicao='" + enderecoInstituicao + '\'' +
                '}';
    }
}
