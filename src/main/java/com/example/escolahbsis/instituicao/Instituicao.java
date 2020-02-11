package com.example.escolahbsis.instituicao;



import javax.persistence.*;

@Entity
@Table(name = "instituicao")
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cod_instituicao", unique = true, nullable = false,length = 10)
    private String codInstituicao;
    @Column(name = "nome_instituicao", nullable = false, length = 255)
    private String nomeInstituicao;
    @Column(name = "telefone_instituicao", nullable = false)
    private String telefoneInstituicao;
    @Column(name = "endereco_instituicao", nullable = false, length = 255)
    private String enderecoInstituicao;



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
        return "Instituicao{" +
                "id=" + id +
                ", codInstituicao='" + codInstituicao + '\'' +
                ", nomeInstituicao='" + nomeInstituicao + '\'' +
                ", telefoneInstituicao='" + telefoneInstituicao + '\'' +
                ", enderecoInstituicao='" + enderecoInstituicao + '\'' +
                '}';
    }
}
