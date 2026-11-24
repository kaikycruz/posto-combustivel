package br.com.kaikycruz.posto_combustivel.database.repository;

import br.com.kaikycruz.posto_combustivel.database.model.TiposDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeCombustivelRepository extends JpaRepository<TiposDeCombustivel, Integer> {
}
