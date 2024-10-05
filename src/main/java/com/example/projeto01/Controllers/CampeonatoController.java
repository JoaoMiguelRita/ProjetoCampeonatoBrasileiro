package com.example.projeto01.Controllers;

import com.example.projeto01.CampeonatoEspecifico.RespostaFutebola;
import com.example.projeto01.InfAtleta.Atleta;
import com.example.projeto01.ListaCampeonatos.Campeonatos;
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
    public String getCampeonatos(){
        try {
            System.out.println("Recebendo todos campeonatos");
            List<Campeonatos> campeonatos = campeonatoService.getTodosCampeonatos();
            StringBuilder mensagens = new StringBuilder();
            for (Campeonatos resposta : campeonatos) {
                mensagens.append(resposta.formatarMensagemCampeonato(resposta)).append("\n\n");
            }
            if (campeonatos == null || campeonatos.isEmpty()) {
                System.out.println("Campeonatos retornou vazio.");
                return null; /* ResponseEntity.notFound().build(); */
            } else {
                System.out.println("Campeonatos retornou vazio.");
                return mensagens.toString(); /* return ResponseEntity.ok(tabela); */
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; /*return ResponseEntity.internalServerError().build();*/
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



}
