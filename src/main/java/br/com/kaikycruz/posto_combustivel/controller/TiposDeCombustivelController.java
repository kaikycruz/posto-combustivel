package br.com.kaikycruz.posto_combustivel.controller;

import br.com.kaikycruz.posto_combustivel.database.model.TiposDeCombustivel;
import br.com.kaikycruz.posto_combustivel.service.TiposDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tiposDeCombustivel")
public class TiposDeCombustivelController {

    private final TiposDeCombustivelService service;

    @PostMapping
    public ResponseEntity<Void> createTiposCombustivel(@RequestBody TiposDeCombustivel tiposDeCombustivel) {
        service.create(tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TiposDeCombustivel>> getAllTiposCombustivel() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiposDeCombustivel> getTiposDeCombustivelById(@PathVariable Integer id) {
     return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTiposDeCombustivelById(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateTiposCombustivel(@RequestBody TiposDeCombustivel tiposDeCombustivel,
                                                       @RequestParam(name = "id") Integer id) {
        service.update(id, tiposDeCombustivel);
        return ResponseEntity.ok().build();
    }
}
