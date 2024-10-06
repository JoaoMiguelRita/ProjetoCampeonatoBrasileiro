package com.example.projeto01.Services;

import com.example.projeto01.InfAtleta.Atleta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AtletaService {
    private String url =  "https://api.api-futebol.com.br/v1";
    private String uri;
    private String token = "Bearer live_a8e93c1dbe3173de31684640dbde02"; /* test_fb3734c3c95c4efdb242ebec588798 */

    public Atleta getAtleta(int atletaId) throws IOException, InterruptedException {
        uri = "/atletas/" + atletaId;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + uri))
                .header("Authorization",  token)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response.body(), Atleta.class);
        } else {
            return null;
        }
    }
}
