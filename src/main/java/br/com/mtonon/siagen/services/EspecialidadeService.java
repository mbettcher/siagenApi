package br.com.mtonon.siagen.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository repo;

	public Especialidade buscar(Integer id) {
		Optional<Especialidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Especialidade.class.getName()));
	}

}
