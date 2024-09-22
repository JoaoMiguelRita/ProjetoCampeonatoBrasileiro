package com.example.projeto01.Controllers;

import com.example.projeto01.Campeonato;
import com.example.projeto01.Services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/futebola")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping("/campeonato")
    public Campeonato getCampeonato(@RequestParam int id){
        try {
            // Log para garantir que o ID foi recebido corretamente
            System.out.println("Recebendo ID: " + id);
            Campeonato campeonato = campeonatoService.getEndereco(id);

            // Verificando se o retorno está vindo nulo
            if (campeonato == null) {
                System.out.println("Campeonato retornou nulo");
            } else {
                System.out.println("Retornando dados do campeonato");
            }

            // Retornar o objeto que será convertido para JSON automaticamente pelo Spring Boot
            return campeonato;
        } catch (Exception e) {
            e.printStackTrace();
            // Retorna nulo em caso de erro para indicar que algo falhou
            return null;
        }
    }
}
