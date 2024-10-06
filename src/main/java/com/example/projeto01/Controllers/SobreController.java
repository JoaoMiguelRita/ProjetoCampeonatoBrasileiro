package com.example.projeto01.Controllers;

import com.example.projeto01.Services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class SobreController {
    @RequestMapping("/sobre")
    public Map<String, String> sobre() {
        Map<String, String> resposta = new LinkedHashMap<>();
        resposta.put("estudante", "João Miguel Fortunato Rita");
        resposta.put("projeto", "ProjetoCampeonatoBrasileiro");

        return resposta;
    }
}
