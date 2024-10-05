package com.example.projeto01.CampeonatoEspecifico;

import com.example.projeto01.EdicaoAtual;
import com.example.projeto01.FaseAtual;
import com.example.projeto01.InfAtleta.PosicaoAtleta;
import com.example.projeto01.Time;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespostaFutebola {
        private int posicao;
        private int pontos;
        private Time time; // Adicione a propriedade 'Time'
        private int jogos;
        private int vitorias;
        private int empates;
        private int derrotas;
        @JsonProperty("gols_pro")
        private int golsPro;
        @JsonProperty("gols_contra")
        private int golsContra;
        @JsonProperty("saldo_gols")
        private int saldoGols;
        private double aproveitamento;
        @JsonProperty("variacao_posicao")
        private int variacaoPosicao;
        @JsonProperty("ultimos_jogos")
        private List<String> ultimosJogos;

        // Getters e Setters para todos os campos
        public int getPosicao() {
            return posicao;
        }

        public void setPosicao(int posicao) {
            this.posicao = posicao;
        }

        public int getPontos() {
            return pontos;
        }

        public void setPontos(int pontos) {
            this.pontos = pontos;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public int getEmpates() {
            return empates;
        }

        public void setEmpates(int empates) {
            this.empates = empates;
        }

        public int getVitorias() {
            return vitorias;
        }

        public void setVitorias(int vitorias) {
            this.vitorias = vitorias;
        }

        public int getJogos() {
            return jogos;
        }

        public void setJogos(int jogos) {
            this.jogos = jogos;
        }

        public int getDerrotas() {
            return derrotas;
        }

        public void setDerrotas(int derrotas) {
            this.derrotas = derrotas;
        }

        public int getGolsPro() {
            return golsPro;
        }

        public void setGolsPro(int golsPro) {
            this.golsPro = golsPro;
        }

        public int getGolsContra() {
            return golsContra;
        }

        public void setGolsContra(int golsContra) {
            this.golsContra = golsContra;
        }

        public int getSaldoGols() {
            return saldoGols;
        }

        public void setSaldoGols(int saldoGols) {
            this.saldoGols = saldoGols;
        }

        public double getAproveitamento() {
            return aproveitamento;
        }

        public void setAproveitamento(double aproveitamento) {
            this.aproveitamento = aproveitamento;
        }

        public int getVariacaoPosicao() {
            return variacaoPosicao;
        }

        public void setVariacaoPosicao(int variacaoPosicao) {
            this.variacaoPosicao = variacaoPosicao;
        }

        public List<String> getUltimosJogos() {
            return ultimosJogos;
        }

        public void setUltimosJogos(List<String> ultimosJogos) {
            this.ultimosJogos = ultimosJogos;
        }


        public static class CampeonatoResponse {
            @JsonProperty("campeonato_id")
            private int campeonatoId;

            private String nome;

            private String slug;

            @JsonProperty("nome_popular")
            private String nomePopular;

            @JsonProperty("edicao_atual")
            private EdicaoAtual edicaoAtual;

            @JsonProperty("fase_atual")
            private FaseAtual faseAtual;

            private String status;
            private String tipo;
            private String logo;
            private String regiao;

            // Getters e Setters
            public int getCampeonatoId() {
                return campeonatoId;
            }

            public void setCampeonatoId(int campeonatoId) {
                this.campeonatoId = campeonatoId;
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

            public String getNomePopular() {
                return nomePopular;
            }

            public void setNomePopular(String nomePopular) {
                this.nomePopular = nomePopular;
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
        }

    public String formatarMensagemCampeonatoEspecifico() {
        StringBuilder mensagem = new StringBuilder();
            mensagem.append("<div style='border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;'>");
            mensagem.append("<h3>").append(time.getNomePopular()).append(" (").append(time.getSigla()).append(")</h3>");
            mensagem.append("<p><strong>ID do Time:</strong> ").append(time.getTimeId()).append("</p>");
            mensagem.append("<ul>");
            mensagem.append("<li><strong>Jogos:</strong> ").append(jogos).append("</li>");
            mensagem.append("<li><strong>Vitórias:</strong> ").append(vitorias).append("</li>");
            mensagem.append("<li><strong>Empates:</strong> ").append(empates).append("</li>");
            mensagem.append("<li><strong>Derrotas:</strong> ").append(derrotas).append("</li>");
            mensagem.append("<li><strong>Aproveitamento:</strong> ").append(String.format("%.2f%%", aproveitamento)).append("</li>");
            mensagem.append("<li><strong>Gols a favor:</strong> ").append(golsPro).append("</li>");
            mensagem.append("<li><strong>Gols contra:</strong> ").append(golsContra).append("</li>");
            mensagem.append("<li><strong>Saldo de gols:</strong> ").append(saldoGols).append("</li>");
            mensagem.append("<li><strong>Variação de posição:</strong> ").append(variacaoPosicao).append("</li>");
            mensagem.append("<li><strong>Últimos jogos:</strong> ").append(String.join(", ", ultimosJogos)).append("</li>");
            mensagem.append("</ul>");
            mensagem.append("</div>");
            return mensagem.toString();
    }
}
