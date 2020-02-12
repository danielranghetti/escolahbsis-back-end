package com.example.escolahbsis.professor;

public class ProfessorDTO {

    private long id;
    private String codProfessor;
    private String nomeProfessor;
    private String sobrenomeProfessor;
    private String enderecoProfessor;
    private String telefoneProfessor;

    public ProfessorDTO() {
    }

    public ProfessorDTO(long id, String codProfessor, String nomeProfessor, String sobrenomeProfessor, String enderecoProfessor, String telefoneProfessor) {
        this.id = id;
        this.codProfessor = codProfessor;
        this.nomeProfessor = nomeProfessor;
        this.sobrenomeProfessor = sobrenomeProfessor;
        this.enderecoProfessor = enderecoProfessor;
        this.telefoneProfessor = telefoneProfessor;
    }
    public static ProfessorDTO of(Professor professor){
        return new ProfessorDTO(
                professor.getId(),
                professor.getCodProfessor(),
                professor.getNomeProfessor(),
                professor.getSobrenomeProfessor(),
                professor.getEnderecoProfessor(),
                professor.getTelefoneProfessor()
        );
    }

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
        return "ProfessorDTO{" +
                "id=" + id +
                ", codProfessor='" + codProfessor + '\'' +
                ", nomeProfessor='" + nomeProfessor + '\'' +
                ", sobrenomeProfessor='" + sobrenomeProfessor + '\'' +
                ", enderecoProfessor='" + enderecoProfessor + '\'' +
                ", telefoneProfessor='" + telefoneProfessor + '\'' +
                '}';
    }
}
