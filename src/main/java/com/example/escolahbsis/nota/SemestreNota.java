package com.example.escolahbsis.nota;

public enum SemestreNota {

    S1("1º Semestre"),
    S2("2º Semestre");


    private final String descricao;

    SemestreNota(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
