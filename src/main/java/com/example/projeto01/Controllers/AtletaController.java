package com.example.projeto01.Controllers;

import com.example.projeto01.CampeonatoEspecifico.Posicao;
import com.example.projeto01.InfAtleta.Atleta;
import com.example.projeto01.InfAtleta.PosicaoAtleta;
import com.example.projeto01.Services.AtletaService;
import com.example.projeto01.Services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/atletas")
public class AtletaController {
    @Autowired
    private AtletaService atletaService;


    private List<Atleta> atletas = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> adicionarAtleta(@RequestParam int id,
                                                  @RequestParam String nome_popular,
                                                  @RequestParam String nome,
                                                  @RequestParam String sigla,
                                                  @RequestParam String nomePosicao
    ) {
        try {
            PosicaoAtleta posicao = new PosicaoAtleta();
            posicao.setSigla(sigla);
            posicao.setNomePosicao(nomePosicao);

            Atleta atleta = new Atleta();
            atleta.setAtletaId(id);
            atleta.setNome_popular(nome_popular);
            atleta.setNome(nome);
            atleta.setPosicao(posicao);

            atletas.add(atleta);
            return ResponseEntity.ok("Atleta adicionado com sucesso: " + atleta.getNome());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao adicionar atleta: " + e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public String getAtleta(@RequestParam int id){
        try{
            System.out.println("Rececendo Atleta id: " + id);
            Atleta atleta = atletaService.getAtleta(id);
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
