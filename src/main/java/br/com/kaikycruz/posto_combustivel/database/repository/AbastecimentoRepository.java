package br.com.kaikycruz.posto_combustivel.database.repository;

import br.com.kaikycruz.posto_combustivel.database.model.Abastecimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {
}
