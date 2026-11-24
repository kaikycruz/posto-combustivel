package br.com.kaikycruz.posto_combustivel.controller;

import br.com.kaikycruz.posto_combustivel.database.model.BombasDeCombustivel;
import br.com.kaikycruz.posto_combustivel.service.BombaDeCombustivelService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bombasDeCombustivel")
public class BombasDeCombustivelController {

    private final BombaDeCombustivelService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BombasDeCombustivel bombasDeCombustivel) {
        service.create(bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BombasDeCombustivel>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BombasDeCombustivel> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody BombasDeCombustivel bombasDeCombustivel,
                                       @RequestParam(name = "id") Integer id) {
        service.update(id, bombasDeCombustivel);
        return ResponseEntity.ok().build();
    }

}
