package com.example.projeto01;

import com.example.projeto01.CampeonatoEspecifico.RespostaFutebola;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EdicaoAtual {
    private int edicao_id;
    private String temporada;
    private String nome;
    private String nome_popular;
    private String slug;


    public void setEdicao_id(int edicao_id) {
        this.edicao_id = edicao_id;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_popular() {
        return nome_popular;
    }

    public void setNome_popular(String nome_popular) {
        this.nome_popular = nome_popular;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}