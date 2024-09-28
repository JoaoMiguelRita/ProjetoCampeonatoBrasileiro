package com.example.projeto01.Controllers;

import com.example.projeto01.CampeonatoEspecifico.RespostaFutebola;
import com.example.projeto01.InfAtleta.Atleta;
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
    public String getCampeonato(@RequestParam int id){
    /*   public ResponseEntity<List<RespostaFutebola>> getCampeonato(@RequestParam int id) {   */
        try {
            System.out.println("Recebendo Campeonato id: " + id);
            List<RespostaFutebola> tabela = campeonatoService.getEndereco(id);

            StringBuilder mensagens = new StringBuilder();
            for (RespostaFutebola resposta : tabela) {
                mensagens.append(resposta.formatarMensagemCampeonatoEspecifico()).append("\n\n");
            }

            if (tabela == null || tabela.isEmpty()) {
                System.out.println("Tabela retornou nula ou vazia");
                return null; /* ResponseEntity.notFound().build(); */
            } else {
                System.out.println("Retornando dados da tabela");
                return mensagens.toString(); /* return ResponseEntity.ok(tabela); */
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; /*return ResponseEntity.internalServerError().build();*/
        }
    }


    @GetMapping("/time")
    public String getTime(@RequestParam int id){
        try{
            System.out.println("Rececendo time id: " + id);

            Time time = campeonatoService.getTime(id);
            if (time != null) {
                return time.formatarMensagemTime(time);
            } else {
                return "<h3>Time não encontrado!</h3>";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/atleta")
    public String getAtleta(@RequestParam int id){
        try{
            System.out.println("Rececendo Atleta id: " + id);

            Atleta atleta = campeonatoService.getAtleta(id);
            if (atleta != null) {
                return atleta.formatarMensagemAtleta(atleta);
            } else {
                return "<h3>Atleta não encontrado!</h3>";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
