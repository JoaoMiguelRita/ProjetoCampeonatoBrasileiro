package com.example.projeto01;

public class Campeonato {
    private int id;
    private String nome;
    private String temporada;

    // -------------------------------------------- //
    // Getters
    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getTemporada() {
        return temporada;
    }
    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    // -------------------------------------------- //
}
