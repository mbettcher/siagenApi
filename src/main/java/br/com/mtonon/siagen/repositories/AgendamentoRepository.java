package br.com.mtonon.siagen.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.domain.Paciente;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer>{

	@Transactional(readOnly=true)
	Page<Agendamento> findByPacienteAgendamento(Paciente paciente, Pageable pageRequest);

}
