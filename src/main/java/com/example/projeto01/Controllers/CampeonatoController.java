package com.example.projeto01.Controllers;

import com.example.projeto01.RespostaFutebola;
import com.example.projeto01.Services.CampeonatoService;
import com.example.projeto01.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/futebola")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping("/campeonatos")
    public ResponseEntity<List<RespostaFutebola.CampeonatoResponse>> getTodosCampeonatos() {
        try {
            List<RespostaFutebola.CampeonatoResponse> campeonatos = campeonatoService.getTodosCampeonatos();

            if (campeonatos == null || campeonatos.isEmpty()) {
                System.out.println("Nenhum campeonato encontrado");
                return ResponseEntity.notFound().build();
            } else {
                System.out.println("Retornando todos os campeonatos");
                return ResponseEntity.ok(campeonatos);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/campeonato")
    public ResponseEntity<List<RespostaFutebola>> getCampeonato(@RequestParam int id) {
        try {
            System.out.println("Recebendo Campeonato id: " + id);
            List<RespostaFutebola> tabela = campeonatoService.getEndereco(id);

            if (tabela == null || tabela.isEmpty()) {
                System.out.println("Tabela retornou nula ou vazia");
                return ResponseEntity.notFound().build();
            } else {
                System.out.println("Retornando dados da tabela");
                return ResponseEntity.ok(tabela);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    /*
    @GetMapping("/campeonato")
    public ResponseEntity<List<RespostaFutebola.CampeonatoResponse>> getCampeonato(@RequestParam int id) {
        try {
            System.out.println("Recebendo Campeonato id: " + id);
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

     */

    @GetMapping("/times")
    public ResponseEntity<Time> getTime(@RequestParam int timeId){
        try{
            System.out.println("Rececendo time id: " + timeId);
            Time time = campeonatoService.getTime(timeId);

            // Verificando se o retorno está vindo nulo ou vazio
            if (time == null) {
                System.out.println("Campeonatos retornaram nulos ou vazios");
                return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
            } else {
                System.out.println("Retornando dados do campeonato");
                return ResponseEntity.ok(time); // Retorna 200 OK com os dados
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
