package com.example.projeto01;

import java.util.List;

public class RespostaFutebola {
    public static  class Time {
        private int time_id;
        private String nome_popular;
        private String sigla;
        private String escudo;

        // Getters e setters
        public int getTime_id() { return time_id; }
        public void setTime_id(int time_id) { this.time_id = time_id; }

        public String getNome_popular() { return nome_popular; }
        public void setNome_popular(String nome_popular) { this.nome_popular = nome_popular; }

        public String getSigla() { return sigla; }
        public void setSigla(String sigla) { this.sigla = sigla; }

        public String getEscudo() { return escudo; }
        public void setEscudo(String escudo) { this.escudo = escudo; }
    }

    public static  class CampeonatoResponse {
        private int posicao;
        private int pontos;
        private Time time;
        private int jogos;
        private int vitorias;
        private int empates;
        private int derrotas;
        private int gols_pro;
        private int gols_contra;
        private int saldo_gols;
        private double aproveitamento;
        private int variacao_posicao;
        private List<String> ultimos_jogos;

        // Getters e setters
        public int getPosicao() { return posicao; }
        public void setPosicao(int posicao) { this.posicao = posicao; }

        public int getPontos() { return pontos; }
        public void setPontos(int pontos) { this.pontos = pontos; }

        public Time getTime() { return time; }
        public void setTime(Time time) { this.time = time; }

        public int getJogos() {return jogos;}
        public void setJogos(int jogos) { this.jogos = jogos;}

        public int getVitorias() {return vitorias;}
        public void setVitorias(int vitorias) {this.vitorias = vitorias;}

        public int getEmpates() {return empates;}
        public void setEmpates(int empates) {this.empates = empates;}

        public int getDerrotas() {return derrotas;}
        public void setDerrotas(int derrotas) {this.derrotas = derrotas;}

        public int getGols_pro() {return gols_pro;}
        public void setGols_pro(int gols_pro) {this.gols_pro = gols_pro;}

        public int getGols_contra() {return gols_contra;}
        public void setGols_contra(int gols_contra) {this.gols_contra = gols_contra;}

        public int getSaldo_gols() {return saldo_gols;}
        public void setSaldo_gols(int saldo_gols) {this.saldo_gols = saldo_gols;}

        public double getAproveitamento() {return aproveitamento;}
        public void setAproveitamento(double aproveitamento) {this.aproveitamento = aproveitamento;}

        public int getVariacao_posicao() {return variacao_posicao;}
        public void setVariacao_posicao(int variacao_posicao) {this.variacao_posicao = variacao_posicao;}

        public List<String> getUltimos_jogos() {return ultimos_jogos;}
        public void setUltimos_jogos(List<String> ultimos_jogos) {this.ultimos_jogos = ultimos_jogos;}
    }

}
