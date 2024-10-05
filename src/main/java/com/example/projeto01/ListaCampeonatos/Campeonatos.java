package com.example.projeto01.ListaCampeonatos;

import com.example.projeto01.CampeonatoEspecifico.RespostaFutebola;
import com.example.projeto01.EdicaoAtual;
import com.example.projeto01.FaseAtual;
import com.example.projeto01.RodadaAtual;
import com.example.projeto01.Time;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Campeonatos {
    @JsonProperty("campeonato_id")
    private int campeonato_id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("nome_popular")
    private String nome_popular;
    @JsonProperty("edicao_atual")
    private EdicaoAtual edicaoAtual;
    @JsonProperty("fase_atual")
    private FaseAtual faseAtual;
    @JsonProperty("rodada_atual")
    private RodadaAtual rodadaAtual;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("regiao")
    private String regiao;
    @JsonProperty("_link")
    private String _link;

    public int getCampeonato_id() {
        return campeonato_id;
    }

    public void setCampeonato_id(int campeonato_id) {
        this.campeonato_id = campeonato_id;
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

    public String getNome_popular() {
        return nome_popular;
    }

    public void setNome_popular(String nome_popular) {
        this.nome_popular = nome_popular;
    }

    public EdicaoAtual getEdicaoAtual() {
        return edicaoAtual;
    }

    public void setEdicaoAtual(EdicaoAtual edicaoAtual) {
        this.edicaoAtual = edicaoAtual;
    }

    public FaseAtual getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(FaseAtual faseAtual) {
        this.faseAtual = faseAtual;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String get_link() {
        return _link;
    }

    public void set_link(String _link) {
        this._link = _link;
    }

    public RodadaAtual getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(RodadaAtual rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }

    public String formatarMensagemCampeonato(Campeonatos campeonato) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("<h2>Detalhes do Campeonato</h2>");

        // Destacando o campeonato com ID 10
        if (campeonato.getCampeonato_id() == 10) {
            mensagem.append("<div style='border: 2px solid #007bff; border-radius: 5px; padding: 20px; margin-bottom: 20px; ");
            mensagem.append("background-color: #e7f1ff;'>");
            mensagem.append("<h3 style='color: #0056b3; font-weight: bold;'>").append(campeonato.getNome()).append("</h3>");
        } else {
            mensagem.append("<div style='border: 2px solid #c2171d; border-radius: 5px; padding: 20px; margin-bottom: 20px; ");
            mensagem.append("background-color: #f8f9fa;'>");
            mensagem.append("<h3>").append(campeonato.getNome()).append("</h3>");

        }

        // Logo do campeonato
        mensagem.append("<img src='").append(campeonato.getLogo()).append("' alt='Logo de ").append(campeonato.getNome()).append("' width='100px' style='display:block; margin-bottom: 15px; border-radius: 5px;'/>");

        // Lista de detalhes do campeonato
        mensagem.append("<ul style='list-style-type: none; padding: 0; font-size: 16px;'>");
        mensagem.append("<li><strong>ID do Campeonato:</strong> ").append(campeonato.getCampeonato_id()).append("</li>");
        mensagem.append("<li><strong>Nome Popular:</strong> ").append(campeonato.getNome_popular()).append("</li>");
        mensagem.append("<li><strong>Tipo:</strong> ").append(campeonato.getTipo()).append("</li>");
        mensagem.append("<li><strong>Status:</strong> ").append(campeonato.getStatus()).append("</li>");
        mensagem.append("<li><strong>Fase Atual:</strong> ").append(campeonato.getFaseAtual().getNome()).append("</li>");
        mensagem.append("<li><strong>Edição Atual:</strong> ").append(campeonato.getEdicaoAtual().getNome()).append(" (").append(campeonato.getEdicaoAtual().getTemporada()).append(")</li>");

        // Adicionando detalhes da rodada atual, se disponível
        if (campeonato.getRodadaAtual() != null) {
            mensagem.append("<li><strong>Rodada Atual:</strong> ").append(campeonato.getRodadaAtual().getNome()).append("</li>");
        } else {
            mensagem.append("<li><strong>Rodada Atual:</strong> Não disponível</li>");
        }

        mensagem.append("</ul>");
        mensagem.append("</div>");
        return mensagem.toString();
    }




}
