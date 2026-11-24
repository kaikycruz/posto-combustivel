package br.com.kaikycruz.posto_combustivel.service;

import br.com.kaikycruz.posto_combustivel.database.model.BombasDeCombustivel;
import br.com.kaikycruz.posto_combustivel.database.repository.BombaDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BombaDeCombustivelService {

    private final BombaDeCombustivelRepository repository;

    public void create(BombasDeCombustivel bombaDeCombustivel) {
        repository.save(bombaDeCombustivel);
    }

    public BombasDeCombustivel findById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Bomba de combustível não encontrada" + id));
    }

    public List<BombasDeCombustivel> findAll() {
        return  repository.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void update(Integer id, BombasDeCombustivel bombasDeCombustivel) {
        BombasDeCombustivel bomba = findById(id);
        bombasDeCombustivel.setId(bomba.getId());
        repository.save(bombasDeCombustivel);
    }

}
