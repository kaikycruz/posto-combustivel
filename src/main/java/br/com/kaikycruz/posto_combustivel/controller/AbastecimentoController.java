package br.com.kaikycruz.posto_combustivel.controller;

import br.com.kaikycruz.posto_combustivel.database.model.Abastecimento;
import br.com.kaikycruz.posto_combustivel.service.AbastecimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abastecimento")
public class AbastecimentoController {
    private final AbastecimentoService service;

    @PostMapping
    public ResponseEntity<Void> abastecer(@RequestParam("quantidadeEmLitros") Long litros,
                                          @RequestParam("idBomba") Integer idBomba) {
        service.abastecer(idBomba, litros);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Abastecimento>> buscarAbastecimentos() {
        return ResponseEntity.ok(service.findAll());
    }
}
