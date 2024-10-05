package com.example.projeto01.Services;

import com.example.projeto01.CampeonatoEspecifico.RespostaFutebola;
import com.example.projeto01.InfAtleta.Atleta;
import com.example.projeto01.ListaCampeonatos.Campeonatos;
import com.example.projeto01.Time;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class CampeonatoService {
    private String url =  "https://api.api-futebol.com.br/v1";
    private String uri;
    private String token = "Bearer live_a8e93c1dbe3173de31684640dbde02"; /* test_fb3734c3c95c4efdb242ebec588798 */

    public List<Campeonatos> getTodosCampeonatos() throws IOException, InterruptedException {
        uri = "/campeonatos";
        List<Campeonatos> campeonatos = null;
        try {
            campeonatos = null;
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + uri))
                    .header("Authorization", token)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API: " + response.body());

            ObjectMapper objectMapper = new ObjectMapper();
            campeonatos = objectMapper.readValue(
                    response.body(),
                    new TypeReference<List<Campeonatos>>() {
                    });

            if (campeonatos.isEmpty()) {
                System.out.println("Campeonatos está vazio.");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro - " + e.getMessage());
        }
        return campeonatos;
    }
     public List<RespostaFutebola> getEndereco(Integer cod) throws IOException, InterruptedException {
         List<RespostaFutebola> tabela = null;
         uri = "/campeonatos/" + cod + "/tabela";
         try {
             HttpClient client = HttpClient.newHttpClient();

             // Montando a requisição
             HttpRequest request = HttpRequest.newBuilder()
                     .uri(URI.create(url + uri))
                     .header("Authorization", token)
                     .build();

             HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
             System.out.println("Resposta da API: " + response.body());

             ObjectMapper objectMapper = new ObjectMapper();
             tabela = objectMapper.readValue(
                     response.body(),
                     new TypeReference<List<RespostaFutebola>>() {}
             );

             if (tabela.isEmpty()) {
                 System.out.println("Tabela vazia.");
                 return null; // Ou retorne conforme necessidade
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Erro - " + e.getMessage());
         }
         return tabela;
     }

    public Time getTime(int timeId) throws IOException, InterruptedException {
        uri = "/times/" + timeId;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + uri))
                .header("Authorization",  token)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), Time.class);
        } else {
            return null;
        }
    }

    public Atleta getAtleta(int atletaId) throws IOException, InterruptedException {
        uri = "/atletas/" + atletaId;
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + uri))
                .header("Authorization",  token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), Atleta.class);
        } else {
            throw new RuntimeException("Erro ao buscar atleta. Código de resposta: " + response.statusCode());
        }
    }
}
