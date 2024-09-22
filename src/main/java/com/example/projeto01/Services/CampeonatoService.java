package com.example.projeto01.Services;

import com.example.projeto01.ApiResponse;
import com.example.projeto01.Campeonato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CampeonatoService {

 //   private static final String AUTH_TOKEN = "test_a8c37778328495ac24c5d0d3c3923b";

    public Campeonato getEndereco(Integer cod) throws IOException, InterruptedException {
        Campeonato campeonato = null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Montando a requisição com o cabeçalho de autorização
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.api-futebol.com.br/v1/campeonatos/" + cod + "/tabela"))
                    .header("Authorization", "Bearer live_a8e93c1dbe3173de31684640dbde02") // Certifique-se de que não há espaços extras
                    .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API: " + response.body());

            // Transformando o JSON em Objeto Java
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse apiResponse = mapper.readValue(response.body(), ApiResponse.class);
            //  campeonato = mapper.readValue(response.body(), Campeonato.class);

            if (apiResponse.getMessage() != null) {
                System.out.println("Mensagem de erro da API: " + apiResponse.getMessage());
                return null; // Retorna nulo ou trate conforme necessário
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro - " + e.getMessage());
        }

        return campeonato;
    }
}
