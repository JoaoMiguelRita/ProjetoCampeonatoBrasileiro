package com.example.projeto01.InfAtleta;

import com.example.projeto01.Time;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Atleta {
    @JsonProperty("atleta_id")
    private int atletaId;
    @JsonProperty("nome_popular")
    private String nome_popular;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("posicao")
    private PosicaoAtleta posicao;


    public int getAtletaId() { return atletaId; }
    public void setAtletaId(int atletaId) { this.atletaId = atletaId;  }

    public String getNome_popular() { return nome_popular; }
    public void setNome_popular(String nome_popular) { this.nome_popular = nome_popular;  }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public PosicaoAtleta getPosicao() { return posicao;  }
    public void setPosicao(PosicaoAtleta posicao) { this.posicao = posicao;  }

    public String formatarMensagemAtleta(Atleta atleta) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("<h2>Detalhes do Atleta</h2>");
        mensagem.append("<ul>");
        mensagem.append("<li><strong>ID Atleta:</strong> ").append(atleta.getAtletaId()).append("</li>");
        mensagem.append("<li><strong>Vulgo:</strong> ").append(atleta.getNome_popular()).append("</li>");
        mensagem.append("<li><strong>Nome:</strong> ").append(atleta.getNome()).append("</li>");
        mensagem.append("<li><strong>Posição:</strong> ").append(atleta.getPosicao().getSigla()).append(" - ").append(atleta.getPosicao().getNomePosicao()).append("</li>");

        mensagem.append("</ul>");
        return mensagem.toString();
    }
}
