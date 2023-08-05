package br.com.mtonon.siagen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.siagen.domain.DiaSemana;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Integer> {

}
