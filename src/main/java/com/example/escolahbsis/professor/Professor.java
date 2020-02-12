package com.example.escolahbsis.professor;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "professor")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cod_professor", nullable = true, length = 10)
    private String codProfessor;
    @Column(name = "nome_professor", nullable = true, length = 255)
    private String nomeProfessor;
    @Column(name = "sobrenome_professor", nullable = true, length = 255)
    private String sobrenomeProfessor;
    @Column(name = "endereco_professor", nullable = true, length = 255)
    private String enderecoProfessor;
    @Column(name = "telefone_professor", nullable = true, length = 255)
    private String telefoneProfessor;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(String codProfessor) {
        this.codProfessor = codProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getSobrenomeProfessor() {
        return sobrenomeProfessor;
    }

    public void setSobrenomeProfessor(String sobrenomeProfessor) {
        this.sobrenomeProfessor = sobrenomeProfessor;
    }

    public String getEnderecoProfessor() {
        return enderecoProfessor;
    }

    public void setEnderecoProfessor(String enderecoProfessor) {
        this.enderecoProfessor = enderecoProfessor;
    }

    public String getTelefoneProfessor() {
        return telefoneProfessor;
    }

    public void setTelefoneProfessor(String telefoneProfessor) {
        this.telefoneProfessor = telefoneProfessor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", codProfessor='" + codProfessor + '\'' +
                ", nomeProfessor='" + nomeProfessor + '\'' +
                ", sobrenomeProfessor='" + sobrenomeProfessor + '\'' +
                ", enderecoProfessor='" + enderecoProfessor + '\'' +
                ", telefoneProfessor='" + telefoneProfessor + '\'' +
                '}';
    }
}
