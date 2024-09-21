package com.example.projeto01.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CampeonatoService {

    private final String apiUrl = "https://api.api-futebol.com.br/v1/campeonatos/";

    public String getCampeonatoById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl + id, String.class);

        try {
            return response;
        } catch (HttpClientErrorException e) {
            return "Erro ao acessar a API: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
        }
    }
}
