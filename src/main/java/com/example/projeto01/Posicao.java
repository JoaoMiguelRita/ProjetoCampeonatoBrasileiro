package com.example.projeto01;

import java.util.List;

public class Posicao {
    private int posicao;
    private int pontos;
    private Time time;
    private int jogos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golPro;
    private int golsContra;
    private int saldoGols;
    private double aproveitamento;
    private int variacaoPosicao;
    private List<String> ultimosJogos;


    // Getters e Setters outra vez
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

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getGolPro() {
        return golPro;
    }

    public void setGolPro(int golPro) {
        this.golPro = golPro;
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
}
