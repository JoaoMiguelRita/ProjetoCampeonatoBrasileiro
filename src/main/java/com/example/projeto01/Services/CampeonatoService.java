package com.example.projeto01.Services;

import com.example.projeto01.CampeonatoEspecifico.RespostaFutebola;
import com.example.projeto01.CampeonatoEspecifico.Time;
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

    public List<RespostaFutebola.CampeonatoResponse> getTodosCampeonatos() throws IOException, InterruptedException {
        List<RespostaFutebola.CampeonatoResponse> campeonatos = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Montando a requisição com o cabeçalho de autorização
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.api-futebol.com.br/v1/campeonatos/"))
                    .header("Authorization", "Bearer test_fb3734c3c95c4efdb242ebec588798")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API: " + response.body());

            // Criando o ObjectMapper para deserializar a resposta JSON
            ObjectMapper objectMapper = new ObjectMapper();
            campeonatos = objectMapper.readValue(
                    response.body(),
                    new TypeReference<List<RespostaFutebola.CampeonatoResponse>>() {}
            );

            if (campeonatos.isEmpty()) {
                System.out.println("Resposta vazia da API.");
                return null; // Retorna nulo ou trate conforme necessário
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro - " + e.getMessage());
        }

        return campeonatos;
    }
    public List<RespostaFutebola> getEndereco(Integer cod) throws IOException, InterruptedException {
        List<RespostaFutebola> tabela = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Montando a requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.api-futebol.com.br/v1/campeonatos/" + cod + "/tabela"))
                    .header("Authorization", "Bearer test_fb3734c3c95c4efdb242ebec588798")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API: " + response.body());

            // Deserializando diretamente para a classe RespostaFutebola
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

    /*
    public List<RespostaFutebola.CampeonatoResponse> getEndereco(Integer cod) throws IOException, InterruptedException {
        List<RespostaFutebola.CampeonatoResponse> campeonatos = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Montando a requisição com o cabeçalho de autorização
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.api-futebol.com.br/v1/campeonatos/" + cod + "/tabela"))
                    .header("Authorization", "Bearer test_fb3734c3c95c4efdb242ebec588798")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API: " + response.body());

            // Criando o ObjectMapper para deserializar a resposta JSON
            ObjectMapper objectMapper = new ObjectMapper();
            campeonatos = objectMapper.readValue(
                    response.body(),
                    new TypeReference<List<RespostaFutebola.CampeonatoResponse>>() {}
            );

            if (campeonatos.isEmpty()) {
                System.out.println("Resposta vazia da API.");
                return null; // Retorna nulo ou trate conforme necessário
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro - " + e.getMessage());
        }

        return campeonatos;
    }
*/
    public Time getTime(int timeId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.api-futebol.com.br/v1/times/" + timeId))
                .header("Authorization", "Bearer test_fb3734c3c95c4efdb242ebec588798")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), Time.class);
        } else {
            return null;
        }
    }
}
