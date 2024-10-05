package com.example.projeto01;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RodadaAtual {
    @JsonProperty("id")
    private int id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("data")
    private String data;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("rodada")
    private String rodada;
    @JsonProperty("status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
}