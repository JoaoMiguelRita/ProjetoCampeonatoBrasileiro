package com.example.projeto01;

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

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("apelido")
    private String apelido;

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

    public String getNome() { return nome;  }

    public void setNome(String nome) { this.nome = nome;    }

    public String getApelido() { return apelido;    }

    public void setApelido(String apelido) { this.apelido = apelido;    }

    public String formatarMensagemTime(Time time) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("<h2>Detalhes do Time</h2>");
        mensagem.append("<ul>");
        mensagem.append("<li><strong>ID:</strong> ").append(time.getTimeId()).append("</li>");
        mensagem.append("<li><strong>Nome Popular:</strong> ").append(time.getNome()).append("</li>");
        mensagem.append("<li><strong>Sigla:</strong> ").append(time.getSigla()).append("</li>");
        mensagem.append("<li><strong>Nome:</strong> ").append(time.getNome()).append("</li>");
        mensagem.append("<li><strong>Escudo:</strong> <img width='30px' src='").append(time.getEscudo()).append("' alt='Escudo de ").append(time.getNome()).append("' /></li>");
        if (timeId == 6) {
            mensagem.append("<li><strong>Apelido:</strong> Freguês do Criciúma E.C. ")
                    .append("<img width='100px' src='http://localhost:8080/imagens/criciuma.png' ") // Corrigido aqui
                    .append("alt='Escudo dO MAIOR DO ESTADO PORRAAA' /></li>"); // Fechando a tag corretamente
        } else {
            mensagem.append("<li><strong>Apelido:</strong> ")
                    .append(time.getApelido().isEmpty() ? "N/A" : time.getApelido())
                    .append("</li>");
        }
        mensagem.append("</ul>");
        return mensagem.toString();
    }

}
