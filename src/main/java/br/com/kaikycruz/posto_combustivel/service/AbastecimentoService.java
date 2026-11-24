package br.com.kaikycruz.posto_combustivel.service;

import br.com.kaikycruz.posto_combustivel.database.model.Abastecimento;
import br.com.kaikycruz.posto_combustivel.database.model.BombasDeCombustivel;
import br.com.kaikycruz.posto_combustivel.database.repository.AbastecimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AbastecimentoService {

    private final AbastecimentoRepository repository;
    private final BombaDeCombustivelService bombaDeCombustivelService;

    public void abastecer(Integer idBomba, Long litros) {
        BombasDeCombustivel bomba = bombaDeCombustivelService.findById(idBomba);
        BigDecimal valorTotal = bomba.getTipoCombustivel()
                .getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));
        Abastecimento abastecimento = Abastecimento.builder()
                .dataAbastecimento(LocalDate.now())
                .bombaDeCombustivel(bomba)
                .valorTotal(valorTotal)
                .quantidadeLitros(litros)
                .build();

        repository.save(abastecimento);
    }

    public List<Abastecimento> findAll() {
        return repository.findAll();
    }

}
