package com.example.projeto01;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FaseAtual {
    @JsonProperty("fase_id")
    private int faseId;

    private String nome;
    private String slug;
    private String tipo;

    // Getters e Setters
    public int getFaseId() {
        return faseId;
    }

    public void setFaseId(int faseId) {
        this.faseId = faseId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}