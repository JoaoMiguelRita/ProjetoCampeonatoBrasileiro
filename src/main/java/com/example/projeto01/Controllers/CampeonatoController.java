package com.example.projeto01.Controllers;

import com.example.projeto01.ApiResponse;
import com.example.projeto01.RespostaFutebola;
import com.example.projeto01.Services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/futebola")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping("/campeonato")
    public ResponseEntity<List<RespostaFutebola.CampeonatoResponse>> getCampeonato(@RequestParam int id) {
        try {
            System.out.println("Recebendo ID: " + id);
            List<RespostaFutebola.CampeonatoResponse> campeonatos = campeonatoService.getEndereco(id);

            // Verificando se o retorno está vindo nulo ou vazio
            if (campeonatos == null || campeonatos.isEmpty()) {
                System.out.println("Campeonatos retornaram nulos ou vazios");
                return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
            } else {
                System.out.println("Retornando dados do campeonato");
                return ResponseEntity.ok(campeonatos); // Retorna 200 OK com os dados
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro Controller");
            return ResponseEntity.internalServerError().build(); // Retorna 500 em caso de erro
        }
    }
}
