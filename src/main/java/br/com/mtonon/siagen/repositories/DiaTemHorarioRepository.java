package br.com.mtonon.siagen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.siagen.domain.DiaTemHorario;

@Repository
public interface DiaTemHorarioRepository extends JpaRepository<DiaTemHorario, Integer>{

}
