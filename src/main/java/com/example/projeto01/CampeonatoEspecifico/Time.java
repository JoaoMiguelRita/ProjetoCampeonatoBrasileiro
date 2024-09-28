package com.example.projeto01.CampeonatoEspecifico;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Time {

    @JsonProperty("time_id")
    private int timeId;

    @JsonProperty("nome_popular")
    private String nomePopular;

    @JsonProperty("sigla")
    private String sigla;

    @JsonProperty("escudo")
    private String escudo;

    // Getters e Setters
    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
}
