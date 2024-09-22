package com.example.projeto01.Services;

import com.example.projeto01.RespostaFutebola;
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

    public List<RespostaFutebola.CampeonatoResponse> getEndereco(Integer cod) throws IOException, InterruptedException {
        List<RespostaFutebola.CampeonatoResponse> campeonatos = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Montando a requisição com o cabeçalho de autorização
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.api-futebol.com.br/v1/campeonatos/" + cod + "/tabela"))
                    .header("Authorization", "Bearer test_fb3734c3c95c4efdb242ebec588798") // Certifique-se de que não há espaços extras
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
}
