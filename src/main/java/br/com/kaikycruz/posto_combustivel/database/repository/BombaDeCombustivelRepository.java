package br.com.kaikycruz.posto_combustivel.database.repository;

import br.com.kaikycruz.posto_combustivel.database.model.BombasDeCombustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BombaDeCombustivelRepository extends JpaRepository<BombasDeCombustivel, Integer> {
}
