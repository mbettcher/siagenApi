package br.com.mtonon.siagen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtonon.siagen.domain.Funcionamento;

@Repository
public interface FuncionamentoRepository extends JpaRepository<Funcionamento, Integer> {

}
