package com.example.projeto01.Controllers;

import com.example.projeto01.Campeonato;
import com.example.projeto01.Services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/futebola")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping("/campeonato")
    public String getCampeonato(@RequestParam int id){
        return campeonatoService.getCampeonatoById(id);
    }
}
