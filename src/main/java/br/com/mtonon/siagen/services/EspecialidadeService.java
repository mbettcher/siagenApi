package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public Especialidade find(Integer id) {
		Optional<Especialidade> obj = especialidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Especialidade.class.getName()));
	}
	
	
	public List<Especialidade> findAll() {
		return especialidadeRepository.findAll();
	}
	
	
	public Especialidade save(Especialidade obj) {
		obj.setId(null);
		return especialidadeRepository.save(obj);
	}

}
