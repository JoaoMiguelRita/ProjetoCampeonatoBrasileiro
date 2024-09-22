package com.example.projeto01;

// Chat mandou fazer para buscar o erro
public class ApiResponse {
    private String message; // Campo para mensagens de erro
    private Object data; // Campo para armazenar dados do campeonato ou qualquer outra resposta

    // Getters e Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
