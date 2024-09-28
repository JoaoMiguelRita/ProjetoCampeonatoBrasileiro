package com.example.projeto01.InfAtleta;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PosicaoAtleta {
    @JsonProperty("nome")
    private String nomePosicao;
    @JsonProperty("sigla")
    private String sigla;

    public String getNomePosicao() {
        return nomePosicao;
    }

    public void setNomePosicao(String nomePosicao) {
        this.nomePosicao = nomePosicao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
