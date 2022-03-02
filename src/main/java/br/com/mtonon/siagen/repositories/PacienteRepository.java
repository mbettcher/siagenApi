package br.com.mtonon.siagen.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{
	
	@Transactional(readOnly=true)
	Paciente findByCpf(String cpf);

}
