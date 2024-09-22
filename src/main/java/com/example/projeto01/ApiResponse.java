package com.example.projeto01;

import java.util.List;

public class ApiResponse {
    private String message;
    private List<Posicao> data;

    // Getters e Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Posicao> getData() {
        return data;
    }

    public void setData(List<Posicao> data) {
        this.data = data;
    }
}
