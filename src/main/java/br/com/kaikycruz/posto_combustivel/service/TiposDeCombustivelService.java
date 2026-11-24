package br.com.kaikycruz.posto_combustivel.service;

import br.com.kaikycruz.posto_combustivel.database.model.TiposDeCombustivel;
import br.com.kaikycruz.posto_combustivel.database.repository.TipoDeCombustivelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TiposDeCombustivelService {

    private final TipoDeCombustivelRepository repository;

    public void create(TiposDeCombustivel tiposDeCombustivel) {
        repository.save(tiposDeCombustivel);
    }

    public TiposDeCombustivel findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(("Tipo de combustível não encontrado" + id)));
    }

    public List<TiposDeCombustivel> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void update(Integer id, TiposDeCombustivel tiposDeCombustivel) {
        TiposDeCombustivel combustivel = findById(id);
        tiposDeCombustivel.setId(combustivel.getId());
        repository.save(tiposDeCombustivel);
    }
}
